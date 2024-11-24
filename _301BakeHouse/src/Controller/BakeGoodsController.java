package Controller;
import model.BakeGoods;
import model.HashTable;

public class BakeGoodsController {


    HashTable<BakeGoods> BakeGoodsTable;
    int size;

    public BakeGoodsController(int size) {
        this.size = size;
        this.BakeGoodsTable = new HashTable<>(size);

    }
    public boolean addGoods(BakeGoods bakeGoods){
        if (bakeGoods == null){
            System.out.println("Error!");
            return false;
        }
        BakeGoodsTable.add(bakeGoods);
        System.out.println("Good have added!");
        return true;
    }

    public boolean deleteGoods(BakeGoods bakeGoods){
        return BakeGoodsTable.delete(bakeGoods);
    }

    public void displayGoods(){
        BakeGoodsTable.displayHashTable();
    }
    public BakeGoods[] searchByName(String bakeGoodsname) {
        BakeGoods[] goods = new BakeGoods[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            BakeGoods item = BakeGoodsTable.get(i);

            if (item != null && item.getName().equals(bakeGoodsname)) {
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



    public BakeGoods[] searchByCountry(String bakeGoodscountry){
        BakeGoods[] goods = new BakeGoods[size];
        int count = 0;
        for (int i = 0 ;i < size;i++){
            BakeGoods item = BakeGoodsTable.get(i);
            if (item != null && item.getOriginCountry().equals(bakeGoodscountry)) {
                System.out.println("search successfully");
                System.out.println(item.toString());
                goods[count] = item;
                count++;
            }
        }
       return goods;
    }
    public BakeGoods[] Sortgoods(BakeGoods[]goods){
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
    public String updateGoods(String Goodsname,BakeGoods newgoods){
        for (int i = 0 ;i < size;i++){
            BakeGoods item = BakeGoodsTable.get(i);
            if (item != null && item.getName().equals(Goodsname)) {
                item.setOriginCountry(newgoods.getOriginCountry());
                item.setTextualDES(newgoods.getTextualDES());
                item.setImgURL(newgoods.getImgURL());
                return ("update successfully");
            }
        }
        return ("fail to update");
    }
    //Getters and setters are written for persistence services
    public HashTable<BakeGoods> getBakeGoodsTable() {
        return BakeGoodsTable;
    }

    public void setBakeGoodsTable(HashTable<BakeGoods> bakeGoodsTable) {
        BakeGoodsTable = bakeGoodsTable;
    }

    public static void main(String[] args) {
        BakeGoodsController case1 = new BakeGoodsController(10);
        BakeGoods a = new BakeGoods("a");
        BakeGoods b = new BakeGoods("a");
        case1.addGoods(a);
        case1.addGoods(b);
        case1.searchByName("a");
//        case1.displayGoods();
//        case1.updateGoods("a",new BakeGoods("b","b","b","b"));
//        case1.displayGoods();
//        case1.deleteGoods(a);
//        case1.displayGoods();
//        case1.deleteGoods(a);
//        case1.displayGoods();
    }
}


