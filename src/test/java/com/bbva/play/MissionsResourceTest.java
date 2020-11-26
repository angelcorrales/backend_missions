package com.bbva.play;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MissionsResourceTest {

    @Test
    public void testGetMissions() {
        given()
          .when().get("/missions")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetMissions2() {
        given()
          .when().get("/missions?id=1")
          .then()
             .statusCode(200);
    }
}