package es.thalesalv.poc.dynamiccontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.thalesalv.poc.dynamiccontroller.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
