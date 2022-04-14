package com.wgx.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * author:wgx
 * version:1.0
 */
@Controller
public class ViewController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
