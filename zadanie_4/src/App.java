package src;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class App {
    private static final String BASE_URL = "https://reqres.in/api";

    public static HttpResponse<JsonNode> registerUser(String email, String password) {
        return Unirest.post(BASE_URL + "/register")
                .header("Content-Type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .asJson();
    }

    public static HttpResponse<JsonNode> updateUser(int userId, String name, String job) {
        return Unirest.put(BASE_URL + "/users/" + userId)
                .header("Content-Type", "application/json")
                .body("{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}")
                .asJson();
    }

    public static HttpResponse<JsonNode> deleteUser(int userId) {
        return Unirest.delete(BASE_URL + "/users/" + userId).asJson();
    }

    public static HttpResponse<JsonNode> getUser(int userId) {
        return Unirest.get(BASE_URL + "/users/" + userId).asJson();
    }
}
