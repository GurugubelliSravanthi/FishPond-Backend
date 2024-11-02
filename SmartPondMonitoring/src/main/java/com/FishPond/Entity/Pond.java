package com.FishPond.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "ponds") // Specifies the MongoDB collection name
public class Pond {
    
    @Id // Marks this field as the primary key
    private String id;
    private String name;
    private List<Sensor> sensors = new ArrayList<>();

    // Default constructor (required by MongoDB and Spring Data)
    public Pond() {}

    // Constructor with ID and name
    public Pond(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    // Method to add a single sensor to the pond
    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }
}