package com.ankur.urlshortner.helloworld.resource;

import com.ankur.urlshortner.UrlShortnerApplication;
import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UrlShortnerApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class HelloWorldResourceTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    public void makeSureHelloWorldIsReturned() {
        when().
                get("/hello-world").
        then().
                statusCode(200).
                body(equalTo(HelloWorldResource.HELLO_WORLD));
    }
}