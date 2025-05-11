package io.github.petshopz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

//@AllArgsConstructor
//@Data
public class AnimalEstimacaoModel {
    int id;
    private String name;
    private String type;
    private int age;
    private String owner;

    public AnimalEstimacaoModel(int id, String name, String type, int age, String owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static int createId(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
