package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class InMemoryUrlDataStoreDaoTest {

    InMemoryUrlDataStoreDao objectUnderTest;

    @Before
    public void setup() {
        objectUnderTest = new InMemoryUrlDataStoreDao(new InMemoryDataStore());
    }

    @Test
    public void dataStoredAndIdReturned() {
        // given
        OriginalUrl originalUrl = OriginalUrl.of("http://www.google.com");

        // when
        DataStoreId response = objectUnderTest.storeOriginalUrl(originalUrl);

        // then
        assertNotNull(response);
    }

    @Test
    public void differentIdReturnedForDifferentUrls() {
        // given
        OriginalUrl originalUrl1 = OriginalUrl.of("http://www.google.com");
        OriginalUrl originalUrl2 = OriginalUrl.of("http://www.google.co.uk");

        // when
        DataStoreId response1 = objectUnderTest.storeOriginalUrl(originalUrl1);
        DataStoreId response2 = objectUnderTest.storeOriginalUrl(originalUrl2);

        // then
        assertEquals("1", response1.getValue());
        assertEquals("2", response2.getValue());
    }

    @Test
    public void ensureDuplicateUrlsReturnTheSameId() {
        // given
        OriginalUrl originalUrl1 = OriginalUrl.of("http://www.google.com");
        OriginalUrl originalUrl2 = OriginalUrl.of("http://www.google.com");

        // when
        DataStoreId response1 = objectUnderTest.storeOriginalUrl(originalUrl1);
        DataStoreId response2 = objectUnderTest.storeOriginalUrl(originalUrl2);

        // then
        assertEquals("1", response1.getValue());
        assertEquals("1", response2.getValue());
    }

    @Test
    public void getOriginalUrlWhenIdPassedIn() {
        // given
        OriginalUrl originalUrl1 = OriginalUrl.of("http://www.google.com");
        OriginalUrl originalUrl2 = OriginalUrl.of("http://www.google.com");
        objectUnderTest.storeOriginalUrl(originalUrl1);
        DataStoreId dataStoreId = DataStoreId.of(1);

        // when
        Optional<OriginalUrl> response = objectUnderTest.getOriginalUrl(dataStoreId);

        // then
        assertEquals(originalUrl1, response.get());
    }

    @Test
    public void ensureEmptyResponseWhenIdDoesNotMatchAnything() {
        // given
        OriginalUrl originalUrl1 = OriginalUrl.of("http://www.google.com");
        OriginalUrl originalUrl2 = OriginalUrl.of("http://www.google.com");
        objectUnderTest.storeOriginalUrl(originalUrl1);
        DataStoreId dataStoreId = DataStoreId.of(3);

        // when
        Optional<OriginalUrl> response = objectUnderTest.getOriginalUrl(dataStoreId);

        // then
        assertFalse(response.isPresent());
    }
}