package com.ibm.demo;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
  
public class TestPost {  
    public static void main(String args[]) throws Exception {  
          
        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());  
        multipartEntity.addPart("type",new StringBody("speechToText", Charset.forName("UTF-8")));    
        multipartEntity.addPart("receiver",new StringBody("138***********",Charset.forName("UTF-8")));  
        String filePath = "C:\\test\\English.wav";
		File file=new File(filePath);
        
        multipartEntity.addPart("image",new FileBody(file,"audio/wav"));    
            
        HttpPost request = new HttpPost("https://convertdemo.mybluemix.net/helloworld");     
        request.setEntity(multipartEntity);
        
        request.addHeader("Content-Type","multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");  
          
        DefaultHttpClient httpClient = new DefaultHttpClient();  
        HttpResponse response =httpClient.execute(request);  
          
        InputStream is = response.getEntity().getContent();  
        BufferedReader in = new BufferedReader(new InputStreamReader(is));  
        StringBuffer buffer = new StringBuffer();  
        String line = "";  
        while ((line = in.readLine()) != null) {  
            buffer.append(line);  
        }  
          
        System.out.println("发送消息收到的返回："+buffer.toString());  
    }  
}  
