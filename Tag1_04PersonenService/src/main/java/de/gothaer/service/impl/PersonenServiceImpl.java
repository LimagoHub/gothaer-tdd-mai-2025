package de.gothaer.service.impl;

import de.gothaer.persistence.Person;
import de.gothaer.persistence.PersonenRepository;
import de.gothaer.service.PersonenService;
import de.gothaer.service.PersonenServiceException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonenServiceImpl implements PersonenService {


    private final PersonenRepository personenRepository;


    /*
       1.) wenn person = null => PSE
       2.) wenn vorname null oder weniger als 2 Zeichen => PSE
       3.) wenn nachname null oder weniger als 2 Zeichen => PSE
       4.) wenn Vorname = Attila => PSE
       5.) wenn Laufzeitfehler => PSE

       Happy day => person via repo speichern
    */
    @Override
    public void speichern(final Person person) throws PersonenServiceException {
        try {
            speichernImpl(person);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Es ist ein Fehler aufgetreten",e);
        }
    }

    private void speichernImpl(final Person person) throws PersonenServiceException {
        if(person == null)
            throw new PersonenServiceException("Parameter darf nicht null sein");
        if(person.getVorname() == null || person.getVorname().length() < 2)
            throw new PersonenServiceException("Vorname zu kurz");
        if(person.getNachname() == null || person.getNachname().length() < 2)
            throw new PersonenServiceException("Nachname zu kurz");

        if(person.getVorname().equals("Attila"))
            throw new PersonenServiceException("Unerwuenschte Person");


        personenRepository.save(Person.builder().build());
    }
}
