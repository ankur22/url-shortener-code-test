package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;

import java.util.Optional;

public interface UrlDataStoreDao {
    DataStoreId storeOriginalUrl(final OriginalUrl originalUrl);
    Optional<OriginalUrl> getOriginalUrl(DataStoreId dataStoreId);
}
