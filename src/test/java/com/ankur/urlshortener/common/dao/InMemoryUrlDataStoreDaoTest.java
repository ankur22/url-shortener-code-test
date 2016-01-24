package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class InMemoryUrlDataStoreDaoTest {

    InMemoryUrlDataStoreDao objectUnderTest;

    @Before
    public void setup() {
        objectUnderTest = new InMemoryUrlDataStoreDao();
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

}