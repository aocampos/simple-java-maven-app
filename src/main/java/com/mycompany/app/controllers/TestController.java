package com.mycompany.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void testHello() {
        System.out.println("Helllooooo");
    }
}

