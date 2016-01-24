package com.ankur.urlshortener.shortener.transformer;

import com.ankur.urlshortener.common.model.OriginalUrl;
import com.ankur.urlshortener.common.model.ShortUrl;
import com.ankur.urlshortener.shortener.dto.OriginalUrlDto;
import com.ankur.urlshortener.shortener.dto.ShortUrlDto;
import org.springframework.stereotype.Service;

@Service
public class ShortenerTransformer {

    public OriginalUrl from(final OriginalUrlDto originalUrlDto) {
        return OriginalUrl.of(originalUrlDto.getUrl());
    }

    public ShortUrlDto from(final ShortUrl shortUrl) {
        return new ShortUrlDto(shortUrl.getValue());
    }
}
