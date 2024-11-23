import static org.junit.jupiter.api.Assertions.*;
import Controller.IngredientsController;
import model.BakeGoods;
import model.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
public class IngredientsControllerTest {
    IngredientsController ingredientsController;
    Ingredient egg;
    Ingredient butter;
    @BeforeEach
    public void setUp(){
        ingredientsController = new IngredientsController(10);
        egg = new Ingredient("egg","smooth",20);
        butter = new Ingredient("butter","slice",200);
    }
    @Test
    public void addIngreTest(){
        boolean output1 = ingredientsController.addIngredient("egg","smooth",20);
        boolean output2 = ingredientsController.addIngredient("egg","smooth",-20);
        assertTrue(output1);
        assertFalse(output2);
    }
    @Test
    public void deleteIngreTest(){
        ingredientsController.addIngredient("egg","smooth",20);
        boolean output1 = ingredientsController.deleteIngredient("egg");
        boolean output2 = ingredientsController.deleteIngredient("egg");
        assertTrue(output1);
        assertFalse(output2);

    }
}
