package com.ibm.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TextToSpeechTest {
	
	public InputStream teToSpe(String text){
		
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("be0d4003-07cc-45e7-baf5-c8c2c83acff7",
				"gX8R8oL8QgS0");
		
		InputStream input = service.synthesize(text, "audio/wav");
		
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword("be0d4003-07cc-45e7-baf5-c8c2c83acff7",
				"gX8R8oL8QgS0");
		String text = "I have been assigned to handle your order status request. "
				+ "I am sorry to inform you that the items you requested are back-ordered. "
				+ "We apologize for the inconvenience. We don't know when those items will become available. "
				+ "Maybe next week but we are not sure at this time. "
				+ "Because we want you to be a happy customer, management has decided to give you a 50% discount!";
		String text1="妊娠 自分 一つ の 角 くん";
		List<Voice> voicelist= service.getVoices();
		for(Voice voice:voicelist){
			System.out.println(voice);
		}
		
		InputStream input = service.synthesize(text1, "audio/wav");
		File file = new File("C:\\test\\textToSpeech.wav");
		try {
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = input.read(buffer, 0, 1024)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
