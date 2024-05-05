import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateUserDataTest {

    private static String appId = "662e389ebb70a717cf25946b";
    private static String userId = "6635fc42b72aea3757ea62b4";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/user";
    }

    @Test
    public void testUpdateUserData() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Budi\",\n" +
                "  \"lastName\": \"Santoso\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"budisantoso@example.com\",\n" +
                "  \"dateOfBirth\": \"1985-05-15\",\n" +
                "  \"phone\": \"+6281234567890\",\n" +
                "  \"picture\": \"https://example.com/budisantoso.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"Jl. Sudirman No. 123\",\n" +
                "    \"city\": \"Jakarta\",\n" +
                "    \"state\": \"DKI Jakarta\",\n" +
                "    \"country\": \"Indonesia\"\n" +
                "    }\n" +
                "}";

        given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("/" + userId)
        .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Budi"))
            .body("lastName", equalTo("Santoso"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("nugroho@example.com"))
            .body("dateOfBirth", equalTo("1985-05-15T00:00:00.000Z"))
            .body("phone", equalTo("+6281234567890"))
            .body("picture", equalTo("https://example.com/budisantoso.jpg"))
            .body("location.street", equalTo("Jl. Sudirman No. 123"))
            .body("location.city", equalTo("Jakarta"))
            .body("location.state", equalTo("DKI Jakarta"))
            .body("location.country", equalTo("Indonesia"));
    }

    public static class UserDataUtil {
        public static String addFirstNameToRequestBody(String requestBody, String firstName) {
            return requestBody.replace("\"firstName\": \"Budi\"", "\"firstName\": \"" + firstName + "\"");
        }

        public static String addLastNameToRequestBody(String requestBody, String lastName) {
            return requestBody.replace("\"lastName\": \"Santoso\"", "\"lastName\": \"" + lastName + "\"");
        }

        public static String addTitleToRequestBody(String requestBody, String title) {
            return requestBody.replace("\"title\": \"mr\"", "\"title\": \"" + title + "\"");
        }

        public static String addGenderToRequestBody(String requestBody, String gender) {
            return requestBody.replace("\"gender\": \"male\"", "\"gender\": \"" + gender + "\"");
        }
    
    }

    @Test
    public void testUpdateUserDataFirstname() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Budi\",\n" +
                "  \"lastName\": \"Santoso\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"budisantoso@example.com\",\n" +
                "  \"dateOfBirth\": \"1985-05-15\",\n" +
                "  \"phone\": \"+6281234567890\",\n" +
                "  \"picture\": \"https://example.com/budisantoso.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"Jl. Sudirman No. 123\",\n" +
                "    \"city\": \"Jakarta\",\n" +
                "    \"state\": \"DKI Jakarta\",\n" +
                "    \"country\": \"Indonesia\"\n" +
                "    }\n" +
                "}";

        String updatedRequestBody = UserDataUtil.addFirstNameToRequestBody(requestBody, "Xynaa");

        given()
                .header("app-id", appId)
                .contentType("application/json")
                .body(updatedRequestBody)
        .when()
                .put("/" + userId)
        .then()
                .statusCode(200)
                .body("title", equalTo("mr"))
                .body("firstName", equalTo("Xynaa"))
                .body("lastName", equalTo("Santoso"))
                .body("gender", equalTo("male"))
                .body("email", equalTo("nugroho@example.com"))
                .body("dateOfBirth", equalTo("1985-05-15T00:00:00.000Z"))
                .body("phone", equalTo("+6281234567890"))
                .body("picture", equalTo("https://example.com/budisantoso.jpg"))
                .body("location.street", equalTo("Jl. Sudirman No. 123"))
                .body("location.city", equalTo("Jakarta"))
                .body("location.state", equalTo("DKI Jakarta"))
                .body("location.country", equalTo("Indonesia"));
    }

    @Test
    public void testUpdateUserLastName() {
        String requestBody = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Budi\",\n" +
                "  \"lastName\": \"Santoso\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"budisantoso@example.com\",\n" +
                "  \"dateOfBirth\": \"1985-05-15\",\n" +
                "  \"phone\": \"+6281234567890\",\n" +
                "  \"picture\": \"https://example.com/budisantoso.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"Jl. Sudirman No. 123\",\n" +
                "    \"city\": \"Jakarta\",\n" +
                "    \"state\": \"DKI Jakarta\",\n" +
                "    \"country\": \"Indonesia\"\n" +
                "    }\n" +
                "}";

        String updatedRequestBody = UserDataUtil.addLastNameToRequestBody(requestBody, "depdub");

        given()
                .header("app-id", appId)
                .contentType("application/json")
                .body(updatedRequestBody)
        .when()
                .put("/" + userId)
        .then()
                .statusCode(200)
                .body("title", equalTo("mr"))
                .body("firstName", equalTo("Budi"))
                .body("lastName", equalTo("depdub"))
                .body("gender", equalTo("male"))
                .body("email", equalTo("nugroho@example.com"))
                .body("dateOfBirth", equalTo("1985-05-15T00:00:00.000Z"))
                .body("phone", equalTo("+6281234567890"))
                .body("picture", equalTo("https://example.com/budisantoso.jpg"))
                .body("location.street", equalTo("Jl. Sudirman No. 123"))
                .body("location.city", equalTo("Jakarta"))
                .body("location.state", equalTo("DKI Jakarta"))
                .body("location.country", equalTo("Indonesia"));
    }


    @Test
