package es.thalesalv.poc.dynamiccontroller.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.poc.dynamiccontroller.exception.ResourceNotFoundException;
import es.thalesalv.poc.dynamiccontroller.model.Person;
import es.thalesalv.poc.dynamiccontroller.repository.PersonRepository;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/${app.endpoint.person:person}")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    @GetMapping
    public List<Person> getAllPersons() {

        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {

        return personRepository.save(person);
    }
}
