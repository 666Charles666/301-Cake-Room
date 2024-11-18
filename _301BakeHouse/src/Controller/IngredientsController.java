package Controller;

import model.HashTable;
import model.Ingredient;

import java.util.List;

public class IngredientsController {

    int size;
    HashTable<Ingredient> ingredientHashTable;
    public IngredientsController(int size){
        this.size = size;
        this.ingredientHashTable = new HashTable<>(size);
    }

    public boolean addIngredient(Ingredient ingredient){
        if (ingredient == null){
            return false;
        }
        ingredientHashTable.add(ingredient);
        System.out.println("add successfully");
        return true;
    }

    public String displayIngredient() {
    ingredientHashTable.displayHashTable();
    return "all of ingredient in there";
    }

    public void deleteIngredient(Ingredient ingredient){
        ingredientHashTable.delete(ingredient);
    }

    // public static void main(String[] args) {
    //     IngredientsController ingredientsController = new IngredientsController(10);
    //     Ingredient i= new Ingredient("egg","heihei",100);
    //     ingredientsController.addIngredient(i);
    //     ingredientsController.displayIngredient();
    //     ingredientsController.deleteIngredient(i);
    //     ingredientsController.displayIngredient();

    // }
    }
