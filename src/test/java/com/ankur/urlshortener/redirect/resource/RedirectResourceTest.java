package com.ankur.urlshortener.redirect.resource;

import com.ankur.urlshortener.UrlShortnerApplication;
import com.ankur.urlshortener.common.dao.UrlDataStoreDao;
import com.ankur.urlshortener.common.model.OriginalUrl;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UrlShortnerApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RedirectResourceTest {

    private static final String ORIGINAL_URL = "http://www.google.com";

    @Value("${local.server.port}")
    int port;

    @Autowired
    UrlDataStoreDao urlDataStoreDao;

    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    public void redirectToOriginalUrl() {
        givenDataStoreHasValueForId1();

        given().
                redirects().
                follow(false).
        when().
                get("/1").
        then().
                statusCode(302).
                header("Location", ORIGINAL_URL);
    }

    @Test
    public void redirectToHomepageIfIdDoesNotMatchAnything() {
        given().
                redirects().
                follow(false).
        when().
                get("/2").
        then().
                statusCode(302).
                header("Location", String.format("http://localhost:%d/", port));
    }

    private void givenDataStoreHasValueForId1() {
        urlDataStoreDao.storeOriginalUrl(OriginalUrl.of(ORIGINAL_URL));
    }
}