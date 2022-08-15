package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;
import com.bridgelabz.greetingapp.service.GreetingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String hello = "Hello %s!";
    private final AtomicLong id = new AtomicLong();

    @Autowired
    private GreetingInterface greetingInterface;

    @GetMapping("/greeting")
    public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(id.incrementAndGet(), String.format(hello, name));
    }

    @GetMapping("/greeting/{name}")
    public Greeting sayHelloWithName(@PathVariable String name) {
        return new Greeting(id.incrementAndGet(), String.format(hello, name));
    }

    @GetMapping("/greeting/servicelayer")
    public Greeting sayHelloFromServiceLayer(){
        return greetingInterface.message();
    }

    @PostMapping("/greeting/servicelayer/person")
    public Greeting sayHelloFromServiceLayerByPerson(@RequestBody Person person){
        return new Greeting(id.incrementAndGet(),String.format(hello,person.getFirst_name()+" "+person.getLast_name()));
    }
    @GetMapping("greeting/servicelayer/id")
    public Greeting sayHelloFromServiceLayerByPerson(@RequestParam(value = "first_name" ,defaultValue ="Megha")String first_name,@RequestParam(value = "last_name" ,defaultValue = "Jagadale")String last_name){
        return new Greeting(id.incrementAndGet(),String.format(hello,first_name+" "+last_name));
    }
}
