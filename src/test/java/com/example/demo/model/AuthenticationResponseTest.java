package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationResponseTest {

    @Test
    public void testConstructorYGetters() {
        AuthenticationResponse response = new AuthenticationResponse("test.jwt.token", 123);
        assertEquals("test.jwt.token", response.getJwt());
        assertEquals(123, response.getUserId());
    }

    @Test
    public void testSetters() {
        AuthenticationResponse response = new AuthenticationResponse(null, 0);
        response.setJwt("new.jwt.token");
        response.setUserId(456);

        assertEquals("new.jwt.token", response.getJwt());
        assertEquals(456, response.getUserId());
    }
}