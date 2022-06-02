package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBookingId extends TestBase {
    @Test
    public void getBookingId(){
        Response response=given()
                .pathParam("id",1287)
                .when()
                .get("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);


    }

}
