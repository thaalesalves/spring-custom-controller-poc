package es.thalesalv.poc.dynamiccontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.thalesalv.poc.dynamiccontroller.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
