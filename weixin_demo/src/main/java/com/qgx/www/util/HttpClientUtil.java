package com.qgx.www.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 发送短信的工具类
 */
public class HttpClientUtil {
	static  Boolean isTest=true;
	public static String postJson(String url, String body, String charset) {
		
		String result = null;
		
		if (isTest) {
			if (null == charset) {
				charset = "UTF-8";
			}
			CloseableHttpClient httpClient = null;
			HttpPost httpPost = null;
			try {
				httpClient = HttpConnectionManager.getInstance().getHttpClient();
				httpPost = new HttpPost(url);
				
				// 设置连接超时,设置读取超时
				RequestConfig requestConfig = RequestConfig.custom()
						.setConnectTimeout(10000)	
		                .setSocketTimeout(10000)	
		                .build();
				httpPost.setConfig(requestConfig);
				
				httpPost.setHeader("Accept", "application/json");
				httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
				
				// 设置参数
				StringEntity se = new StringEntity(body, "UTF-8");
				httpPost.setEntity(se);
				HttpResponse response = httpClient.execute(httpPost);
				if (response != null) {
					HttpEntity resEntity = response.getEntity();
					if (resEntity != null) {
						result = EntityUtils.toString(resEntity, charset);
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			result = "config.properties中 is_test 属性值为false, 若已正确设置请求值，请设置为true后再次测试";
		}
		
		return result;
	}



	public static String getJson(String url){
		String result= "";
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpClient httpClient = HttpConnectionManager.getInstance().getHttpClient();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result=EntityUtils.toString(entity,"UTF-8");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			httpGet.releaseConnection();
		}
		return result;
	}

}
