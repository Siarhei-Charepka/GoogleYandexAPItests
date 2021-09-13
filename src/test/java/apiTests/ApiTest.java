package apiTests;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Listeners(TestListener.class)
public class ApiTest {

    private static final String URL = "https://reqres.in/api";
    private static final String SINGLE_USER = "/single_user";
    private static final String USERS = "/users?page=1";

    @Description("The test checks the status of the server")
    @Test
    public void getStatusServerTest() {
        given()
                .baseUri(URL)
                .basePath(SINGLE_USER)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200);
    }

    @Description("The test checks that data is present on the server: first_name = “Janet”")
    @Test
    public void getUserFirstNameTest() {
        given()
                .baseUri(URL)
                .basePath(USERS)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.find{it.first_name == 'Janet'}.first_name", equalTo("Janet"));
    }
}
