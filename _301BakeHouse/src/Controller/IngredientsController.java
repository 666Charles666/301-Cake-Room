package Controller;

import model.HashTable;
import model.Ingredient;

import java.io.*;

/**
 *This is a way that stores methods and controls ingredients
 * Interfaces are there to ensure persistence
 */
public class IngredientsController implements Serializable {
    /**
     * So the simple linked list here is for the searchByCalorie service, which is easy to print out and ready for sorting
     */
    class Node implements Serializable{
        Ingredient ingredient;
        Node next;
        Node(Ingredient ingredient) {
            this.ingredient = ingredient;
            this.next = null;
        }
    }
    // make public for GUI
    public int size;

    /**
     * for persistent
     * @return
     */
    public HashTable<Ingredient> getIngredientHashTable() {
        return ingredientHashTable;
    }

    /**
     * for persistent
     * @param ingredientHashTable
     */

    public void setIngredientHashTable(HashTable<Ingredient> ingredientHashTable) {
        this.ingredientHashTable = ingredientHashTable;
    }

    public HashTable<Ingredient> ingredientHashTable;

    /**
     *
     * @param size
     */
    public IngredientsController(int size) {
        this.size = size;
        this.ingredientHashTable = new HashTable<>(size);
    }

    /**
     * add ingredient by this method
     * @param name
     * @param textualDes
     * @param calorie
     * @return
     */
    public boolean addIngredient(String name, String textualDes, double calorie) {

        if (name == null || textualDes == null || calorie < 0) {
            System.out.println("add fault");
            return false;
        }
        Ingredient ingredient = new Ingredient(name, textualDes, calorie);
        ingredientHashTable.add(ingredient);
        return true;
    }

    /**
     * a display method
     * @return
     */
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


    /**
     * delete ingredient by this way
     * @param ingredient
     * @return
     */
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

    /**
     * search by name
     * @param ingredientName
     * @return
     */
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

    /**
     * search by calorie
     * @param calorie
     * @return
     */
    public Ingredient[] searchByCalorie(double calorie) {
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

    /**
     * Alphabetical sorting can be implemented if the user needs to click a button after searching by calorie
     * @param ingredients
     * @return
     */
    public Ingredient[] SortByLetter(Ingredient[] ingredients) {
        if (ingredients == null || ingredients.length == 0) {
            System.out.println("Have no ingredients to sort.");
            return ingredients;  // Return the original array if it's empty or null
        }

        quickSortByLetter(ingredients, 0, ingredients.length - 1);

        // Return the sorted array of ingredients
        return ingredients;
    }

    /**
     * update in this way
     * @param ingredient
     * @return
     */
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

    /**
     * ues quick sort to sort by letter
     * @param ingredients
     * @param left
     * @param right
     */
    private void quickSortByLetter(Ingredient[] ingredients, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(ingredients, left, right);
            quickSortByLetter(ingredients, left, pivotIndex - 1);
            quickSortByLetter(ingredients, pivotIndex + 1, right);
        }
    }

    private int partition(Ingredient[] ingredients, int left, int right) {
        Ingredient pivot = ingredients[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            //JAVA Function
            if (ingredients[j].getName().compareToIgnoreCase(pivot.getName()) <= 0) {
                i++;
                // change
                Ingredient temp = ingredients[i];
                ingredients[i] = ingredients[j];
                ingredients[j] = temp;
            }
        }
        swap(ingredients,i+1,right);


        return i + 1;
    }

    /**
     * a sample method to swap
     * @param ingredients
     * @param i
     * @param j
     */
    private void swap(Ingredient[] ingredients,int i, int j){
        Ingredient temp = ingredients[i];
        ingredients[i] = ingredients[j];
        ingredients[j] = temp;
    }

/**
 * The process of testing the feasibility of a method
 */
//    public static void main(String[] args) {
//        IngredientsController ingredientsController = new IngredientsController(50);
//        ingredientsController.addIngredient("香菜","好吃",12.6);
//        System.out.println(ingredientsController.displayIngredient());
//        ingredientsController.searchByName("香菜");
//
//        System.out.println(ingredientsController.displayIngredient());
//    }

}