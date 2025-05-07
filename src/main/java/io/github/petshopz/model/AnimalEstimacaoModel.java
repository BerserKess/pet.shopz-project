package io.github.petshopz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@AllArgsConstructor
@Data
public class AnimalEstimacaoModel {
    int id;
    private String name;
    private String type;
    private int age;
    private String owner;

    public static int createId(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
