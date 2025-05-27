package de.gothaer.service.impl;

import de.gothaer.persistence.Person;
import de.gothaer.persistence.PersonenRepository;
import de.gothaer.service.BlacklistService;
import de.gothaer.service.PersonenService;
import de.gothaer.service.PersonenServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonenServiceImplTest {

    @InjectMocks
    private PersonenServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository repoMock;

    @Mock
    private BlacklistService blacklistServiceMock ;


    private final Person validPerson = Person.builder().id("1234").vorname("John").nachname("Doe").build();

    @Test
    void speichern_ParameterIsNull_throwsPersonenServiceException() {
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(null));
        assertEquals("Parameter darf nicht null sein",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_VornameIsNull_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname(null).nachname("Doe").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Vorname zu kurz",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_VornameToShort_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname("J").nachname("Doe").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Vorname zu kurz",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_NachnameIsNull_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname("John").nachname(null).build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Nachname zu kurz",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_NachnameToShort_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname("John").nachname("D").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Nachname zu kurz",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_UnerwuenschtePerson_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname("John").nachname("der Hunne").build();
        when(blacklistServiceMock.isBlacklisted(invalidPerson)).thenReturn(true);
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Unerwuenschte Person",ex.getMessage());
        verify(repoMock, never()).save(any(Person.class));
    }

    @Test
    void speichern_UnexpectedRuntimeExceptionInUnderlyingService_throwsPersonenServiceException() {

        doThrow(ArrayIndexOutOfBoundsException.class).when(repoMock).save(any(Person.class));
        PersonenServiceException ex = assertThrows(PersonenServiceException.class, () -> objectUnderTest.speichern(validPerson));
        assertEquals("Es ist ein Fehler aufgetreten", ex.getMessage());
        assertInstanceOf(ArrayIndexOutOfBoundsException.class, ex.getCause());
    }

    @Test
    void speichern_Happyday_personPassedToRepoAndNoExceptionIsThrown() {
        when(blacklistServiceMock.isBlacklisted(validPerson)).thenReturn(false);
        assertDoesNotThrow(()->objectUnderTest.speichern(validPerson));
        verify(repoMock).save(validPerson);
    }

}