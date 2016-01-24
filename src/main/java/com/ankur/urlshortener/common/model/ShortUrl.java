package com.ankur.urlshortener.common.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class ShortUrl {
    final String value;
}
