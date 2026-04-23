package com.example.reciepe;
import java.util.ArrayList;

public interface ReciepeRepository {
    ArrayList<Reciepe> getReciepe();

    Reciepe addRecipes(Reciepe recipe);

    Reciepe getReciepeById(int recipeId);

    Reciepe UpdateReciepe(int recipeId, Reciepe recipe);
}
