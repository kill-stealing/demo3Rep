package com.ibm.demo;

import java.util.List;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiedLanguage;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationModel;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

public class LanguageTranslationTest {
	
	public String languageTranslationMethod(String text){
		LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword("c670cb0a-e46c-41b8-ac3f-d3af3bb148a1","1qqXGZn5AzGz");
		
		TranslationResult result = service.translate(text, "zh-en-patent");
		return result.getTranslations().get(0).getTranslation();
	}

	public static void main(String[] args) {
		LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword("c670cb0a-e46c-41b8-ac3f-d3af3bb148a1","1qqXGZn5AzGz");
//		List <IdentifiableLanguage> langs = service.getIdentifiableLanguages();
//		System.out.println(langs);
//		TranslationResult result = service.translate("您好", "zh-TW", "en");
//		System.out.println(result);
//		List <TranslationModel> models = service.getModels();
//		System.out.println(models);
//		
		
		List <IdentifiedLanguage> langs = service.identify("如果您已经把我们的");
		System.out.println(langs);
		
//		如果您已经把我们的 JavaScript 教程学习完毕，并且需要更深入地学习这门语言，那么 w3school 提供的 《JavaScript 高级教程》绝对是您最好的选择。
//
//		本教程从 JavaScript 的历史开始讲起，直到当前它对 XML 和 Web 服务的支持。
//
//		您将学习到如何扩展该语言，以使它适应特殊的需求。
//
//		您还将学到如何使用 JavaScript 创建无缝的客户机 - 服务器通信。
//
//		本教程深入浅出，在您认真学习之后，一定会获益良多。
		
		TranslationResult result = service.translate("如果您已经把我们的 JavaScript 教程学习完毕，并且需要更深入地学习这门语言，那么 w3school 提供的 《JavaScript 高级教程》绝对是您最好的选择。"
				+"本教程从 JavaScript 的历史开始讲起，直到当前它对 XML 和 Web 服务的支持。"
				+"您将学习到如何扩展该语言，以使它适应特殊的需求。"
				+"您还将学到如何使用 JavaScript 创建无缝的客户机 - 服务器通信。"
				+"本教程深入浅出，在您认真学习之后，一定会获益良多。", "zh-en-patent");
		System.out.println(result.getTranslations().get(0).getTranslation());
	}

}
