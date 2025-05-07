package io.github.petshopz.service;

import io.github.petshopz.model.AnimalEstimacaoModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnimalEstimacaoService {
    private AnimalEstimacaoModel animal;
    private ArrayList<AnimalEstimacaoModel> animaisDeEstimacao = new ArrayList<>(Arrays.asList(
            new AnimalEstimacaoModel(AnimalEstimacaoModel.createId(),"Thor","Cachorro", 5, "Pedro"),
            new AnimalEstimacaoModel(AnimalEstimacaoModel.createId(), "Apophis","Cobra", 2, "José")
    ));

    public ArrayList<AnimalEstimacaoModel> listarAnimais(){
        return this.animaisDeEstimacao;
    }

    public void adicionarAnimal(AnimalEstimacaoModel animal){
        animal.setId(AnimalEstimacaoModel.createId());
        animaisDeEstimacao.add(animal);
    }

    public void removerAnimal(int animalId){
        animaisDeEstimacao.removeIf(animal -> animal.getId() == animalId);
    }
}
