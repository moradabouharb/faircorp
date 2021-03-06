package com.esme.spring.faircorp;

import com.esme.spring.faircorp.Model.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/building/light")
public class LightCOntroller {

    @Autowired
    private LightDao L1;

    //@Autowired
    //private RoomDao R1;

    @PersistenceContext
    private EntityManager em;

    public LightCOntroller(){
    }

    //http://localhost:8080/api/Building/Light?id=1
    @RequestMapping(params = "id",method = RequestMethod.GET,produces = "application/json")
    public Light Getlight(@RequestParam("id") long id){
        //return L1.findOnLights(id);
        Optional<Light> light = L1.findById(id);
        return light.get();
    }

    //http://localhost:8080/api/building/light?level=2
    @RequestMapping(params = "level",method = RequestMethod.GET,produces = "application/json")
    public List<Light> GetLightON(@RequestParam("level") int Level){
        String Qsql = "SELECT c FROM Light c WHERE c.Level =:Level";
        return em.createQuery(Qsql,Light.class).setParameter("Level",Level).getResultList();
    }

    //http://localhost:8080/api/building/light?status=on
    @RequestMapping(params = "status",method = RequestMethod.GET,produces = "application/json")
    public List<Light> GetLightON(@RequestParam("status") String Status){
        String Qsql = "SELECT c FROM Light c WHERE LOWER(c.Status) =:Status";
        return em.createQuery(Qsql,Light.class).setParameter("Status",Status).getResultList();
    }

    //http://localhost:8080/api/building/light?all
    @RequestMapping(params = "all",method = RequestMethod.GET, produces = "application/json")
    public List<Light> Getlights(){
            return L1.findAll();
    }


    @PostMapping("addlight")
    public ResponseEntity<Object> addlight(@RequestBody Light l){
        Light savelight = L1.save(l);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savelight.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/{id}/switch")
    public void switchStatus(@PathVariable Long id, @RequestBody Light l) {
        Light light = L1.findById(id).orElseThrow(IllegalArgumentException::new);
            light.setStatus(l.getStatus());
            light.setLevel(l.getLevel());
            light.setRoom(l.getRoom());
            L1.save(light);
        }
    }
