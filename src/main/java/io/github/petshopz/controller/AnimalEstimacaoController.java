package io.github.petshopz.controller;

import io.github.petshopz.model.AnimalEstimacaoModel;
import io.github.petshopz.service.AnimalEstimacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/petshopz")
public class AnimalEstimacaoController {

    // INJEÇÃO DE DEPENDÊNCIA
    private AnimalEstimacaoService animalEstimacaoService;

    // CONSTRUTOR
    public AnimalEstimacaoController(AnimalEstimacaoService animalEstimacaoService) {
        this.animalEstimacaoService = animalEstimacaoService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    // ADICIONAR
    @PostMapping("/add-animal")
    public void adicionarAnimalEstimacao(@RequestBody AnimalEstimacaoModel animal){
        animalEstimacaoService.adicionarAnimal(animal);
    }
    // LISTAR
    @GetMapping("/animals")
    public ArrayList<AnimalEstimacaoModel> listarAnimaisCadastrados(){
        return animalEstimacaoService.listarAnimais();
    }

    // DELETAR
    @DeleteMapping("/deletar-animal")
    public void deletarAnimalEstimacao(int id){
        animalEstimacaoService.removerAnimal(id);
    }
}
