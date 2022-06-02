package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.model.Pojo;
import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostCreateNewBooking extends TestBase {
    @Test
    public void createNewBooking(){
        HashMap<String, Object> bookingDays = new HashMap<>();
        bookingDays.put("checkin", "2018-01-01");
        bookingDays.put("checkout", "2019-01-01");
        Pojo pojo=new Pojo();
        pojo.setFirstName("Jim");
        pojo.setLastName("Brown");
        pojo.setTotalPrice(111);
        pojo.setDepositPaid(true);
        pojo.setBookingdates(bookingDays);
        pojo.setAdditionalNeeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(pojo)
                .when()
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);



    }

}
