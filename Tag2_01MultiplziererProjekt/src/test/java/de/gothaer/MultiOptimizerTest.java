package de.gothaer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MultiOptimizerTest {

    @InjectMocks
    private MultiOptimizer objectUnderTest;

    @Mock
    private Multi multiMock;

    @Test
    void multipliziere_aGreateB_swapParameters() {
        when(multiMock.multipliziere(anyInt(), anyInt())).thenReturn(13L);
        var result = objectUnderTest.multipliziere(4, 3);
        assertEquals(13L, result);
        verify(multiMock).multipliziere(3,4);
    }

    @Test
    void multipliziere_aLessThenB_NoSwapOfParameters() {
        when(multiMock.multipliziere(anyInt(), anyInt())).thenReturn(13L);
        var result = objectUnderTest.multipliziere(3, 4);
        assertEquals(13L, result);
        verify(multiMock).multipliziere(3,4);
    }
}