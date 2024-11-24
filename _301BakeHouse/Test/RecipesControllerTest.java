import static org.junit.jupiter.api.Assertions.*;
import Controller.IngredientsController;
import Controller.RecipesController;
import model.BakeGoods;
import model.Ingredient;
import model.Recipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
public class RecipesControllerTest {
    RecipesController recipesController;
    @BeforeEach

    public void setUp(){
        recipesController = new RecipesController(10);

    }

    @Test

    public void addTest(){
        String output1 = recipesController.add("cake","egg,20g");
        String output2 = recipesController.add("pizza","lolo,1T");
        assertEquals("add successfully!",output1);
        assertEquals("add successfully!",output2);
    }

    @Test

    public void deleteTest(){
        recipesController.add("cake","egg,20g");
        String output = recipesController.delete("cake");
        assertEquals("delete successfully",output);
    }

    @Test

    public void searchByNameTest(){
        recipesController.add("cake","egg,20g");
        String output1 = recipesController.searchByName("cake");
        String output2 = recipesController.searchByName("big cake");
        assertEquals("Search result for cake:egg,20g",output1);
        assertEquals("Can't find the recipe named big cake",output2);

    }

    @Test

    public void updateTest(){
        recipesController.add("cake","egg,20g");
        boolean output1 = recipesController.update("cake","20g");
        boolean output2 = recipesController.update("bigcake","20g");
        assertTrue(output1);
        assertFalse(output2);

    }

}