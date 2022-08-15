package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.Person;

public interface GreetingInterface {
    Greeting message();

    String saveTheGreetingMessage(Person person);

}
