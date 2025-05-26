package de.goodyear.collection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StapelTest {
    private Stapel objectUnderTest;

    @BeforeEach
    void setUp() {
        objectUnderTest = new Stapel();
    }

    @Test
    void isEmpty_EmptyStack_returnsTrue() {
        assertTrue(objectUnderTest.isEmpty());
    }

    @Test
    void isEmpty_NotEmptyStack_returnsFalse() {
        objectUnderTest.push(new Object());
        assertFalse(objectUnderTest.isEmpty());
    }
}
