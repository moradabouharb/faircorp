package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Building")
public class HomeController {

    @Autowired
    private LightDao L1;
    @Autowired
    private RoomDao R1;

    public HomeController(){
    }

    @GetMapping({"/hello"})
    public String Hello(){
        return "Hello";
    }

    //http://localhost:8080/api/Building/Light?id=1
    @RequestMapping(value = "Light",method = RequestMethod.GET, produces = "application/json")
    public Light Getlight(@RequestParam("id") long id){
        //return L1.findOnLights(id);
        Optional<Light> light = L1.findById(id);
        return light.get();
    }

    //http://localhost:8080/api/Building/Lights
    @RequestMapping(value = "Lights",method = RequestMethod.GET, produces = "application/json")
    public List<Light> Getlights(){
        return L1.findAll();
    }

    //http://localhost:8080/api/Building/Rooms
    @RequestMapping(value = "Rooms",method = RequestMethod.GET, produces = "application/json")
    public List<Room> GetRooms(){
        return R1.findAll();
    }

}
