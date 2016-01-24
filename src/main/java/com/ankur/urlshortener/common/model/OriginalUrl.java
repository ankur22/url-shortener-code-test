package com.ankur.urlshortener.common.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class OriginalUrl {
    final String value;
}
