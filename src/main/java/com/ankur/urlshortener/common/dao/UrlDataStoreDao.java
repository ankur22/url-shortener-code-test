package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;

public interface UrlDataStoreDao {
    DataStoreId storeOriginalUrl(final OriginalUrl originalUrl);
    OriginalUrl getOriginalUrl(DataStoreId dataStoreId);
}
