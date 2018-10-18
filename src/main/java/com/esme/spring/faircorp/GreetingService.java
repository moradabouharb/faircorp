package com.esme.spring.faircorp;


import org.springframework.stereotype.Service;

@Service
class ConsoleGreetingService implements GreetingServices{
    @Override
    public void Greet(String name) {
        System.out.println("Hello"+ name);
    }
}
