package Controller;

import model.HashTable;
import model.Ingredient;

import java.util.Scanner;

public class IngredientsController {

    int size ;
    HashTable<Ingredient> ingredientHashTable;
    Scanner scanner = new Scanner(System.in);
    public IngredientsController(int size){
        this.size = size;
        this.ingredientHashTable = new HashTable<>(size);
    }

    public void addIngredient(String name,String textualDes,double calorie){

        if (name == null && textualDes == null && calorie <0){
            System.out.println("add fault");
            return;
        }
        Ingredient ingredient = new Ingredient(name,textualDes,calorie);
        ingredientHashTable.add(ingredient);
    }

    public void displayIngredient() {
        System.out.println("all of ingredients in there");
        ingredientHashTable.displayHashTable();
    }

    public void deleteIngredient(String ingredient){
        for (int i = 0; i < size ;i++){
            if (ingredientHashTable.get(i).getName().equals(ingredient)){
                ingredientHashTable.delete(ingredientHashTable.get(i));
                System.out.println("add successfully");
            }
            System.out.println("can't find the ingredient of this name");
        }
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

    public void update(String name){
        deleteIngredient(name);
        System.out.println("please input ingredient's textualDes");
        String textualDes = scanner.nextLine();
        System.out.println("please input How many calorie it have");
        double calorie = scanner.nextDouble();
        addIngredient(name,textualDes,calorie);
        System.out.println("add successfully");
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
