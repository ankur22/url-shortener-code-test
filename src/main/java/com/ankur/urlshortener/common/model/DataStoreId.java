package com.ankur.urlshortener.common.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class DataStoreId {
    final String value;
}
