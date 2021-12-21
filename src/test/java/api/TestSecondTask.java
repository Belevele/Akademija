package api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestSecondTask {

    @Test
    public void testIfNumberOfUsersIs20() {
                given().
                        queryParam("page", "5").
                        log().all().
                when().
                        get("https://gorest.co.in/public-api/users").
                then().
                assertThat().
                        statusCode(200).
                        body("data", hasSize(20)).
                        log().all();
    }
}

