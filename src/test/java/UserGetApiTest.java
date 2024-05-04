import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class UserGetApiTest {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/user";

    @Test
    public void testGetUserDetailsWithoutAppId() {
        given()
            .when()
            .get(BASE_URL + "/{id}", "60d0fe4f5311236168a109cb") // Replace "your_user_id_here" with an actual user ID, if needed
            .then()
            .statusCode(403) // Assuming the status code for unauthorized access is 401
            .log().all();
    }

    @Test
    public void testGetUserDetailsWithWrongAppId() {
        given()
            .header("app-id", "662e3849bb70a7aae125946") // Wrong app-id
            .when()
            .get(BASE_URL + "/{id}", "60d0fe4f5311236168a109cb") // Use the specific ID provided
            .then()
            .statusCode(403) // Assuming the status code for unauthorized access is 401
            .log().all();
    }

    @Test
    public void testGetNonExistentUser() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format, you can replace it if necessary
            .when()
            .get(BASE_URL + "/{id}", "1") // Non-existent user ID
            .then()
            .statusCode(400) // Expected status code for not found
            .body("error", equalTo("PARAMS_NOT_VALID")) // This line might need to be adjusted based on the actual API response
            .log().all();
    }

    @Test
    public void testGetRegisteredUser() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format
            .when()
            .get(BASE_URL + "/{id}", "60d0fe4f5311236168a109cc") // Existing user ID
            .then()
            .statusCode(200) // Expected status code for successful retrieval
            .body("id", equalTo("60d0fe4f5311236168a109cc")) // Assuming ID is returned in response
            .body("firstName", not(emptyOrNullString())) // Assuming other fields are returned and not empty
            .body("lastName", not(emptyOrNullString()))
            .log().all();
    }

    @Test
    public void testGetAllUsers() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format
            .when()
            .get(BASE_URL)
            .then()
            .statusCode(200) // Expected status code for successful retrieval
            .body("data", not(empty())) // Ensure data is not empty
            .body("data", hasSize(greaterThan(0))) // Ensure there are users in the response
            .body("data.id", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty ID
            .body("data.firstName", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty firstName
            .body("data.lastName", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty lastName
            .log().all();
    }

    @Test
    public void testGetUsersInRange() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format
            .param("limit", 50) // Limit the number of users to 50
            .when()
            .get(BASE_URL)
            .then()
            .statusCode(200) // Expected status code for successful retrieval
            .body("data", not(empty())) // Ensure data is not empty
            .body("data", hasSize(lessThanOrEqualTo(50))) // Ensure there are at most 50 users in the response
            .body("data.id", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty ID
            .body("data.firstName", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty firstName
            .body("data.lastName", everyItem(not(emptyOrNullString()))) // Ensure every user has a non-empty lastName
            .log().all();
    }
}