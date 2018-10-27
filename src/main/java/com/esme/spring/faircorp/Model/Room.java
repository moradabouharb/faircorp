package com.esme.spring.faircorp.Model;

import javax.persistence.*;
import java.nio.MappedByteBuffer;
import java.util.List;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    public long Room_ID;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private int Floor;

    @OneToMany
    private Set<Light> lights;

    public Room(){
    }

    // write getter and setter for each properity..

}
