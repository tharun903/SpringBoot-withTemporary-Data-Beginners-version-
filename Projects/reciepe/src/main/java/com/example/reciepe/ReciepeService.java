package com.example.reciepe;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@org.springframework.stereotype.Service

public class ReciepeService implements ReciepeRepository {
    private static HashMap<Integer, Reciepe> recipeBook = new HashMap<>();
    int uniqueId = 6;
    public ReciepeService() {
        recipeBook.put(1,
                new Reciepe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Reciepe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Reciepe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Reciepe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Reciepe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    @Override
    public ArrayList<Reciepe> getReciepe() {
        Collection<Reciepe> reciepes = recipeBook.values();
        ArrayList<Reciepe> reciepiesId = new ArrayList<>(reciepes);
        return reciepiesId;
    }

    @Override
    public Reciepe addRecipes(Reciepe recipe) {
        recipe.setRecipeId(uniqueId);
        recipeBook.put(uniqueId, recipe);
        uniqueId += 1;
        return recipe;


    }

    @Override
    public Reciepe getReciepeById(int recipeId) {
        Reciepe reciepe= recipeBook.get(recipeId);
        if(reciepe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return reciepe;
    }

    @Override
    public Reciepe UpdateReciepe(int recipeId, Reciepe recipe) {
        Reciepe existingId = recipeBook.get(recipeId);
        if(existingId == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(recipe.getRecipeName() != null){
            existingId.setRecipeName(recipe.getRecipeName());
        }
        if(recipe.getRecipeType() != null){
            existingId.setRecipeType(recipe.getRecipeType());
        }
        if(recipe.getIngredients() != null){
            existingId.setIngredients(recipe.getIngredients());
        }
        return existingId;


    }


    public void deleteReciepe(int recipeId) {
        Reciepe recipe = recipeBook.get(recipeId);
        if(recipe == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if(recipe != null){
            recipeBook.remove(recipeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
