package Controller;

import model.HashTable;
import model.Ingredient;

public class IngredientsController {

    int size ;
    HashTable<Ingredient> ingredientHashTable;
    public IngredientsController(int size){
        this.size = size;
        this.ingredientHashTable = new HashTable<>(size);
    }

    public void addIngredient(Ingredient ingredient){
        if (ingredient == null){
            return;
        }
        ingredientHashTable.add(ingredient);
    }

    public void displayIngredient() {
        System.out.println("all of ingredients in there");
        ingredientHashTable.displayHashTable();
    }

    public void deleteIngredient(Ingredient ingredient){
        ingredientHashTable.delete(ingredient);
    }
    public String search(String ingredientName){
        for (int i = 0 ;i < size;i++){
            Ingredient item = ingredientHashTable.get(i);

            if (item != null && item.getName().equals(ingredientName)) {
                System.out.println("search successfully");
                System.out.println(item.toString());
                return item.toString();
            }
        }
        return "search default";
    }

//    public static void main(String[] args) {
//        IngredientsController ingredientsController = new IngredientsController(50);
//        Ingredient i= new Ingredient("egg","heihei",100);
//        ingredientsController.addIngredient(i);
//        ingredientsController.displayIngredient();
//        ingredientsController.addIngredient(new Ingredient("oil","nianhuhu",500));
//        ingredientsController.displayIngredient();
//        ingredientsController.search("egg");
//    }
}
