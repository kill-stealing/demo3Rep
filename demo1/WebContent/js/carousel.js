/**
 
	Carousel plug-in (slick carousel) pre-processor. 
	<br />
	<br />Sets defaults for the slick carousel plug-in, and other random processing. Then it inits the jQuery slick carousel plug-in. 
	<br />
	<br />Each immediate child element in a carousel widget is a carousel "panel".
	<br />
	<br />Usage:
	
	<div data-widget="carousel"> 
		...
	</div>
 
	__Special case:__ In scenarios where you dynamically inject HTML post page load, you can initialize the widget on your injected container like this:
	
	jQuery("<your_carousel_container_selector>").carousel(optionalSettingsObject);
	
 
	<br />Allowed options and values. __All values are strings__ (html standards):
	<br />__data-widget__: carousel
	<br />__data-arrows__: true (default) | false  &nbsp; // Enables arrows navigation
	<br />__data-autoplay__: true | false (default)  &nbsp; // Enables autoplay/scrolling of carousel
	<br />__data-dots__: true (default) | false  &nbsp; // Enables dots navigation instead of the slide count
	<br />__data-infinite__: true | false (default)  &nbsp; // Enables infinite loop controls
	<br />__data-randomfirst__: true | false (default)  &nbsp; // Moves a random panel to be first
	<br />__data-slidecount__: true | false (default)  &nbsp; // Show the slide count instead of dots
	<br />
	<br />Apis are available to control the carousel with JS. 
	<br /><br />Full official documentation is at <a href="http://kenwheeler.github.io/slick" target="_blank">http://kenwheeler.github.io/slick</a>.
	<br />
	<br />Some popular API uses:
		
	// Add a panel to the carousel, in position 0, before it:
	jQuery("<your_carousel_container_selector>").slick("slickAdd", "<p>This is some text<p>", 0, true);
		
	// Remove the second panel from the carousel
	jQuery("<your_carousel_container_selector>").slick("slickRemove", 1);
		
	// Goto the third panel in the carousel
	jQuery("<your_carousel_container_selector>").slick("slickGoTo", 2);
	
	@class IBMCore.common.widget.carousel
 
**/
 
