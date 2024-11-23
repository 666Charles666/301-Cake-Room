package Controller;

import model.*;

import java.io.*;

public class Persistence {

    private static final String FILE_NAME = "system_data.ser";

    // 保存系统状态到文件
    public static void saveSystemState(RecipesController recipesController, BakeGoodsController bakeGoodsController,IngredientsController ingredientsController) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            
            out.writeObject(recipesController.recipesHashTable);
           
            out.writeObject(bakeGoodsController.BakeGoodsTable);
            out.writeObject(ingredientsController.ingredientHashTable);
            System.out.println("系统数据已保存");
        } catch (IOException e) {
            System.err.println("保存系统数据时出错：" + e.getMessage());
        }
    }

    // 从文件加载系统状态
    public static void loadSystemState(RecipesController recipesController, BakeGoodsController bakeGoodsController,IngredientsController ingredientsController) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            
            RecipesHash loadedRecipesHash = (RecipesHash) in.readObject();
            
            HashTable loadedBakeGoodsTable = (HashTable) in.readObject();
            HashTable loadedIngredientTable = (HashTable) in.readObject();
          
            recipesController.setRecipesHashTable(loadedRecipesHash); 
            bakeGoodsController.setBakeGoodsTable(loadedBakeGoodsTable); 
            ingredientsController.setIngredientHashTable(loadedIngredientTable);

            System.out.println("系统数据已加载");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("加载系统数据时出错：" + e.getMessage());
        }
    }
//
//    public static void main(String[] args) {
//        // 创建测试数据
//        RecipesController recipesController = new RecipesController(50);
//        BakeGoodsController bakeGoodsController = new BakeGoodsController(10);
//        IngredientsController ingredientsController = new IngredientsController(20);
//
//        recipesController.add();
//        bakeGoodsController.addGoods(new BakeGoods("Cake"));
//        ingredientsController.addIngredient("Flour", "A type of flour", 100.0);
//
//        // 保存系统状态
//        saveSystemState(recipesController, bakeGoodsController, ingredientsController);
//
//        // 创建新对象来测试加载功能
//        RecipesController newRecipesController = new RecipesController(50);
//        BakeGoodsController newBakeGoodsController = new BakeGoodsController(10);
//        IngredientsController newIngredientsController = new IngredientsController(20);
//
//        // 加载系统状态
//        loadSystemState(newRecipesController, newBakeGoodsController, newIngredientsController);
//
//        // 验证数据是否加载成功
//        System.out.println(newRecipesController.display());  // 打印加载后的数据
//        newBakeGoodsController.displayGoods();  // 打印加载后的 BakeGoods 数据
//        System.out.println(newIngredientsController.displayIngredient());  // 打印加载后的 Ingredient 数据
//    }

}
