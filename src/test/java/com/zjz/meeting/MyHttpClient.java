package com.zjz.meeting;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MyHttpClient {
	private static String baseUrl="http://127.0.0.1:9080";
	
    public static Map<String,Object> post(String url,List<BasicNameValuePair> list) {
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	//配置超时时间
    	RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(3000).setConnectionRequestTimeout(5000)
                .setSocketTimeout(25000).setRedirectsEnabled(true).build();
    	 UrlEncodedFormEntity entity;
    	 Map<String,Object> map =null;
		try {
			entity = new UrlEncodedFormEntity(list,"UTF-8");
	    	 HttpPost httpPost = new HttpPost(baseUrl+url);
	         //设置超时时间
	         httpPost.setConfig(requestConfig);
	         //设置post求情参数
	         httpPost.setEntity(entity);
	         HttpResponse httpResponse = httpClient.execute(httpPost);
	         String strResult = "";
	         if(httpResponse != null){ 
	             System.out.println(httpResponse.getStatusLine().getStatusCode());
	             if (httpResponse.getStatusLine().getStatusCode() == 200) {
	                 strResult = EntityUtils.toString(httpResponse.getEntity());
	                 map = new Gson().fromJson(strResult, new TypeToken<HashMap<String,Object>>(){}.getType()); 
	             }else {
	                 strResult = "Error Response: " + httpResponse.getStatusLine().toString();
	             } 
	         }else{
	         	System.out.println("服务端返回的内容为null");
	         }
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         return map;
    }

}
