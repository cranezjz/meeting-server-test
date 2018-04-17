/**
 * 
 */
package com.zjz.meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: MeetBaseInfoTests.java</p>  
 * <p>Description: </p>  
 * @author zhaojz
 * @date 2018年4月13日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetBaseInfoTests {
	@Value(value = "${baseUrl}")
	private String baseUrl;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void query() throws Exception {
        //装配post请求参数
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
        list.add(new BasicNameValuePair("pageNum", "0"));  //请求参数
        //list.add(new BasicNameValuePair("name", "1")); //请求参数
        list.add(new BasicNameValuePair("stt", "10")); //请求参数
        Map<String,Object> map = MyHttpClient.post("/meet/query", list);
        System.out.println(map);
        ArrayList<?> record = (ArrayList<?>)map.get("content");
        System.out.println("返回的记录数："+record.size());
	}
}
