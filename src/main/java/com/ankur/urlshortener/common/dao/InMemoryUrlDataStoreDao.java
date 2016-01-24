package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class InMemoryUrlDataStoreDao implements UrlDataStoreDao {

    private final InMemoryDataStore inMemoryDataStore;
    private int count;

    @Autowired
    InMemoryUrlDataStoreDao(final InMemoryDataStore inMemoryDataStore) {
        this.inMemoryDataStore = inMemoryDataStore;
        count = 0;
    }

    @Override
    public DataStoreId storeOriginalUrl(OriginalUrl originalUrl) {
        Optional<DataStoreId> optionalId = inMemoryDataStore.get(originalUrl);
        if (!optionalId.isPresent()) {
            ++count;
            DataStoreId id = DataStoreId.of(count);
            inMemoryDataStore.store(originalUrl, id);
            return id;
        }
        return optionalId.get();
    }

    @Override
    public Optional<OriginalUrl> getOriginalUrl(DataStoreId dataStoreId) {
        return inMemoryDataStore.get(dataStoreId);
    }
}
