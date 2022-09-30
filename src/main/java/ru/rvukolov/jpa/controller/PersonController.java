package ru.rvukolov.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.rvukolov.jpa.model.Person;
import ru.rvukolov.jpa.model.PersonData;
import ru.rvukolov.jpa.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/byData")
    public Person getByData(@Validated PersonData personData) {
        return personService.getByData(personData);
    }

    @GetMapping("/byAge")
    public List<Person> getByAge(int age) {
        return personService.getByAge(age);
    }

    @GetMapping("/byCity")
    public List<Person> getByCity(String city) {
        return personService.getByCity(city);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleExceptions(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
