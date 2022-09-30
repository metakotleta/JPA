package ru.rvukolov.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rvukolov.jpa.model.Person;
import ru.rvukolov.jpa.model.PersonData;
import ru.rvukolov.jpa.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person getByData(PersonData personData) {
        var person = personRepository.findByPersonData(personData);
        return person.orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public List<Person> getByAge(int age) {
        return personRepository.findByAge(age);
    }

    public List<Person> getByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }
}
