import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class HomeworkEight {
    @Test
    public void main() throws InterruptedException {
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = response.get("token");
        int sec = response.get("seconds");
        System.out.println("Получен токен " + token);
        System.out.println("Токен станет действителен через " + sec + " секунд");
        boolean isSuccess = false;
        String st = null;
        do {
            JsonPath response1 = RestAssured
                    .given()
                    .queryParam("token", token)
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();
            String status = response1.get("status");

            if (empty(st)){
                st=status;
            }

            if (!status.equalsIgnoreCase(st)){
                isSuccess = true;
            } else {
                Thread.sleep(sec * 1000L);
            }
            System.out.println("Статус "+status);
        }while (!isSuccess);
    }
    public static boolean empty( final String s ) {
        return s == null || s.trim().isEmpty();
    }
}


