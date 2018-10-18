package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Room;
import com.esme.spring.faircorp.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    @Autowired
    private LightDao L1;

    public HomeController(){

    }

    @GetMapping({"/hello"})
    public String Hello(){
        return "Hello";
    }


    @GetMapping({"/light/{id}"})
    public List<Light> Getlight(@PathVariable long id){
        return L1.findOnLights(id);
    }



}
