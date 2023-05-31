package com.udacity.vehicles.api;

import com.udacity.vehicles.domain.car.Car;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Maps the CarController to the Car class using HATEOAS
 */

//converting a Car object into a Resource<Car> object, adding links that define relationships and provide navigation capabilities to related resources in the API.
@Component
public class CarResourceAssembler implements ResourceAssembler<Car, Resource<Car>> { //converting a Car object into a Resource<Car>

    @Override
    public Resource<Car> toResource(Car car) { //The Resource class represents a resource in a RESTful API and can contain the actual object (Car) along with links to related resources.
        return new Resource<>(car,
                linkTo(methodOn(CarController.class).get(car.getId())).withSelfRel(), //It points to the endpoint in the CarController class that handles retrieving a specific car by its ID
                linkTo(methodOn(CarController.class).list()).withRel("cars")); //It points to the endpoint in the CarController class that handles listing all cars.

    }
}
