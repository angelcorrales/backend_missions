package com.bbva.play;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MissionsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/missions")
          .then()
             .statusCode(200);
    }

}