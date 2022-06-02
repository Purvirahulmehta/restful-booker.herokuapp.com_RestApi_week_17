package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingById extends TestBase {
    @Test
    public void deleteBooking() {
        Response response = given()
                .auth().preemptive().basic("admin", "password123")
                .pathParam("id", 624)
                .when()
                .delete("/booking/{id}");
        response.then().statusCode(201);
        response.prettyPrint();

    }


}
