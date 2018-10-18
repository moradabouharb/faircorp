package com.esme.spring.faircorp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DummyUserService {
    // list of string..
    private List<String> Namelist = Arrays.asList("Elodie","Charles");

    private GreetingServices c1;
    //injector by setter
    @Autowired
    public void SetC1(GreetingServices c1){
        this.c1 = c1;
    }

    public void GreetAll(){
        for (String Name : Namelist){
            c1.Greet(Name);
        }
        //Namelist.forEach(name -> c1.Greet(n)); Another way to define loop
    }
}