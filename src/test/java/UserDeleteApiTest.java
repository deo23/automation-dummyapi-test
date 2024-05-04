import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;

public class UserDeleteApiTest {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/user";

    @Test
    public void testDeleteUserWithoutAppId() {
        given()
            .when()
            .delete(BASE_URL + "/{id}", "60d0fe4f5311236168a109cb") // Replace "60d0fe4f5311236168a109cb" with the actual user ID
            .then()
            .statusCode(403) // Assuming the status code for unauthorized access is 401
            .log().all();
    }

    @Test
    public void testDeleteUserWithWrongAppId() {
        given()
            .header("app-id", "662e3849bb70a7aae125946") // Wrong app-id
            .when()
            .delete(BASE_URL + "/{id}", "60d0fe4f5311236168a109cb") // Use the specific ID provided
            .then()
            .statusCode(403) // Assuming the status code for unauthorized access is 401
            .log().all();
    }

    @Test
    public void testDeleteNonExistentUser() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format
            .when()
            .delete(BASE_URL + "/{id}", "662e3849bb70a7aae1259469") // Non-existent user ID
            .then()
            .statusCode(404) // Assuming the status code for not found is 404
            .log().all();
    }

    @Test
    public void testDeleteExistingUser() {
        given()
            .header("app-id", "662e3849bb70a7aae1259467") // Correct app-id format
            .when()
            .delete(BASE_URL + "/{id}", "60d0fe4f5311236168a109d1") // Existing user ID
            .then()
            .statusCode(200) // Assuming the status code for successful deletion is 204
            .log().all();
    }
}
