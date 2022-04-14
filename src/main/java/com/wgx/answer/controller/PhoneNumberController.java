package com.wgx.answer.controller;

import com.wgx.answer.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:wgx
 * version:1.0
 */
@Controller
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;
    @Autowired
    private RedisTemplate redisTemplate;

    //百度接口用不了
    String url = "http://localhost";

    @GetMapping("/queryPhoneNumber")
    @ResponseBody
    public String queryPhoneNumber(@RequestParam("tel") String tel) {
        //先去Redis查询缓存,没有就添加缓存
        String result = (String) redisTemplate.opsForValue().get(url);
        if (result != null) {
            return result;
        }
        String response = phoneNumberService.query(url);
        redisTemplate.opsForValue().set(url, response);
        return response;
    }
}
