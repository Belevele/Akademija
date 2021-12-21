package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestFirstTask {

    @Test
    public void testUser101() {

        given().
                pathParam("userId", "101").
                log().all().
        when().
                get("https://gorest.co.in/public-api/users/{userId}").
        then().
                assertThat().
                statusCode(200).
                body("data.gender", is("female")).
                body("data.status", is("inactive")).
                log().all();
    }
}