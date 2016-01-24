package com.ankur.urlshortener.shortener.resource;

import com.ankur.urlshortener.common.dao.UrlDataStoreDao;
import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    private final UrlDataStoreDao urlDataStoreDao;

    @Autowired
    public RedirectService(final UrlDataStoreDao urlDataStoreDao) {
        this.urlDataStoreDao = urlDataStoreDao;
    }

    public Optional<OriginalUrl> getOriginalUrl(final DataStoreId dataStoreId) {
        return urlDataStoreDao.getOriginalUrl(dataStoreId);
    }
}
