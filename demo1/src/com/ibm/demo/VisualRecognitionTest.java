package com.ibm.demo;

import java.io.File;
import java.util.List;

import com.ibm.watson.developer_cloud.visual_recognition.v2.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v2.model.VisualClassifier;

public class VisualRecognitionTest {
	
	//Images must be in .jpeg, or .png format
	public static void main(String[] args) {
		//a76710f44212efbe5d5fddecbda8f667ce0a0cde
		VisualRecognition service = new VisualRecognition("2016-05-19");
		//https://gateway.watsonplatform.net/visual-recognition-beta/api/v2/classify?version=2016-05-19
		//https://watson-api-explorer.mybluemix.net/visual-recognition/api
		service.setApiKey("a76710f44212efbe5d5fddecbda8f667ce0a0cde");
		File imagesFile=new File("C:\\test4.jpeg");
		List<VisualClassifier> classifiers=service.getClassifiers();
		System.out.println(classifiers);
		VisualClassification visualClassification  =service.classify(imagesFile);
		System.out.println(visualClassification);
		
		
	}

}
