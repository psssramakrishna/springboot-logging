package io.javabrains.logging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResourceTest {

    @Test
    public void testHelloResource(){
        HelloResource hr = new HelloResource();
        hr.home();
        assertTrue(true);
    }

}