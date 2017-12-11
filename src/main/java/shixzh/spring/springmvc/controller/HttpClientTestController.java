package shixzh.spring.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import shixzh.spring.springmvc.model.BaseResult;
import shixzh.spring.springmvc.model.HttpClientTestResult;
import shixzh.spring.springmvc.service.HttpClientTestBo;

@RequestMapping("http_client")
@Controller
public class HttpClientTestController {

    @Autowired
    private HttpClientTestBo httpClientTestBo;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public BaseResult doPost(@RequestBody HttpClientTestResult result) {
        HttpClientTestResult testPost = httpClientTestBo.testPost(result);
        return testPost;
    }
}
