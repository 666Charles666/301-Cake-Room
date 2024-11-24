package Controller;

import model.HashTable;
import model.Ingredient;

import java.io.*;
import java.util.Scanner;

public class IngredientsController implements Serializable {

    public int size;

    public HashTable<Ingredient> getIngredientHashTable() {
        return ingredientHashTable;
    }

    public void setIngredientHashTable(HashTable<Ingredient> ingredientHashTable) {
        this.ingredientHashTable = ingredientHashTable;
    }

    public HashTable<Ingredient> ingredientHashTable;
    Scanner scanner = new Scanner(System.in);

    public IngredientsController(int size) {
        this.size = size;
        this.ingredientHashTable = new HashTable<>(size);
    }

    public boolean addIngredient(String name, String textualDes, double calorie) {

        if (name == null || textualDes == null || calorie < 0) {
            System.out.println("add fault");
            return false;
        }
        Ingredient ingredient = new Ingredient(name, textualDes, calorie);
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


    public boolean deleteIngredient(Ingredient ingredient) {
        for (int i = 0; i < size; i++) {
            Ingredient currentIngredient = ingredientHashTable.get(i);
            if (currentIngredient != null && currentIngredient.getName().equals(ingredient.getName())) {
                ingredientHashTable.delete(ingredientHashTable.get(i));
//                System.out.println("delete successfully");
                return true;
            }

        }
        System.out.println("can't find the ingredient of this name");
        return false;
    }

    public Ingredient searchByName(String ingredientName) {
        for (int i = 0; i < size; i++) {
            Ingredient item = ingredientHashTable.get(i);
            if (item != null && item.getName().equals(ingredientName)) {
                System.out.println("search successfully");
                System.out.println(item.toString());
                return item;
            }
        }
        return null;
    }

    public Ingredient[] searchByCalorie(double calorie) {
        class Node {
            Ingredient ingredient;
            Node next;
            Node(Ingredient ingredient) {
                this.ingredient = ingredient;
                this.next = null;
            }
        }

        Node head = null;
        Node tail = null;
        int count = 0;
        for (int i = 0; i < size; i++) {
            Ingredient item = ingredientHashTable.get(i);
            if (item != null && item.getCalorie() == calorie) {
                Node newNode = new Node(item);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Can't find the ingredient with this calorie");
            return null;
        }

        Ingredient[] result = new Ingredient[count];
        Node current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.ingredient;
            current = current.next;
        }

        System.out.println("we can find the " + count + " ingredients with this specified calorie value:");
        for (Ingredient ingredient : result) {
            System.out.println(ingredient.toString());
        }
        return result;
    }


    public boolean update(Ingredient ingredient) {
        Ingredient item = searchByName(ingredient.getName());
        if (item != null) {
            for (int i = 0; i < size; i++) {
                Ingredient temp = ingredientHashTable.get(i);
                if (item.toString().equals(temp.toString())) {
                    ingredientHashTable.get(i).setTextualDes(ingredient.getTextualDes());
                    ingredientHashTable.get(i).setCalorie(ingredient.getCalorie());
                    return true;
                }
            }
        }
        return false;
    }


//    public static void main(String[] args) {
//        IngredientsController ingredientsController = new IngredientsController(50);
//        ingredientsController.addIngredient("香菜","好吃",12.6);
//        System.out.println(ingredientsController.displayIngredient());
//        ingredientsController.search("香菜");
//
//        System.out.println(ingredientsController.displayIngredient());
//    }

}
