package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingList extends TestBase {
    @Test
    public void getBookingList() {
        Response response = given()
                 .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);


    }
}
