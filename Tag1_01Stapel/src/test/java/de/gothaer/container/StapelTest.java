package de.gothaer.container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StapelTest {

    private Stapel objectUnderTest;

    @BeforeEach
    void setUp(){
        objectUnderTest = new Stapel();
    }

    @Test
    void isEmpty_emptyStack_returnsTrue(){
        // Arrange

        // Act
        var result = objectUnderTest.isEmpty();

        // Assertion
        assertTrue(result);
    }

    @Test
    void isEmpty_NotEmptyStack_returnsFalse() throws Exception{
        // Arrange

        objectUnderTest.push(new Object());
        // Act
        var result = objectUnderTest.isEmpty();

        // Assertion
        assertFalse(result);
    }

}