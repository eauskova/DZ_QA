package test;

import main.App;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRegisterTest {
    @Test
    void testRegisterUserPositive() {
        HttpResponse<JsonNode> response = App.registerUser("eve.holt@reqres.in", "pistol");
        assertEquals(200, response.getStatus());
        assertNotNull(response.getBody().getObject().getString("token"));
    }

    @Test
    void testRegisterUserNegative() {
        HttpResponse<JsonNode> response = App.registerUser("eve.holt@reqres.in", "");
        assertEquals(400, response.getStatus());
        assertEquals("Missing password", response.getBody().getObject().getString("error"));
    }
}

