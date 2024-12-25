package src;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class App {

    private static final String BASE_URL = "https://reqres.in/api";

    public static HttpResponse<JsonNode> getUser(int userId) {
        try {
            HttpResponse<JsonNode> response = Unirest.get(BASE_URL + "/users/" + userId).asJson();

            if (response.getStatus() != 200) {
                throw new RuntimeException("Ошибка: статус ответа " + response.getStatus());
            }

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка при выполнении запроса: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        try {
            HttpResponse<JsonNode> response = getUser(2);
            System.out.println(response.getBody());
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
