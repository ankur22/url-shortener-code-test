package com.ankur.urlshortener.common.dao;

import com.ankur.urlshortener.common.model.DataStoreId;
import com.ankur.urlshortener.common.model.OriginalUrl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

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

}