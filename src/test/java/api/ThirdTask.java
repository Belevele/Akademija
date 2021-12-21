package api;

import basetest.BaseApiTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class ThirdTask extends BaseApiTest {

   // private static String url = "https://gorest.co.in/";

    @Test
    public void testCreateUser() {

        String userEmail = new Random().nextInt(1000) + "@gmail.com";

        Map user = new HashMap();
        user.put("name", "Ana");
        user.put("email", userEmail);
        user.put("gender", "Female");
        user.put("status", "Inactive");

        int userID = given().
                spec(reqSpec).
                body(user).
        when().
                post("public-api/users").
        then().
                log().all().
                assertThat().
                body("code", is(201)).
                extract().
                path("data.id");


            given().
                    spec(reqSpec).
                    pathParam("userId", userID).
                when().
                    get("public-api/users/{userId}").
                then().
                     assertThat().
                     body("code", is(200)).
                     body("data.name", is("Ana")).
                     log().all();

                given().
                     spec(reqSpec).
                     pathParam("userId", userID).
                     log().all().
                when().
                     delete("public-api/users/{userId}").
                then().
                     assertThat().
                     log().all().
                     body("code", is(204));

                given().
                     spec(reqSpec).
                     pathParam("userId", userID).
                     log().all().
                when().
                     get("public-api/users/{userId}").
                then().
                     assertThat().
                     log().all().
                     body("code", is(404));
    }
}
