package com.ankur.urlshortener.index.resource;

import com.ankur.urlshortener.UrlShortnerApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UrlShortnerApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class IndexResourceTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    public void makeSureHtmlFileReturned() {
        when().
                get("/").
        then().
                statusCode(200).
                contentType(ContentType.HTML);
    }
}