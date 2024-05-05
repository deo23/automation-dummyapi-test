import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserCreateApiTest {

    private static String baseUrl = "https://dummyapi.io/data/v1/user/create";
    private static String validAppId = "66272d3ca25d39f3923bfa35";
    private static String invalidAppId = "66272d3ca25d39f3923bfa36";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = baseUrl;
    }

    @Test
    public void testCreateUserWithoutAppId() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Deo\",\n" +
                "  \"lastName\": \"Audha\",\n" +
                "  \"email\": \"deo@example.com\"\n" +
                "}";

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/")
        .then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_MISSING"));
    }

    @Test
    public void testCreateUserWithInvalidAppId() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Deo\",\n" +
                "  \"lastName\": \"Audha\",\n" +
                "  \"email\": \"deo@example.com\"\n" +
                "}";

        given()
            .header("app-id", invalidAppId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/")
        .then()
            .statusCode(403)
            .body("error", equalTo("APP_ID_NOT_EXIST"));
    }

    @Test
    public void testCreateUserValidInput() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Deo\",\n" +
                "  \"lastName\": \"Audha\",\n" +
                "  \"email\": \"ddeoaa@example.com\"\n" +
                "}";

        given()
            .header("app-id", validAppId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/")
        .then()
            .statusCode(200)
            .body("firstName", equalTo("Deo"))
            .body("lastName", equalTo("Audha"))
            .body("email", equalTo("ddeoaa@example.com"));
    }

    @Test
    public void testCreateUserLowerLimitFirstname() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Jo\",\n" +
                "  \"lastName\": \"Smith\",\n" +
                "  \"email\": \"joo.smiths@example.com\"\n" +
                "}";

        given()
            .header("app-id", validAppId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/")
        .then()
            .statusCode(200)
            .body("firstName", equalTo("Jo"))
            .body("lastName", equalTo("Smith"))
            .body("email", equalTo("joo.smiths@example.com"));
    }

    @Test
    public void testCreateUserExistingEmail() {
        String requestBody = "{\n" +
                "  \"firstName\": \"Deo\",\n" +
                "  \"lastName\": \"Audha\",\n" +
                "  \"email\": \"deo@example.com\"\n" +
                "}";

        given()
            .header("app-id", validAppId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("/")
        .then()
            .statusCode(400)
            .body("error", equalTo("BODY_NOT_VALID"))
            .body("data.email", equalTo("Email already used"));
    }
}

