package Controller;

import model.*;

import java.io.*;

/**
 *  A class that manages recipe items and stores related methods
 * Interfaces are there to ensure persistence
 */
public class RecipesController implements Serializable {
    int size ;
//    int totalCalorie = 0;

    public RecipesHash getRecipesHashTable() {
        return recipesHashTable;
    }

    /**
     * use for presistent
     * @param recipesHashTable
     */
    public void setRecipesHashTable(RecipesHash recipesHashTable) {
        this.recipesHashTable = recipesHashTable;
    }

    RecipesHash recipesHashTable;
    BakeGoodsController bakeGoodsController = new BakeGoodsController(10);

    public RecipesController(int size){
        this.size = size;
        this.recipesHashTable = new RecipesHash(size);
    }

    /**
     * add method to add recipe
     * @param bakeGood
     * @param ingredient
     * @return
     */
    public String add(String bakeGood , String ingredient){

        for (int i = 0;i<bakeGoodsController.size;i++){
            BakeGoods item = bakeGoodsController.BakeGoodsTable.get(i);
            if (item != null && item.getName().equals(bakeGood)){
                System.out.println("have found this bake good");
            }else {
                bakeGoodsController.addGoods(new BakeGoods(bakeGood));
                System.out.println("have add a new bake good in class BakeGoods");
            }
            break;
        }
//        Recipes recipes = new Recipes(bakeGood);
        String finalIngredient = "";
//        while (true){
//            if (ingredient.equals("finish")){
//                System.out.println("ingredient added successfully");
//                break;
//            }
////            System.out.println("please enter the quantity(e.g. 10ml/10g)");
//
//        }

        recipesHashTable.add(bakeGood,ingredient);
        return "add successfully!";
    }

    /**
     * display method
     * @return
     */
    public String display(){
        return recipesHashTable.display();
    }

    /**
     * a delete method
     * @param bakeGood
     * @return
     */
    public String delete(String bakeGood){
        recipesHashTable.delete(bakeGood);
        return ("delete successfully");
    }

    /**
     * search recipe method by input name
     * @param bakeGood
     * @return
     */
    public String searchByName(String bakeGood){
        String item = recipesHashTable.get(bakeGood);
        if (item == null) {
            return "Can't find the recipe named " + bakeGood;
        }
       if (bakeGood != null && !item.equals("null")){
           return "Search result for " + bakeGood+":"  + recipesHashTable.get(bakeGood);
       } return "Can't find the recipe named " + bakeGood;
    }

    /**
     * search recipe by input ingredient
     * @param ingredient
     * @return
     */
    public String searchByIngredient(String ingredient) {
        String result = "";
        boolean findIngredient = false;

        for (int i = 0; i < recipesHashTable.size; i++) {
            RecipesHash.Object recipe = recipesHashTable.table[i];
            if (recipe != null ) {

                if (recipe.value.contains(ingredient)) {
                    findIngredient = true;
                    result += "Recipe Name: " + recipe.key + "\n";
                    result += "Ingredients: " + recipe.value + "\n";
                    result += "----------------------------------" + "\n";
                }
            }
        }

        if (!findIngredient) {
            return "Sorry,no recipes have found containing this ingredient: " + ingredient + "\n";
        }

        return result;
    }

    /**
     * update method
     * @param bakeGood
     * @param quantity
     * @return
     */
    public boolean update(String bakeGood,String quantity) {
        String existingRecipe = recipesHashTable.get(bakeGood);
        if (existingRecipe == null) {
            System.out.println("Can't find the recipe of this name");
            return false;
        }

        System.out.println("Updating recipe for " + bakeGood);

        recipesHashTable.delete(bakeGood);
        recipesHashTable.add(bakeGood,quantity);
        return true;
    }

    /**
    * The process of testing the feasibility of a method
    */
//    public static void main(String[] args) {
//        RecipesController recipesController = new RecipesController(50);
//        recipesController.add("burger","香菜 23g/l");
//        System.out.println(recipesController.display());
////        System.out.println(recipesController.searchByName("burger"));
////        recipesController.update("burger");
////        System.out.println(recipesController.display());
////        System.out.println(recipesController.searchByIngredient("香菜"));
////
////
//    }
}
