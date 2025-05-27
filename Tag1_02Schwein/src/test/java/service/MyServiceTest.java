package service;

import dependency.Dependency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyServiceTest {

    @InjectMocks
    private MyService objectUnderTest;

    @Mock
    private Dependency dependencyMock ;

    /*@BeforeEach
    void setup(){
        dependencyMock = mock(Dependency.class);

        objectUnderTest = new MyService(dependencyMock);
    }*/
    @Test
    void eins_test() {

        // Arrange
        //Record
        when(dependencyMock.bar())
                .thenReturn(10)
                .thenReturn(20);

        //Replay
        // act + assert
        assertEquals(200, objectUnderTest.eins());

        verify(dependencyMock, atLeast(1)).bar();
    }

    @Test
    void zwei_test() {

        // Arrange
        //Record
        //when(dependencyMock.bar()).thenReturn(10);
        doNothing().when(dependencyMock).foo(47);
        //Replay
        // act + assert
        objectUnderTest.zwei();

        verify(dependencyMock, atLeast(1)).foo(47);
    }

    @Test
    void drei_test() {
        // Arrange
        // Recordmode
        when(dependencyMock.foobar("Hallo Bilbo")).thenReturn(5);
        when(dependencyMock.foobar("Hallo Frodo")).thenReturn(100);

        // Replaymode
        // Act
        var result = objectUnderTest.drei();

        verify(dependencyMock).foobar("Hallo Bilbo");
        assertEquals(15, result);
    }
}