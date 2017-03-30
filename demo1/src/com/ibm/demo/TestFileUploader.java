package com.ibm.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFileUploader {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", "speechToText1");
		map.put("language", "zh-CN_BroadbandModel");
		String url="https://convertdemo.mybluemix.net/helloworld";
		String url1="http://localhost:8080/helloworld";
		FileUploader.upload(url1, new File(
				"C:\\test\\Chinese.wav"), map,
				new FileUploader.FileUploadListener() {
					@Override
					public void onProgress(long pro, double precent) {
						System.out.println("precent " + precent);
					}

					@Override
					public void onFinish(int code, String res,
							Map<String, List<String>> headers) {
						System.out.println("res " + res);
					}
				});
	}
}
