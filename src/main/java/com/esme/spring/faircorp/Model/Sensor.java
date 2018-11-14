package com.esme.spring.faircorp.Model;
import javax.persistence.*;

@Entity
@Table(name = "SENSOR")
public class Sensor {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,length = 255)
    private float temp;
    @Column(nullable = false,length = 255)
    private float hum;

    public void sensor(){}

    public void sensor(float temp,float hum){
        this.temp = temp;
        this.hum = hum;
    }

    public long getId(){
        return id;
    }

    public float gettemp(){
        return temp;
    }

    public void settemp(float temp){
        this.temp = temp;
    }

    public float getHum(){
        return hum;
    }

    public void setHum(float hum){
        this.hum = hum;
    }
}
