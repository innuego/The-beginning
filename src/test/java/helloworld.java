import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Helloworld
{
    @Test
    public void HelloWorldtest(){
            Response response = RestAssured
                    .get("https://playground.learnqa.ru/api/map")
                    .andReturn();
            response.prettyPrint();
    }
}
