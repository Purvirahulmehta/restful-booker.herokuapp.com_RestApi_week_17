package com.herokuapp.booker.restful.testBase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        //RestAssured.basePath = "/booking";



    }
}


