package com.ankur.urlshortener.index.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexResource {

    @RequestMapping("/")
    String getIndexPage() {
        return "index";
    }
}
