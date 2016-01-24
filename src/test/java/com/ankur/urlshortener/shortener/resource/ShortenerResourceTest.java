package com.ankur.urlshortener.shortener.resource;

import com.ankur.urlshortener.UrlShortnerApplication;
import com.ankur.urlshortener.shortener.dto.OriginalUrlDto;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UrlShortnerApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ShortenerResourceTest {

    private static final OriginalUrlDto ORIGINAL_URL = new OriginalUrlDto("https://www.google.co.uk/maps");

    @Value("${local.server.port}")
    int port;

    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    public void ensureShortenedUrlIsReturned() {
        given().
                body(ORIGINAL_URL).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                post("/shorten").
        then().
                contentType(ContentType.JSON).
                statusCode(201).
                body("url", Matchers.is(String.format("localhost:%d/1", port)));
    }

    @Test
    public void ensure400IsReturnedWhenEmptyUrlIsSent() {
        given().
                body(new OriginalUrlDto("")).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                post("/shorten").
        then().
                statusCode(400);
    }
}