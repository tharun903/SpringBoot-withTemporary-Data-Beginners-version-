package com.example.reciepe;

import java.util.List;

public class Reciepe {
    private Integer recipeId;
    private String recipeName;
    private  String recipeType;
    private List ingredients;

    public Reciepe(Integer recipeId,String recipeName,String recipeType,List ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public List getIngredients() {
        return ingredients;
    }

    public void setIngredients(List ingredients) {
        this.ingredients = ingredients;
    }
}
