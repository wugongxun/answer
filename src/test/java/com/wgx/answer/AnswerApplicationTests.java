package com.wgx.answer;

import com.wgx.answer.service.PhoneNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnswerApplicationTests {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    void contextLoads() {

    }

    @Test
    public void test() {
        String response = phoneNumberService.query("http://localhost");
        System.out.println(response);
    }

}
