package Controller;

import model.BakeGoods;
import model.HashTable;

import java.util.List;

public class BakeGoodsController {
    HashTable<BakeGoods> BakeGoodsTable;
    int size;;

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
    if(bakeGoods == null){
        System.out.println("Error!");
        return false;
    }
    BakeGoodsTable.delete(bakeGoods);
    System.out.println("Good have deleted");
    return true;
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
}
