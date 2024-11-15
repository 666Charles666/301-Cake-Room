package Controller;

import model.HashTable;
import model.Ingredient;

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
        return true;
    }
    public void displayIngredient() {
    ingredientHashTable.displayHashTable();
    }

//    public static void main(String[] args) {
//        IngredientsController ingredientsController = new IngredientsController(10);
//        System.out.println(ingredientsController.size);
//        Ingredient i= new Ingredient("egg","heihei",100);
//        ingredientsController.addIngredient(i);
//        ingredientsController.displayIngredient();
//    }
    }
