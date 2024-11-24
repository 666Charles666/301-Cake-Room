import static org.junit.jupiter.api.Assertions.*;

import Controller.BakeGoodsController;
import model.BakeGoods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
class BakeGoodsControllerTest {
    BakeGoodsController bakeGoodsController;

    BakeGoods Burger;
    BakeGoods Pizza;
    BakeGoods Cake;


    @BeforeEach
    public void setUp(){
        bakeGoodsController = new BakeGoodsController(10);
        Cake = new BakeGoods("cake","US","smooth","www.ok.com");
        Burger = new BakeGoods("Burger","CN","spicy","www.no.com");
        Pizza = new BakeGoods("Pizza","UK","Sweet","www.morol.com");
    }
    @Test
    public void addGoodsTest(){
        boolean output1 = bakeGoodsController.addGoods(Cake);
        boolean output2 = bakeGoodsController.addGoods(Cake);
        assertTrue(output1);
        assertTrue(output2);
    }
    @Test
    public void deleteGoodsTest(){
        bakeGoodsController.addGoods(Cake);
        boolean output1 = bakeGoodsController.deleteGoods(Cake);
        boolean output2 = bakeGoodsController.deleteGoods(Burger);
        assertTrue(output1);
        assertFalse(output2);
    }
    @Test
    public void searchGoodsByNameTest(){
    bakeGoodsController.addGoods(Cake);
    BakeGoods[] output1 = bakeGoodsController.searchByName("cake");
    BakeGoods[] output2 = bakeGoodsController.searchByName("big cake");
        assertNotNull(output1);
        assertEquals("cake", output1[0].getName());
        assertEquals("US", output1[0].getOriginCountry());
        assertEquals("smooth", output1[0].getTextualDES());
        assertNotNull(output2);
    }
    @Test
    public void searchGoodsByCountryTest() {
        bakeGoodsController.addGoods(Cake);
        BakeGoods[] output1 = bakeGoodsController.searchByCountry("US");
        BakeGoods[] output2 = bakeGoodsController.searchByCountry("big cake");
        assertNotNull(output1);
        assertEquals("cake", output1[0].getName());
        assertEquals("US", output1[0].getOriginCountry());
        assertEquals("smooth", output1[0].getTextualDES());
        assertNotNull(output2);
    }
    @Test
    public void updateGoodsTest(){
        bakeGoodsController.addGoods(Cake);
        String output1 = bakeGoodsController.updateGoods("cake",new BakeGoods("cake","go","go","go"));
        String output2 = bakeGoodsController.updateGoods("big cake",new BakeGoods("cake","go","go","go"));
        assertEquals("update successfully",output1);
        assertEquals("fail to update",output2);
    }


}
