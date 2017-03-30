package com.ibm.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.speech_to_text.v1.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeDelegate;

public class SpeechToTextTest {

	// "name": "en-US_NarrowbandModel",
	// "name": "pt-BR_BroadbandModel",
	// "name": "en-UK_BroadbandModel",
	// "name": "zh-CN_BroadbandModel",
	// "name": "ja-JP_BroadbandModel",
	// "name": "pt-BR_NarrowbandModel",
	// "name": "es-ES_BroadbandModel",
	// "name": "ar-AR_BroadbandModel",
	// "name": "zh-CN_NarrowbandModel",
	// "name": "ja-JP_NarrowbandModel",
	// "name": "es-ES_NarrowbandModel",
	// "name": "en-UK_NarrowbandModel",
	// "name": "en-US_BroadbandModel",
	// "name": "en-US_BroadbandModel",

	static String username = "94576e24-7dba-49ab-a8c6-bc706f2268ce";
	static String password = "UXEDQOGzu4AD";

	public List<String> speToTe(String language,InputStream in) {
		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("94576e24-7dba-49ab-a8c6-bc706f2268ce",
				"UXEDQOGzu4AD");
		service.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");
		RecognizeOptions options = new RecognizeOptions().model(language)
				.contentType("audio/wav").continuous(true).interimResults(true);

		/*
		 * List<SpeechModel> models = service.getModels(); for(SpeechModel model
		 * : models) { System.out.println(model); } SpeechModel
		 * model1=service.getModel("en-US_BroadbandModel");
		 * System.out.println(model1);
		 */

		final List<SpeechResults> resultList = new ArrayList<SpeechResults>();

		service.recognizeUsingWebSockets(in, // section b.wav
				options, new BaseRecognizeDelegate() {
					@Override
					public void onMessage(SpeechResults speechResults) {
						resultList.add(speechResults);
					}
				});
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// new Thread(new Runnable() {
		// public void run() {
		// while (true) {
		// repaint();
		// Thread.sleep(500);
		// }
		// }
		// }).start();

		return printResult(resultList);
	}

	public static void main(String[] args) {
		SpeechToText service = new SpeechToText();
		SpeechToTextTest test = new SpeechToTextTest();
		service.setUsernameAndPassword("94576e24-7dba-49ab-a8c6-bc706f2268ce",
				"UXEDQOGzu4AD");
		service.setEndPoint("https://stream.watsonplatform.net/speech-to-text/api");

		/*List<SpeechModel> models = service.getModels();
		for (SpeechModel model : models) {
			System.out.println(model);
		}
		SpeechModel model1 = service.getModel("en-US_BroadbandModel");
		System.out.println(model1);*/

		RecognizeOptions options = new RecognizeOptions().model("zh-CN_NarrowbandModel")
				.contentType("audio/wav").continuous(true).interimResults(true);
		final List<SpeechResults> resultList = new ArrayList<SpeechResults>();
		try {
			service.recognizeUsingWebSockets(new FileInputStream(
					"C:\\test\\English1.wav"), // section b.wav
					options, new BaseRecognizeDelegate() {
						@Override
						public void onMessage(SpeechResults speechResults) {
							resultList.add(speechResults);
						}
					});
			test.printResult(resultList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String printResult1(List<SpeechResults> resultList) {
		String resultString = "";
		for (int i = 0; i < resultList.size(); i++) {
			SpeechResults speechResults = resultList.get(i);
			boolean ifFinal = speechResults.getResults().get(0).isFinal();
			if (ifFinal == true) {
				resultString = resultString
						+ speechResults.getResults().get(0).getAlternatives()
								.get(0).getTranscript() + "\n";
			}
		}
		return resultString;
	}

	public List<String> printResult(List<SpeechResults> resultList) {
		List<String> resultString = new ArrayList<String>();
		for (int i = 0; i < resultList.size(); i++) {
			SpeechResults speechResults = resultList.get(i);
			boolean ifFinal = speechResults.getResults().get(0).isFinal();
			if (ifFinal == true) {
				resultString.add(speechResults.getResults().get(0)
						.getAlternatives().get(0).getTranscript());
			}
		}
		System.out.println("resultList  " + resultList);
		System.out.println("resultString  " + resultString);
		return resultString;
	}

}
