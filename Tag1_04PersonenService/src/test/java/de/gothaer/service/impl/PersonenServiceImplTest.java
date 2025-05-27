package de.gothaer.service.impl;

import de.gothaer.persistence.Person;
import de.gothaer.persistence.PersonenRepository;
import de.gothaer.service.PersonenService;
import de.gothaer.service.PersonenServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonenServiceImplTest {

    @InjectMocks
    private PersonenServiceImpl objectUnderTest;

    @Mock
    private PersonenRepository repoMock;

    @Test
    void speichern_ParameterIsNull_throwsPersonenServiceException() {
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(null));
        assertEquals("Parameter darf nicht null sein",ex.getMessage());

    }

    @Test
    void speichern_VornameIsNull_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname(null).nachname("Doe").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Vorname zu kurz",ex.getMessage());

    }

    @Test
    void speichern_VornameToShort_throwsPersonenServiceException() {
        Person invalidPerson = Person.builder().id("1234").vorname("J").nachname("Doe").build();
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichern(invalidPerson));
        assertEquals("Vorname zu kurz",ex.getMessage());

    }


}