package com.ankur.urlshortner.common.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class OriginalUrl {
    final String value;
}
