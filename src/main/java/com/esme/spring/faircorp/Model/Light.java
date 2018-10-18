package com.esme.spring.faircorp.Model;

import javax.persistence.*;

@Entity
public class Light {

    @Id
    @GeneratedValue
    private long Light_ID;

    @Column(nullable = false,length = 255)
    private int Level;

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private String Status;

    @JoinColumn(name = "Room_ID")
    private long Room_ID;

    public Light(){
    }

    public Light(int level, String status){
        this.Level = level;
        this.Status = status;
    }
}
