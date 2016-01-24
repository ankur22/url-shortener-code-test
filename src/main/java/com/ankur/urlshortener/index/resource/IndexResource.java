package com.ankur.urlshortener.index.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class IndexResource {

    @RequestMapping("/")
    String getIndexPage() {
        return "index";
    }
}
