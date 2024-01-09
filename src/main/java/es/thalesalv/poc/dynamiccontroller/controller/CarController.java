package es.thalesalv.poc.dynamiccontroller.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.poc.dynamiccontroller.exception.ResourceNotFoundException;
import es.thalesalv.poc.dynamiccontroller.model.Car;
import es.thalesalv.poc.dynamiccontroller.repository.CarRepository;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/${app.endpoint.car:car}")
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {

        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found"));
    }

    @GetMapping
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car Car) {

        return carRepository.save(Car);
    }
}
