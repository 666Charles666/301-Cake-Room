import static org.junit.jupiter.api.Assertions.*;
import Controller.IngredientsController;
import Controller.RecipesController;
import model.BakeGoods;
import model.HashTable;
import model.Ingredient;
import model.Recipes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
public class HashTableTest {

    private HashTable<String> hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new HashTable<>(10);
    }

    @Test
    public void AddTest() {
        int index1 = hashTable.add("ok");
        int index2 = hashTable.add("no");
        assertEquals("ok", hashTable.get(index1));
        assertEquals("no", hashTable.get(index2));
    }
    @Test
    public void DeleteTest() {
        hashTable.add("ok");
        hashTable.add("no");
        boolean result1 = hashTable.delete("ok");
        boolean result2 = hashTable.delete("no");
        boolean result3 = hashTable.delete("coco");
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }

}