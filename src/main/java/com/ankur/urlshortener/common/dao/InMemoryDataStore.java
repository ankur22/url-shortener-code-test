package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryDataStore {
    private final Map<OriginalUrl, DataStoreId> storeData;
    private final Map<DataStoreId, OriginalUrl> getData;

    public InMemoryDataStore() {
        this.storeData = new HashMap<>();
        this.getData = new HashMap<>();
    }

    public void store(OriginalUrl originalUrl, DataStoreId dataStoreId) {
        storeData.put(originalUrl, dataStoreId);
        getData.put(dataStoreId, originalUrl);
    }

    public Optional<OriginalUrl> get(DataStoreId dataStoreId) {
        return Optional.ofNullable(getData.get(dataStoreId));
    }

    public Optional<DataStoreId> get(OriginalUrl originalUrl) {
        return Optional.ofNullable(storeData.get(originalUrl));
    }
}
