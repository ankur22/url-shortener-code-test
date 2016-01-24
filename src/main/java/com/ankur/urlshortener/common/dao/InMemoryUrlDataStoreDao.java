package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class InMemoryUrlDataStoreDao implements UrlDataStoreDao {

    private final Map<DataStoreId, OriginalUrl> dataStore;

    InMemoryUrlDataStoreDao() {
        dataStore = new HashMap<>();
    }

    @Override
    public DataStoreId storeOriginalUrl(OriginalUrl originalUrl) {
        return DataStoreId.of("1");
    }

    @Override
    public OriginalUrl getOriginalUrl(DataStoreId dataStoreId) {
        return null;
    }
}
