import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Homework6 {
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
        System.out.println("Доступен переход на "+locationHeader);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: "+statusCode);
    }

}