package com.example.reciepe;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReciepeController {

    private final ReciepeService service;

    public ReciepeController(ReciepeService service){
        this.service = service;
    }

    @GetMapping("/recipes")
    public ArrayList<Reciepe> getReciepe() {
        return service.getReciepe();
    }

    @PostMapping("/recipes")
    public Reciepe addRecipes(@RequestBody Reciepe recipe){
        return service.addRecipes(recipe);
    }

    @GetMapping("/recipes/{recipeId}")
    public Reciepe getReciepeById(@PathVariable("recipeId")int recipeId){
        return service.getReciepeById(recipeId);
    }

    @PutMapping("/recipes/{recipeId}")
    public Reciepe UpdateReciepe(@PathVariable("recipeId")int recipeId,@RequestBody Reciepe recipe){
        return service.UpdateReciepe(recipeId,recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteReciepe(@PathVariable("recipeId")int recipeId){
        service.deleteReciepe(recipeId);
    }


}
