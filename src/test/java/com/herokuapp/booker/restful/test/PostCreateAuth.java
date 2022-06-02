package com.herokuapp.booker.restful.test;

import com.herokuapp.booker.restful.model.Pojo;
import com.herokuapp.booker.restful.testBase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateAuth extends TestBase {
    @Test
    public void createAuth(){
        Pojo pojo=new Pojo();
        pojo.setUsername("admin");
        pojo.setPassword("password123");
        Response response=given()
                .header("Content-Type", "application/json")
                .body(pojo)
                .when()
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);

    }


}
