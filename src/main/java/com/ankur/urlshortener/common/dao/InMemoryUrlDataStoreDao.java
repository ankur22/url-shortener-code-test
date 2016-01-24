package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class InMemoryUrlDataStoreDao implements UrlDataStoreDao {

    private final Map<OriginalUrl, DataStoreId> dataStore;
    private int count;

    InMemoryUrlDataStoreDao() {
        dataStore = new HashMap<>();
        count = 0;
    }

    @Override
    public DataStoreId storeOriginalUrl(OriginalUrl originalUrl) {
        DataStoreId id = dataStore.get(originalUrl);
        if (id == null) {
            ++count;
            id = DataStoreId.of(count);
            dataStore.put(originalUrl, id);
        }
        return id;
    }

    @Override
    public OriginalUrl getOriginalUrl(DataStoreId dataStoreId) {
        return null;
    }
}
