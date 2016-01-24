package com.ankur.urlshortner.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    public static final String HELLO_WORLD = "Hello World!";

    @RequestMapping("/hello-world")
    String home() {
        return HELLO_WORLD;
    }
}