public void testUpdateUserTitle() {
    String requestBody = "{\n" +
            "  \"title\": \"mr\",\n" +
            "  \"firstName\": \"Budi\",\n" +
            "  \"lastName\": \"Santoso\",\n" +
            "  \"gender\": \"male\",\n" +
            "  \"email\": \"budisantoso@example.com\",\n" +
            "  \"dateOfBirth\": \"1985-05-15\",\n" +
            "  \"phone\": \"+6281234567890\",\n" +
            "  \"picture\": \"https://example.com/budisantoso.jpg\",\n" +
            "  \"location\": {\n" +
            "    \"street\": \"Jl. Sudirman No. 123\",\n" +
            "    \"city\": \"Jakarta\",\n" +
            "    \"state\": \"DKI Jakarta\",\n" +
            "    \"country\": \"Indonesia\"\n" +
            "    }\n" +
            "}";

    String updatedRequestBody = UserDataUtil.addTitleToRequestBody(requestBody, "mrs");

    given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(updatedRequestBody)
    .when()
            .put("/" + userId)
    .then()
            .statusCode(200)
            .body("title", equalTo("mrs"))
            .body("firstName", equalTo("Budi"))
            .body("lastName", equalTo("Santoso"))
            .body("gender", equalTo("male"))
            .body("email", equalTo("nugroho@example.com"))
            .body("dateOfBirth", equalTo("1985-05-15T00:00:00.000Z"))
            .body("phone", equalTo("+6281234567890"))
            .body("picture", equalTo("https://example.com/budisantoso.jpg"))
            .body("location.street", equalTo("Jl. Sudirman No. 123"))
            .body("location.city", equalTo("Jakarta"))
            .body("location.state", equalTo("DKI Jakarta"))
            .body("location.country", equalTo("Indonesia"));
}

@Test
public void testUpdateUserGender() {
    String requestBody = "{\n" +
            "  \"title\": \"mr\",\n" +
            "  \"firstName\": \"Budi\",\n" +
            "  \"lastName\": \"Santoso\",\n" +
            "  \"gender\": \"male\",\n" +
            "  \"email\": \"budisantoso@example.com\",\n" +
            "  \"dateOfBirth\": \"1985-05-15\",\n" +
            "  \"phone\": \"+6281234567890\",\n" +
            "  \"picture\": \"https://example.com/budisantoso.jpg\",\n" +
            "  \"location\": {\n" +
            "    \"street\": \"Jl. Sudirman No. 123\",\n" +
            "    \"city\": \"Jakarta\",\n" +
            "    \"state\": \"DKI Jakarta\",\n" +
            "    \"country\": \"Indonesia\"\n" +
            "    }\n" +
            "}";

    String updatedRequestBody = UserDataUtil.addGenderToRequestBody(requestBody, "female");

    given()
            .header("app-id", appId)
            .contentType("application/json")
            .body(updatedRequestBody)
    .when()
            .put("/" + userId)
    .then()
            .statusCode(200)
            .body("title", equalTo("mr"))
            .body("firstName", equalTo("Budi"))
            .body("lastName", equalTo("Santoso"))
            .body("gender", equalTo("female"))
            .body("email", equalTo("nugroho@example.com"))
            .body("dateOfBirth", equalTo("1985-05-15T00:00:00.000Z"))
            .body("phone", equalTo("+6281234567890"))
            .body("picture", equalTo("https://example.com/budisantoso.jpg"))
            .body("location.street", equalTo("Jl. Sudirman No. 123"))
            .body("location.city", equalTo("Jakarta"))
            .body("location.state", equalTo("DKI Jakarta"))
            .body("location.country", equalTo("Indonesia"));
}


}
