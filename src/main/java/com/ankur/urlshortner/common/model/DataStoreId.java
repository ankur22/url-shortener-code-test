package com.ankur.urlshortner.common.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class DataStoreId {
    final String value;
}
