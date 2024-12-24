package test;

import main.App;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PutUserTest {
    @Test
    void testUpdateUserPositive() {
        HttpResponse<JsonNode> response = App.updateUser(2, "morpheus", "zion resident");
        assertEquals(200, response.getStatus());
        assertEquals("morpheus", response.getBody().getObject().getString("name"));
    }

    @Test
    void testUpdateUserNegative() {
        HttpResponse<JsonNode> response = App.updateUser(9999, "test", "developer");
        assertEquals(404, response.getStatus());
    }
}
