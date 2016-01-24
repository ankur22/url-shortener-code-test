package com.ankur.urlshortener.shortener.resource;

import com.ankur.urlshortener.common.model.OriginalUrl;
import com.ankur.urlshortener.common.model.ShortUrl;
import com.ankur.urlshortener.shortener.dto.OriginalUrlDto;
import com.ankur.urlshortener.shortener.dto.ShortUrlDto;
import com.ankur.urlshortener.shortener.model.HostName;
import com.ankur.urlshortener.shortener.service.ShortenerService;
import com.ankur.urlshortener.shortener.transformer.ShortenerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Controller
class ShortenerResource {

    private final ShortenerService shortenerService;
    private final ShortenerTransformer shortenerTransformer;

    @Autowired
    public ShortenerResource(final ShortenerService shortenerService,
                             final ShortenerTransformer shortenerTransformer) {
        this.shortenerService = shortenerService;
        this.shortenerTransformer = shortenerTransformer;
    }

    @RequestMapping(value = "/shorten", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    ShortUrlDto shortenUrl(@RequestHeader("host") String hostName,
                           @NotNull @RequestBody final OriginalUrlDto originalUrlDto,
                        HttpServletResponse response) {
        validate(originalUrlDto);
        OriginalUrl originalUrl = shortenerTransformer.from(originalUrlDto);
        ShortUrl shortUrl = shortenerService.store(originalUrl, HostName.of(hostName));
        response.setStatus(201);
        return shortenerTransformer.from(shortUrl);
    }

    private void validate(final OriginalUrlDto originalUrlDto) {
        if (originalUrlDto.getUrl() == null || originalUrlDto.getUrl().length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
