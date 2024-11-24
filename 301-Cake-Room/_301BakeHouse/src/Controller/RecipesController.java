package Controller;

import model.HashTable;
import model.Ingredient;
import model.Recipes;
import model.RecipesHash;

import java.util.Scanner;

public class RecipesController {
    public int size;
    public RecipesHash recipesHashTable;
    BakeGoodsController bakeGoodsController;
    public RecipesController(int size){
        this.size = size;
        this.recipesHashTable = new RecipesHash(size);
    }
    public String searchByName(String bakeGood){
        if ( bakeGood != null ){
            return "Search result for 'burger': " + recipesHashTable.get(bakeGood);
        } return "No recipe found for 'burger'.";
    }
    public String searchByIngredient(String ingredient) {
        String result = "";
        boolean findIngredient = false;

        for (int i = 0; i < recipesHashTable.getSize(); i++) {
            RecipesHash.Object recipe = recipesHashTable.getTable()[i];
            if (recipe != null ) {

                if (recipe.getValue().contains(ingredient)) {
                    findIngredient = true;
                    result += "Recipe Name: " + recipe.getKey() + "\n";
                    result += "Ingredients: " + recipe.getValue() + "\n";
                    result += "----------------------------------" + "\n";
                }
            }
        }


        if (!findIngredient) {
            return "Sorry,no recipes have found containing this ingredient: " + ingredient + "\n";
        }

        return result;
    }
    public boolean update(String bakeGood) {
        Scanner scanner = new Scanner(System.in);

        String existingRecipe = recipesHashTable.get(bakeGood);
        if (existingRecipe == null) {
            System.out.println("Can't find the recipe of this name");
            return false;
        }

        System.out.println("Updating recipe for " + bakeGood);
        String finalIngredient = "";
        while (true) {
            System.out.println("What ingredient do you want to add? (or input 'finish' to finish update)");
            String ingredient = scanner.nextLine();
            if (ingredient.equals("finish")) {
                System.out.println("Ingredients updated successfully.");
                break;
            }
            System.out.println("Please enter the quantity (e.g. 10ml/10g):");
            String quantity = scanner.nextLine();
            finalIngredient += ingredient + " " + quantity + " ";
        }

        recipesHashTable.delete(bakeGood);
        recipesHashTable.add(bakeGood, finalIngredient);
        return true;
    }
    public boolean add(String bakeGood ,String ingredients){
       recipesHashTable.add(bakeGood,ingredients);
       return true;
    }
    public void display(){
        recipesHashTable.display();
    }
    public void delete(String bakeGood){
        recipesHashTable.delete(bakeGood);
        System.out.println("delete successfully");
    }
    public String search(String bakeGood){
        if ( bakeGood != null ){
            return "Search result for 'burger': " + recipesHashTable.get(bakeGood);
        } return "No recipe found for 'burger'.";
    }

    public static void main(String[] args) {
        RecipesController recipesController = new RecipesController(50);
        recipesController.display();
        System.out.println(recipesController.search("burger"));

    }
}