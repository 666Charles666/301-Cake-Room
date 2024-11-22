package Controller;
import model.BakeGoods;
import model.HashTable;
import java.util.List;

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
public String searchGoods(String Goodsname) {
    for (int i = 0 ;i < size;i++){
        BakeGoods item = BakeGoodsTable.get(i);
        if (item != null && item.getName().equals(Goodsname)) {
            System.out.println(item.toString());
            return item.toString();
}
    }
    return "Error Output";
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

    public static void main(String[] args) {
        BakeGoodsController case1 = new BakeGoodsController(10);
        BakeGoods a = new BakeGoods("a","a","a","a");
        case1.addGoods(a);
        case1.displayGoods();
        case1.updateGoods("a",new BakeGoods("b","b","b","b"));
        case1.displayGoods();
        case1.searchGoods("a");
        case1.deleteGoods(a);
        case1.displayGoods();
        case1.deleteGoods(a);
        case1.displayGoods();
    }
}






