package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class GreetingService implements GreetingInterface {
    private static final String greetings = "Hello World";
    private final AtomicLong id = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;
    @Override
    public Greeting message() {
        return new Greeting(id.incrementAndGet(), String.format(greetings));
    }

    @Override
    public String saveTheGreetingMessage(Person person) {
        greetingRepository.save(person);
        return "Hello "+person.getFirst_name()+" "+person.getLast_name();
    }
    @Override
    public Optional<Person> findById(long id) {
        Optional<Person> person = greetingRepository.findById(id);
        return person;
    }

    @Override
    public List<Person> findAllPerson() {
        List<Person> greeting = greetingRepository.findAll();
        return greeting;
    }
}
