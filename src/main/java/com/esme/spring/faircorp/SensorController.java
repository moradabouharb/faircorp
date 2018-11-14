package com.esme.spring.faircorp;
import com.esme.spring.faircorp.Model.Sensor;
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
@RequestMapping("/api/sensor")
public class SensorController {

    @Autowired
    private SensorDao S1;

    @PersistenceContext
    private EntityManager em;

    public SensorController(){}


    ///Get:

    //http://localhost:8080/api/sensor?id=1
    @RequestMapping(params = "id",method = RequestMethod.GET,produces = "application/json")
    public Sensor Getsensor(@RequestParam("id") long id){
        Optional<com.esme.spring.faircorp.Model.Sensor> sensor = S1.findById(id);
        return sensor.get();
    }

    //http://localhost:8080/api/sensor?all
    @RequestMapping(params = "all",method = RequestMethod.GET, produces = "application/json")
    public List<com.esme.spring.faircorp.Model.Sensor> Getlights(){
        return S1.findAll();
    }

    /// Post:
    @PostMapping("sendvalues")
    public ResponseEntity<Object> Sendvalues(@RequestBody com.esme.spring.faircorp.Model.Sensor s){
        Sensor saveValue = S1.save(s);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveValue.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
