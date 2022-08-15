package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;

import java.util.List;
import java.util.Optional;

public interface GreetingInterface {
    Greeting message();

    String saveTheGreetingMessage(Person person);

    Optional<Person> findById(long id);

    List<Person> findAllPerson();
}
