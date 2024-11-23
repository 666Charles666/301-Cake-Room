package Controller;

import model.*;

import java.io.*;

public class Persistence {

    private static final String FILE_NAME = "system_data.ser"; // 存储数据的文件

    // 保存系统状态到文件
    public static void saveSystemState(RecipesController recipesController, BakeGoodsController bakeGoodsController,IngredientsController ingredientsController) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // 保存 RecipesHash 表（食谱哈希表）
            out.writeObject(recipesController.recipesHashTable);
            // 保存 BakeGoodsController 的状态（即 BakeGoods 数据）
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
            // 加载 RecipesHash 表
            RecipesHash loadedRecipesHash = (RecipesHash) in.readObject();
            // 加载 BakeGoodsController 的数据
            HashTable loadedBakeGoodsTable = (HashTable) in.readObject();
            HashTable loadedIngredientTable = (HashTable) in.readObject();
            // 将加载的状态赋值给传入的对象
            recipesController.setRecipesHashTable(loadedRecipesHash); // 假设你有一个 setRecipesHash 方法来更新 hash 表
            bakeGoodsController.setBakeGoodsTable(loadedBakeGoodsTable); // 同样，假设你有类似的 setter
            ingredientsController.setIngredientHashTable(loadedIngredientTable);

            System.out.println("系统数据已加载");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("加载系统数据时出错：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 创建测试数据
        RecipesController recipesController = new RecipesController(50);
        BakeGoodsController bakeGoodsController = new BakeGoodsController(10);
        IngredientsController ingredientsController = new IngredientsController(20);

        // 添加一些数据（这部分可以根据你实际的数据结构来添加）
        recipesController.add();  // 假设你已经在RecipesController类中定义了add方法
        bakeGoodsController.addGoods(new BakeGoods("Cake"));
        ingredientsController.addIngredient("Flour", "A type of flour", 100.0);

        // 保存系统状态
        saveSystemState(recipesController, bakeGoodsController, ingredientsController);

        // 创建新对象来测试加载功能
        RecipesController newRecipesController = new RecipesController(50);
        BakeGoodsController newBakeGoodsController = new BakeGoodsController(10);
        IngredientsController newIngredientsController = new IngredientsController(20);

        // 加载系统状态
        loadSystemState(newRecipesController, newBakeGoodsController, newIngredientsController);

        // 验证数据是否加载成功
        System.out.println(newRecipesController.display());  // 打印加载后的数据
        newBakeGoodsController.displayGoods();  // 打印加载后的 BakeGoods 数据
        System.out.println(newIngredientsController.displayIngredient());  // 打印加载后的 Ingredient 数据
    }

}
