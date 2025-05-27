package de.gothaer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiImplTest {
    private MultiImpl objectUnderTest;

    @BeforeEach
    void setUp() {
        objectUnderTest = new MultiImpl();
    }

    @Test
    void multipliziere_HappyDay_returnsProductOfNumbers() {
        var result = objectUnderTest.multipliziere(3, 4);
        assertEquals(12, result);
    }
}