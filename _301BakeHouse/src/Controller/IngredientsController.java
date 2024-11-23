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

    public boolean addIngredient(String name,String textualDes,double calorie){

        if (name == null || textualDes == null || calorie <0){
            System.out.println("add fault");
            return false;
        }
        Ingredient ingredient = new Ingredient(name,textualDes,calorie);
        ingredientHashTable.add(ingredient);
        return true;
    }

    public String displayIngredient() {
        StringBuilder result = new StringBuilder("All ingredients in the hash table:\n");
        for (int i = 0; i < size; i++) { // Assuming getSize() provides the size of hashTable
            Ingredient ingredient = ingredientHashTable.get(i);
            if (ingredient == null) {
                result.append(i).append(": null\n");
            } else {
                result.append(i).append(": ").append(ingredient.toString()).append("\n");
            }
        }
        return result.toString();
    }



    public boolean deleteIngredient(String ingredient){
        for (int i = 0; i < size ;i++){
            Ingredient currentIngredient = ingredientHashTable.get(i);
            if (currentIngredient != null && currentIngredient.getName().equals(ingredient)){
                ingredientHashTable.delete(ingredientHashTable.get(i));
//                System.out.println("delete successfully");
                return true;
            }

        }
        System.out.println("can't find the ingredient of this name");
        return false;
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

    public boolean update(String name){
//        deleteIngredient(name);
        if (!deleteIngredient(name)){
            System.out.println("update fault, can't find this ingredient");
            return false;
        }
        System.out.println("please input the new ingredient's textualDes");
        String textualDes = scanner.nextLine();
        System.out.println("please input How many calorie it have");
        double calorie = scanner.nextDouble();
        scanner.nextLine();
        boolean added = addIngredient(name,textualDes,calorie);
        if (added) {

            return true;
        }else{
            System.out.println("Update failed,couldn't add updated ingredient.");
            return false;
        }
    }

    // public static void main(String[] args) {
    //     IngredientsController ingredientsController = new IngredientsController(50);
    //     ingredientsController.addIngredient("香菜","好吃",12.6);
    //     System.out.println(ingredientsController.displayIngredient());
    //     ingredientsController.search("香菜");
    //     ingredientsController.update("香菜");
    //     System.out.println(ingredientsController.displayIngredient());
    // }

}
