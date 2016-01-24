package com.ankur.urlshortener.shortener.service;

import com.ankur.urlshortener.common.dao.UrlDataStoreDao;
import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import com.ankur.urlshortener.common.model.ShortUrl;
import com.ankur.urlshortener.shortener.model.HostName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenerService {

    private final UrlDataStoreDao urlDataStoreDao;

    @Autowired
    public ShortenerService(final UrlDataStoreDao urlDataStoreDao) {
        this.urlDataStoreDao = urlDataStoreDao;
    }

    public ShortUrl store(final OriginalUrl originalUrl, final HostName hostName) {
        DataStoreId dataStoreId = urlDataStoreDao.storeOriginalUrl(originalUrl);
        return ShortUrl.of(hostName.getValue() + "/" + dataStoreId.getValue());
    }
}
