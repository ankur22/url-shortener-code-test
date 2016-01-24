package com.ankur.urlshortener.shortener.service;

import com.ankur.urlshortener.common.dao.UrlDataStoreDao;
import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import com.ankur.urlshortener.common.model.ShortUrl;
import com.ankur.urlshortener.shortener.model.HostName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShortenerServiceTest {

    private ShortenerService objectUnderTest;
    private UrlDataStoreDao urlDataStoreDao;

    @Before
    public void setup() {
        urlDataStoreDao = mock(UrlDataStoreDao.class);

        objectUnderTest = new ShortenerService(urlDataStoreDao);
    }

    @Test
    public void ensureHostNameAndIdAreInResponse() {
        // given
        HostName hostName = HostName.of("http://www.urlshortener.com");
        OriginalUrl originalUrl = OriginalUrl.of("http://www.google.com");
        when(urlDataStoreDao.storeOriginalUrl(originalUrl)).thenReturn(DataStoreId.of(1));

        // when
        ShortUrl shortUrl = objectUnderTest.store(originalUrl, hostName);

        // then
        assertEquals("http://www.urlshortener.com/1", shortUrl.getValue());
    }
}