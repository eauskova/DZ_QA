package test;

import main.App;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetUserTest {
    @Test
    void testGetUserPositive() {
        HttpResponse<JsonNode> response = App.getUser(2);
        assertEquals(200, response.getStatus());
        assertNotNull(response.getBody().getObject().getJSONObject("data"));
    }

    @Test
    void testGetUserNegative() {
        HttpResponse<JsonNode> response = App.getUser(9999);
        assertEquals(404, response.getStatus());
        assertEquals("User not found", response.getBody().getObject().getString("error"));
    }
}
