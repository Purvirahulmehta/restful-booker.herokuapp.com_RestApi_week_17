package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.model.Pojo;
import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutUpdateBookingId extends TestBase {
    @Test
    public void updatingBooking() {
        HashMap<String, Object> bookingDays = new HashMap<>();
        bookingDays.put("checkin", "2018-01-01");
        bookingDays.put("checkout", "2019-01-01");

        Pojo pojo=new Pojo();
        pojo.setFirstName("Jim");
        pojo.setLastName("Brown");
        pojo.setTotalPrice(111);
        pojo.setDepositPaid(false);
        pojo.setBookingdates(bookingDays);
        pojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","password123")
                .body(pojo)
                .when()
                .put("/booking/624");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
