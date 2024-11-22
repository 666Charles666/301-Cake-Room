package Controller;

import model.HashTable;
import model.Ingredient;
import model.Recipes;
import model.RecipesHash;

import java.util.Scanner;

public class RecipesController {
    int size;
    RecipesHash recipesHashTable;
    BakeGoodsController bakeGoodsController;
    public RecipesController(int size){
        this.size = size;
        this.recipesHashTable = new RecipesHash(size);
    }
    public String add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What good's recipes do you want to add?");
        String bakeGood = scanner.nextLine();
        Recipes recipes = new Recipes(bakeGood);
        String finalIngredient = "";
        while (true){
            System.out.println("What ingredient do you want to add?(or input finish to finish add)");
            String ingredient = scanner.nextLine();
            if (ingredient.equals("finish")){
                System.out.println("ingredient added successfully");
                break;
            }
            System.out.println("please enter the quantity(e.g. 10ml/10g)");
            String  quantity = scanner.nextLine();
             finalIngredient += ingredient + " " + quantity + " ";
        }
        recipesHashTable.add(bakeGood,finalIngredient);
        return "add successfully!";
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
        recipesController.add();
        recipesController.display();
        System.out.println(recipesController.search("burger"));

    }
}
