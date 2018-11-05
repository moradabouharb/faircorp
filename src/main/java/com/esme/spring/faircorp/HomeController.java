package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import com.esme.spring.faircorp.Model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/Building")
public class HomeController {

    @Autowired
    private LightDao L1;

    @Autowired
    private RoomDao R1;

    @PersistenceContext
    private EntityManager em;

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
/*
    //http://localhost:8080/api/Building/Lightss?level=2
    @RequestMapping(value = "Lightss",method = RequestMethod.GET,produces = "application/json")
    public List<Light> GetLightON(@RequestParam("Level") int Level){
        String Qsql = "SELECT c FROM Light c WHERE c.Level =:Level";
        return em.createQuery(Qsql,Light.class).setParameter("Level",Level).getResultList();
    }
*/
    //http://localhost:8080/api/Building/Lightss?Status=on
    @RequestMapping(value = "Lightss",method = RequestMethod.GET,produces = "application/json")
    public List<Light> GetLightON(@RequestParam("Status") String Status){
        String Qsql = "SELECT c FROM Light c WHERE LOWER(c.Status) =:Status";
        return em.createQuery(Qsql,Light.class).setParameter("Status",Status).getResultList();
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
