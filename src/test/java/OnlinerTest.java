import com.google.gson.Gson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {
    Gson gson = new Gson();

    @Test
    public void loginTest() {
        Credentials credentials = Credentials.builder()
                .login("test")
                .password("test")
                .build();

        given().
                header("Content-type", "application/json").
                body(gson.toJson(credentials)).
        when().
                post("https://www.onliner.by/sdapi/user.api/login").
        then().
                log().all().
                statusCode(400).
                body("errors[0].key", equalTo("invalid_login_or_password"),
                        "errors[0].message", equalTo("Неверный логин или пароль"));
    }
}
