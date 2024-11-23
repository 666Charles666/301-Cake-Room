package Controller;

import model.*;

import java.util.Scanner;

public class RecipesController {
    int size;
    RecipesHash recipesHashTable;
    BakeGoodsController bakeGoodsController = new BakeGoodsController(10);
    public RecipesController(int size){
        this.size = size;
        this.recipesHashTable = new RecipesHash(size);
    }
    public String add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What good's recipes do you want to add?");
        String bakeGood = scanner.nextLine();
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
    public String display(){
        return recipesHashTable.display();
    }
    public String delete(String bakeGood){
        recipesHashTable.delete(bakeGood);
        return ("delete successfully");
    }
    public String search(String bakeGood){
       if ( bakeGood != null ){
           return "Search result for 'burger': " + recipesHashTable.get(bakeGood);
       } return "No recipe found for 'burger'.";
    }
    public void update(String bakeGood){

    }

    public static void main(String[] args) {
        RecipesController recipesController = new RecipesController(50);
        recipesController.add();
        System.out.println(recipesController.display());
        System.out.println(recipesController.search("burger"));
    }
}
