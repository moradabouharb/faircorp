package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Room;
import com.esme.spring.faircorp.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Building")
public class HomeController {


    @Autowired
    private LightDao L1;

    public HomeController(){

    }

    @GetMapping({"/hello"})
    public String Hello(){
        return "Hello";
    }

    //http://localhost:8080/api/Building/Light?id=1
    @RequestMapping(value = "Light",method = RequestMethod.GET)
    public List<Light> Getlight(@RequestParam("id") long id){
        return L1.findOnLights(id);
    }



}
