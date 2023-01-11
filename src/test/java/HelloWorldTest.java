import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    @Test
    public void main (){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();
        response.prettyPrint();

        String locationHeader = response.getHeader("Location");
        int statusCode = response.getStatusCode();

        while (statusCode != 200) {
            Response response200 = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeader)
                    .andReturn();
            locationHeader = response200.getHeader("Location");
            statusCode = response200.getStatusCode();
            String locationStack = response200.header("Name");
            if (locationHeader == null) {
                System.out.println("Боже, храни CRM. Мы прибыли!");
                System.out.println("Status code "+statusCode);
                break;
            } else {
                System.out.println("Перенаправление на "+locationHeader);}
            System.out.println("Status code "+statusCode);
        }
    }
}
