package de.gothaer.container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("gegeben ist eine nicht leerer Stack blabla")
    void isEmpty_NotEmptyStack_returnsFalse() throws Exception{
        // Arrange

        objectUnderTest.push(new Object());
        // Act
        var result = objectUnderTest.isEmpty();

        // Assertion
        assertFalse(result);
    }
    @Test
    void push_fillUpToLimit_noExceptionIsThrown() throws Exception{
        // Arrange + Act
        fillUpToLimit();

    }
    @Test
    void push_Overflow_StapelExceptionIsThrown() throws Exception{
        // Arrange + Act
        fillUpToLimit();
        StapelException ex = assertThrows(StapelException.class,()->objectUnderTest.push(new Object()));
        assertEquals("Overflow",ex.getMessage());
    }


    @Test
    void isFull_NotFullStack_returnsFalse() {
        assertFalse(objectUnderTest.isFull());
    }
    @Test
    void isFull_FullStack_returnsTrue() {
        fillUpToLimit();
        assertTrue(objectUnderTest.isFull());
    }

    private void fillUpToLimit() {
        for (int i = 0; i < 10; i++) {
            assertDoesNotThrow(()->objectUnderTest.push(new Object()));
        }
    }

}