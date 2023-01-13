import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class Homework5 {
    @Test
    public static void main (String[] args){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        Object testObject = response.get("messages.find {msg -> msg.message == 'And this is a second message'}");

        System.out.println(testObject);
    }

}