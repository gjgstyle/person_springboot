package com.pratice.eurekaclient.http;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

	Logger logger = LoggerFactory.getLogger(HttpClient.class);

	@Autowired
	RestTemplate restTemplate;

    public String getUrlReturn(String url, Map<String, String> headerMap, Map<String, String> paramsMap) {
        // 设置请求头：遍历headerMap请求头集合，设置到requestHeaders
        HttpHeaders requestHeaders = new HttpHeaders();
        for (String headerName : headerMap.keySet()) {
            requestHeaders.add(headerName, headerMap.get(headerName));
        }
        // 设置请求体：遍历paramsMap参数集合，设置到requestBody
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        for (String params : paramsMap.keySet()) {
            requestBody.add(params, paramsMap.get(params));
        }
        // 组合请求头和请求体为请求对象requestEntity
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        String returnStr = null;
        try {
            // 通过跨域restTemplate远程请求接口，返回远程接口响应结果
            returnStr = this.restTemplate.postForObject(url, requestEntity, String.class);
            logger.info("HttpClient|getUrlReturn|url= + " + url + "|returnStr=" + returnStr);
            return returnStr;
        } catch (Exception e) {
            logger.info("HttpClient|getUrlReturn|服务器通信错误|Exception=" + e.getMessage());
        }
        return returnStr;
    }
}
