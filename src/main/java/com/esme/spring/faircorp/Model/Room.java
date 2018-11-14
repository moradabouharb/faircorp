package com.esme.spring.faircorp.Model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
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

    public Room(String name,int floor){
        this.Name = name;
        this.Floor = floor;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public int getFloor(){
        return Floor;
    }

    public void setFloor(int floor){
        this.Floor = floor;
    }
/*
    public Set<Light> getLights(){
        return lights;
    }

    public void setlights(Set<Light>lights){
        this.lights = lights;
    }
*/
}
