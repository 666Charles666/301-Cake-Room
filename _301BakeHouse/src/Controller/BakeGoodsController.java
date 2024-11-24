package Controller;
import model.BakeGoods;
import model.HashTable;

/**
 * A class that manages baking items and stores related methods
 */
public class BakeGoodsController {


    public HashTable<BakeGoods> BakeGoodsTable;
    public int size;

    public BakeGoodsController(int size) {
        this.size = size;
        this.BakeGoodsTable = new HashTable<>(size);

    }

    /**
     * add bake good
     * @param bakeGoods
     * @return
     */
    public boolean addGoods(BakeGoods bakeGoods){
        if (bakeGoods == null){
            System.out.println("Error!");
            return false;
        }
        BakeGoodsTable.add(bakeGoods);
        System.out.println("Good have added!");
        return true;
    }

    /**
     * delete bake good
     * @param bakeGoods
     * @return
     */
    public boolean deleteGoods(BakeGoods bakeGoods){
        return BakeGoodsTable.delete(bakeGoods);
    }

    /**
     * display method
     */
    public void displayGoods(){
        BakeGoodsTable.displayHashTable();
    }

    /**
     * search bake good by name
     * @param bakeGoodsname
     * @return
     */
    public BakeGoods[] searchByName(String bakeGoodsName) {
        BakeGoods[] goods = new BakeGoods[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            BakeGoods item = BakeGoodsTable.get(i);

            if (item != null && item.getName().equals(bakeGoodsName)) {
                System.out.println("search successfully");
                System.out.println(item.toString());
                goods[count] = item;
                count++;
            }
        }
        for (int i = 1; i < count; i++) {
            BakeGoods key = goods[i];
            int j = i - 1;
            while (j >= 0 && goods[j].getName().compareTo(key.getName()) > 0) {
                goods[j + 1] = goods[j];
                j--;
            }
            goods[j + 1] = key;
        }
        BakeGoods[] sortedGoods = new BakeGoods[count];
        System.arraycopy(goods, 0, sortedGoods, 0, count);
        return sortedGoods;
    }


    /**
     * search bake good by country
     * @param bakeGoodsCountry
     * @return
     */
    public BakeGoods[] searchByCountry(String bakeGoodsCountry){
        BakeGoods[] goods = new BakeGoods[size];
        int count = 0;
        for (int i = 0 ;i < size;i++){
            BakeGoods item = BakeGoodsTable.get(i);
            if (item != null && item.getOriginCountry().equals(bakeGoodsCountry)) {
                System.out.println("search successfully");
                System.out.println(item.toString());
                goods[count] = item;
                count++;
            }
        }
        return goods;
    }

    /**
     * a sort method
     * @param goods
     * @return
     */
    public BakeGoods[] sortGoods(BakeGoods[]goods){
        for (int i = 1; i < goods.length; i++) {
            BakeGoods key = goods[i];
            int j = i - 1;
            while (j >= 0 && goods[j].getName().compareTo(key.getName()) > 0) {
                goods[j + 1] = goods[j];
                j--;
            }
            goods[j + 1] = key;
        }

        return goods;
    }

    /**
     * a update method
     * @param goodsName
     * @param newGoods
     * @return
     */
    public String updateGoods(String goodsName,BakeGoods newGoods){
        for (int i = 0 ;i < size;i++){
            BakeGoods item = BakeGoodsTable.get(i);
            if (item != null && item.getName().equals(goodsName)) {
                item.setOriginCountry(newGoods.getOriginCountry());
                item.setTextualDES(newGoods.getTextualDES());
                item.setImgURL(newGoods.getImgURL());
                return ("update successfully");
            }
        }
        return ("fail to update");
    }

    /**
     * Getters and setters are written for persistence services
     * @return
     */
    public HashTable<BakeGoods> getBakeGoodsTable() {
        return BakeGoodsTable;
    }
    /**
     * Getters and setters are written for persistence services
     * @return
     */
    public void setBakeGoodsTable(HashTable<BakeGoods> bakeGoodsTable) {
        BakeGoodsTable = bakeGoodsTable;
    }
    /**
     * The process of testing the feasibility of a method
     */
//    public static void main(String[] args) {
//        BakeGoodsController case1 = new BakeGoodsController(10);
//        BakeGoods a = new BakeGoods("a");
//        BakeGoods b = new BakeGoods("a");
//        case1.addGoods(a);
//        case1.addGoods(b);
//        case1.searchByName("a");
////        case1.displayGoods();
////        case1.updateGoods("a",new BakeGoods("b","b","b","b"));
////        case1.displayGoods();
////        case1.deleteGoods(a);
////        case1.displayGoods();
////        case1.deleteGoods(a);
////        case1.displayGoods();
//    }
}

