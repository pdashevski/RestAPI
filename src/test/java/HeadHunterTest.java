import com.google.gson.Gson;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class HeadHunterTest {

    Gson gson = new Gson();

    @Test
    public void test() {
        String str = when().
                get("https://api.hh.ru/vacancies?text=QA").
                then().
                extract().body().asString();

        HHResponse response = gson.fromJson(str, HHResponse.class);

        System.out.println(response);
    }
}
