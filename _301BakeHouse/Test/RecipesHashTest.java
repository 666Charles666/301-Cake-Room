import static org.junit.jupiter.api.Assertions.*;
import Controller.IngredientsController;
import Controller.RecipesController;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
public class RecipesHashTest {
    RecipesHash recipesHash1;
    RecipesHash recipesHash2;
    @BeforeEach
    public void setUp() {
        recipesHash1 = new RecipesHash(10);
        recipesHash2 = new RecipesHash(10);
    }

    @Test
    public void addTest() {
        recipesHash1.add("recipe1", "asd");
        recipesHash1.add("recipe1", "wds");
        assertEquals("wds", recipesHash1.get("recipe1"));
        assertEquals("wds", recipesHash1.get("recipe1"));
        assertEquals("wds", recipesHash1.get("recipe1"));
    }


    @Test
    public void deleteTest() {
        recipesHash1.add("recipe1", "asd");
        recipesHash1.delete("recipe1");
        assertNull(recipesHash1.get("recipe1"));
        recipesHash1.delete("recipe3");
        assertNull(recipesHash1.get("recipe3"));
    }

}
