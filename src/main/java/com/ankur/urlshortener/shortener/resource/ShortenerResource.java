package com.ankur.urlshortener.shortener.resource;

import com.ankur.urlshortener.shortener.dto.OriginalUrlDto;
import com.ankur.urlshortener.shortener.dto.ShortUrlDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
class ShortenerResource {

    @RequestMapping(value = "/shorten", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    ShortUrlDto shortenUrl(@RequestBody final OriginalUrlDto originalUrlDto,
                        HttpServletResponse response) {
        response.setStatus(201);
        return new ShortUrlDto("localhost:8080/1");
    }
}
