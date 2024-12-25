package test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    @Description("Проверка получения информации о пользователе с ID = 2")
    void testGetUser() {
        HttpResponse<JsonNode> response = App.getUser(2);
        assertEquals(200, response.getStatus(), "Ожидается статус 200");
        assertNotNull(response.getBody(), "Тело ответа не должно быть null");
    }

    @Step("Получение данных пользователя с ID = {userId}")
    public static HttpResponse<JsonNode> getUser(int userId) {
        return App.getUser(userId);
    }
}
