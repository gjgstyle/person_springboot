package com.pratice.eurekaclient.controller;

import com.pratice.eurekaclient.http.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);

	final String EDIT_USER_MESSAGE_STATUS = "http://localhost:8763/user/login";

	@Autowired
	HttpClient httpClient;

	@Value("${server.port}")
	String port;

	@RequestMapping(value="hi")
	public String hi() {
		return "my port is "+port;
	}

	/*@PostMapping("/http")
	public JSONObject editStatus(HttpServletRequest request, String userMessageId, @RequestParam(required = false) String tbStatus) {
	        Map<String, String> header = new HashMap<>();
	        Map<String, String> params = new HashMap<>();
	        // 设置远程接口请求参数
	        params.put("userMessageId", userMessageId);
	        params.put("tbStatus", tbStatus);
	        // 远程调用chat接口修改数据
	        String jsonResult = this.httpClient.getUrlReturn(EDIT_USER_MESSAGE_STATUS, header, params);
	        //JSONObject jr = JSON.parseObject(jsonResult); // String转换为JSONObject格式
	        //logger.info("HttpUtils|getUrlReturn|JsonResult= " + jr.getString("statusCode"));
	        //return jr;
	        return new JSONObject();
	  }*/
}
