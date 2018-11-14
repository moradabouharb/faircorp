package com.esme.spring.faircorp.Model;

import javax.persistence.*;

@Entity
@Table(name = "LIGHT")
public class Light {

    @Id
    @GeneratedValue
    private long Light_ID;

    @Column(nullable = false,length = 255)
    private int Level;

    @Column(nullable = false)
    private String Status;

    @JoinColumn(name = "Room_ID")
    private long Room_ID;


    public Light(){
    }

    public Light(int level, String status) {
        this.Level = level;
        this.Status = status;
    }


    public long getId(){
        return Light_ID;
    }

    public void setId(long Light_ID){
        this.Light_ID = Light_ID;
    }

    public int getLevel(){
        return Level;
    }

    public void setLevel(int Level){
        this.Level = Level;
    }

    public String getStatus(){
        return Status;
    }

    public void setStatus(String status){
        this.Status = status;
    }

    public long getRoom(){
        return Room_ID;
    }

    public void setRoom(long Room_ID){
        this.Room_ID = Room_ID;
    }

}
