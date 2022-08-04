package ru.aston.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//Или
@RestController
public class HelloController {

    @Value("${constant.line}")
    private String line;


    @GetMapping("/hello")
    @ResponseBody
    public String getHello() {
        return "2 + 2 = 22, F*ck JS";
    }

    @GetMapping("/value")
    @ResponseBody
    public String getConstant() {
        return line;
    }
}
