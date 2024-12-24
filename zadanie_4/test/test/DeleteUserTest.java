package test;

import main.App;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteUserTest {
    @Test
    void testDeleteUserPositive() {
        HttpResponse<JsonNode> response = App.deleteUser(2);
        assertEquals(204, response.getStatus());
    }

    @Test
    void testDeleteUserNegative() {
        HttpResponse<JsonNode> response = App.deleteUser(9999);
        assertEquals(404, response.getStatus());
    }
}