(function ($, IBM) {
 
    var me = IBM.namespace(IBM, "common.widget.carousel"),
    	carousels = [],
		object_name = "Carousel";
 
	/**
		Public jQuery plug-in definition.
		<br />Used by core v18 JS file to auto-init carousels HTML that exist on the page on DOM ready.
		<br />If you are dynamically injecting your widget HTML after onload, call this plug-in on your injected carousel container.
 
		@method $.fn.carousel
		@param [settings] {Object} Settings to override defaults and element's @data-xxxx attributes.
	**/
	$.fn.carousel = function (settings) {
		return this.each(function(){
			var newCarousel = createCarousel(settings);
			
			newCarousel.init($(this));
		});
	};
 
	/**
		Called by our jQuery plug-in.
		<br />This creates a new carousel object and registers the instance into array of all this widget instances.
		<br />The jQuery plugin abstracts this and makes behind-the-scenes changes easy.
		
		@method createCarousel
		@private
		@param [settings] {Object} Settings to override defaults and element's @data-xxxx attributes.
		@return {Object} The carousel widget instance created.
	**/
	function createCarousel (settings) {
		var widget = new Carousel(settings);
		
		carousels.push(widget);
		
		return widget;
	}
	
	/**
		Publishes this event if there was an error creating the widget.
		
		@event error
	**/
	/**
		Publishes this event after the widget has been created successfully.
		
		@event ready
	**/
	/**
		Carousel object/constructor for our public jQuery plugin.
		<br />Called by "createCarousel".
		<br />You can't use this directly. Use the standard jQuery(xxxx).carousel() plug-in method to dynamically init and create a carousel.
 
		@method Carousel
		@constructor
		@param [settings] {Object} Settings to override defaults and element's @data-xxxx attributes.
		@example
			// You can access your widget object that was created (this) using the standard convention:
			jQuery("<your_carousel_container_selector>").data("widget");
	**/
	function Carousel (settings) {
		var me = this,
			$container,
			config,
			defaults = {
				adaptiveheight: false,
				arrows: true,
				autoplay: false,
				autoplayspeed: 6000,
				dots: true,
				easing: "swing",
				infinite: false,
                prevArrow: '<button type="button" data-role="none" class="ibm-chevron-left-regular-link ibm-linkcolor-default ibm-carousel-prev" aria-label="previous">Previous</button>',
                nextArrow: '<button type="button" data-role="none" class="ibm-chevron-right-regular-link ibm-linkcolor-default ibm-carousel-next" aria-label="next">Next</button>',
                randomfirst: false,
				slidecount: false,
                speed: 275,
                variablewidth: false,
				rtl: document.documentElement.getAttribute("dir") === "rtl"
			},
			defaultSlickCallbacks,
			myEvents = IBM.common.util.eventCoordinator(me, object_name, [
				"ready",
				"error"
			]);
 
	    /**
			This is a method of the "Carousel" constructor.
			<br />Called by our public jQuery plug-in after a new Carousel object has been created and returned by "createCarousel".
			<br />Automatically inits the carousel plug-in (slick carousel) on the passed element, 
			merging in any manually passed settings, @data-xxxxx settings, and our default settings. 
			
			@method Carousel.init
			@param {jQuery selector} $elem The element you want to turn into a carousel.
		**/
		me.init = init;
		function init ($elem) {
			try {
				// Binds widget object to the DOM element it was init on by jQuery plugin method.
				// Keep "instance" as-is; ALL element-bound widgets will use this data attribute.
				$elem.data("widget", me);
 
				$container = $elem;
 
				// Merge settings and setup config.
				mergeSettings();
 
				// Randomly move one to the front if config set.
				if (config.randomfirst) {
					randomizeFirstPanel();
				}
 
				// If they want the slide count instead of dots, bind the init and change event to update the counter.
				if (config.slidecount) {
					$container.on("init reInit afterChange", function (event, slick, currentSlide, nextSlide) {
						var i = (currentSlide ? currentSlide : 0) + 1;
						defaults.appendDots.addClass("ibm-h4").text(i + " / " + slick.slideCount);
					});
				}
 
				// Init the slick carousel.
				initHtml();
 
				// Fire an event to tell subscribers we're done.
				myEvents.publish("ready", $elem);
			} 
			catch (er) {
				myEvents.publish("error", er);
				throw er;
			}
		}
 
		/**
			This sets up the config and HTML for init'ing.
 
			@method mergeSettings
			@private
		**/
		function mergeSettings () {
			defaultSlickCallbacks = {
				onInit: function(slick) {
					slick.$slider.addClass("ibm-carousel");
				}
			};
 
			// If it's normal controls, our placement for controls is under the carousel so we only alter the location.
			// Else use the default placement for the "large" chevrons.
 
			// For non-large controls, add the custom container for the controls (not large ones).
			if ($container[0].className.indexOf("ibm-carousel__arrows--large") === -1) {
				$container.after('<div class="ibm-carousel-controls"><div class="ibm-cc-prev"></div><div class="ibm-cc-middle"></div><div class="ibm-cc-next"></div></div>');
				defaults.appendDots = $container.next().children("div:eq(1)");
				defaults.appendArrows = $container.next().children("div:eq(0)");
			}
 
 
			// Merge configs then dupe for camelcase settings in case they didn't do it with "-"s.
			config = $.extend(true, {}, defaults, defaultSlickCallbacks, ($container.data() || {}), settings);
			config.adaptiveHeight = config.adaptiveheight;
			config.autoplaySpeed = config.autoplayspeed;
			config.variableWidth = config.variablewidth;
			
			// If you don't have large arrows, you have to have dots (default) or slide count.
			if ($container[0].className.indexOf("ibm-carousel__arrows--large") === -1 && !config.dots && !config.slidecount) {
				config.dots = true;
			}
		}
 
		/**
			This is called if randomize setting is used on carousel. Picks a random slide and MOVES it to be the first one.
 
			@method randomizeFirstPanel
			@private
		**/
		function randomizeFirstPanel () {
			var rand = Math.floor(Math.random() * $container.children().length);
			$container.children(":eq("+rand+")").prependTo($container);
		}
 
		/**
			This does the actual slick carousel init'ing.
 
			@method initHtml
			@private
		**/
		function initHtml () {
			$container.slick(config);
			
			// For large arrows we don't create a custom control container and move the controls, they stay default.
			if ($container[0].className.indexOf("ibm-carousel__arrows--large") === -1) {
				// Move the "next" arrow to the right div.
				config.appendArrows.find(".ibm-carousel-next").appendTo(config.appendDots.next());
 
				// Move the controls into the container AFTER SLICK INIT so they don't get processed as a panel.
				$container.next().appendTo($container);
			}
		}
	}
 
})(jQuery, IBMCore);
 