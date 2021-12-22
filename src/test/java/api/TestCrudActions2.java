package api;

import basetest.BaseApiTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class TestCrudActions2 extends BaseApiTest {

    @Test
    public void getUserIDAndCreateNewPost() {

        String endpointUsers = "public-api/users";
        String endpointPosts = "public-api/posts";

        // FIND 1st user
        int userID = given().
                spec(reqSpec).
                queryParam("page", 1).
        when().
                get(endpointUsers).
        then().
                assertThat().
                body("code", is(200)).
                extract().
                path("data[0].id");


        // POST message
        Map <String, Object> userPost = new HashMap<>();
        userPost.put("user_id", userID);
        userPost.put("title", "Hello");
        userPost.put("body", "This is my post");

        given().
                spec(reqSpec).
                body(userPost).
        when().
                post(endpointPosts).
        then().
                assertThat().
                body("code", is(201));

        given().
                spec(reqSpec).
                body(userPost).
        when().
                post(endpointPosts).
        then().
                assertThat().
                body("code", is(200));

        // FIND post
        given().
                spec(reqSpec).
                queryParam("user_id", 1688).
        when().
                get(endpointPosts).
        then().
                assertThat().
                body("code", is(200)).
                body("data[1]", notNullValue()).
                body("data[1].user_id", is(userID)).
                body("data[1].title", is("Lorem"));
    }
}
