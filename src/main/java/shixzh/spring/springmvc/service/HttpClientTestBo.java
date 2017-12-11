package shixzh.spring.springmvc.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import shixzh.spring.springmvc.model.HttpClientTestResult;
import shixzh.spring.springmvc.util.JsonHttpClientUtil;
import shixzh.spring.springmvc.util.RequestIdUtil;

@Service
public class HttpClientTestBo {

    private static Logger logger = LoggerFactory.getLogger(HttpClientTestBo.class);

    @Value("${test_http_client_url}")
    private String testHttpClientUrl;

    public HttpClientTestResult testPost(HttpClientTestResult result) {
        logger.info(JSONObject.toJSONString(result));
        result.setCount(result.getCount() + 1);
        if (result.getCount() <= 3) {
            Map<String, String> headerMap = new HashMap<String, String>();
            String requestId = RequestIdUtil.requestIdThreadLocal.get();
            headerMap.put(RequestIdUtil.REQUEST_ID_KEY, requestId);
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("status", result.getStatus() + "");
            paramMap.put("errorCode", result.getErrorCode());
            paramMap.put("message", result.getMessage());
            paramMap.put("count", result.getCount() + "");
            String resultString = JsonHttpClientUtil.post(testHttpClientUrl, headerMap, paramMap, "UTF-8");
            logger.info(resultString);
        }

        logger.info(JSONObject.toJSONString(result));
        return result;
    }
}
