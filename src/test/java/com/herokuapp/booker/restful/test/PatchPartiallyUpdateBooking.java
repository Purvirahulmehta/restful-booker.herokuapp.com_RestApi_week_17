package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.model.Pojo;
import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchPartiallyUpdateBooking extends TestBase {
    @Test
    public void updatePartiallyBooking() {
        HashMap<String, Object> bookingDays = new HashMap<>();
        bookingDays.put("checkin", "2018-01-01");
        bookingDays.put("checkout", "2019-01-01");

        Pojo pojo=new Pojo();
        pojo.setFirstName("Jim");
        pojo.setLastName("Brown");
        pojo.setDepositPaid(false);
        pojo.setBookingdates(bookingDays);
        pojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","password123")
                .body(pojo)
                .pathParam("id",624)
                .when()
                .patch("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
