package de.gothaer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Euro2DollarRechnerImplTest {
    @InjectMocks
    private Euro2DollarRechnerImpl objectUnderTest;

    @Mock
    private ExchanceService exchangeserviceMock;

    @Test
    void calculateEuro2Dollar_RuntimeExceptionInUnderlyingService_throwsExchangeServiceException() {

        when(exchangeserviceMock.getRate("USD")).thenThrow(new ArithmeticException("Test"));
        ExchangeServiceException ex = assertThrows(ExchangeServiceException.class, () -> objectUnderTest.calculateEuro2Dollar(1.0));
        assertEquals("Wechselkurs konnte nicht ermittelt werden.", ex.getMessage());

    }

    @Test
    void calculateEuro2Dollar_HappyDay_ReturnsCorrectDollarValue() {

        when(exchangeserviceMock.getRate("USD")).thenReturn(1.1);
        var result = objectUnderTest.calculateEuro2Dollar(10.0);
        assertEquals(11.0, result, 0.001);
        verify(exchangeserviceMock,times(1)).getRate("USD");

    }


}