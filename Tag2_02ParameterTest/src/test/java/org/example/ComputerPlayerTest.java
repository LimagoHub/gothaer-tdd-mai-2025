package org.example;

import org.example.io.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {

    @InjectMocks
    private ComputerPlayer objectUnderTest;

    @Mock
    private Writer writerMock;

    @ParameterizedTest(name = "Durchlauf Nr. {index} mit Parameter {0} und expected {1}")
    @CsvSource({"20,3", "21,1", "22,1",  "23,2"})
    void doTurn(int param, int expected) {
        var result = objectUnderTest.doTurn(param);
        assertEquals(expected, result);
        verify(writerMock).write("Computer nimmt " + result + " Steine.");
    }

    /*@Test
    void doTurn_StonesMod4Is0_returns3() {
        var result = objectUnderTest.doTurn(4);
        assertEquals(3, result);
        verify(writerMock).write("Computer nimmt " + result + " Steine.");
    }

    @Test
    void doTurn_StonesMod4Is1_returns1() {
        var result = objectUnderTest.doTurn(5);
        assertEquals(1, result);
        verify(writerMock).write("Computer nimmt " + result + " Steine.");
    }

    @Test
    void doTurn_StonesMod4Is2_returns1() {
        var result = objectUnderTest.doTurn(6);
        assertEquals(1, result);
        verify(writerMock).write("Computer nimmt " + result + " Steine.");
    }

    @Test
    void doTurn_StonesMod4Is3_returns2() {
        var result = objectUnderTest.doTurn(7);
        assertEquals(2, result);
        verify(writerMock).write("Computer nimmt " + result + " Steine.");
    }
    */

}