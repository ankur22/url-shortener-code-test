package com.ankur.urlshortener.shortener.resource;

import com.ankur.urlshortener.common.dao.UrlDataStoreDao;
import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RedirectServiceTest {

    private RedirectService objectUnderTest;
    private UrlDataStoreDao urlDataStoreDao;

    @Before
    public void setup() {
        urlDataStoreDao = mock(UrlDataStoreDao.class);
        objectUnderTest = new RedirectService(urlDataStoreDao);
    }

    @Test
    public void returnExpectedOriginalUrl() {
        // given
        DataStoreId dataStoreId = DataStoreId.of(1);
        OriginalUrl originalUrl = OriginalUrl.of("http://www.google.com");
        when(urlDataStoreDao.getOriginalUrl(dataStoreId)).thenReturn(Optional.of(originalUrl));

        // when
        Optional<OriginalUrl> response = objectUnderTest.getOriginalUrl(dataStoreId);

        // then
        assertEquals(originalUrl, response.get());
    }

    @Test
    public void returnEmptyWhenIdDoesNotMatchAnythingStored() {
        // given
        DataStoreId dataStoreId = DataStoreId.of(1);
        when(urlDataStoreDao.getOriginalUrl(dataStoreId)).thenReturn(Optional.empty());

        // when
        Optional<OriginalUrl> response = objectUnderTest.getOriginalUrl(dataStoreId);

        // then
        assertFalse(response.isPresent());
    }
}