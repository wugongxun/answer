package com.wgx.answer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * author:wgx
 * version:1.0
 */
@Service
public class PhoneNumberService {
    @Autowired
    RestTemplate restTemplate;

    public String query(String url) {
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
