package com.ankur.urlshortner.common.dao;

import com.ankur.urlshortner.common.model.DataStoreId;
import com.ankur.urlshortner.common.model.OriginalUrl;

public interface UrlDataStoreDao {
    DataStoreId storeOriginalUrl(final OriginalUrl originalUrl);
    OriginalUrl getOriginalUrl(DataStoreId dataStoreId);
}
