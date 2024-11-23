package model;

import java.io.Serializable;
import java.util.List;

public class Recipes implements Serializable {
    String bakeGoods;

    public Recipes(String bakeGoods){
        this.bakeGoods = bakeGoods;
    }

    private int eggCalorie,flourCalorie,milkCalorie,chocolateCalorie,sugarCalorie,wineCalorie,nutsCalorie,fruitCalorie;

    public String getBakeGoods() {
        return bakeGoods;
    }

    public void setBakeGoods(String bakeGoods) {
        this.bakeGoods = bakeGoods;
    }

    public int getMilkCalorie() {
        return milkCalorie;
    }

    public void setMilkCalorie(int milkCalorie) {
        this.milkCalorie = milkCalorie;
    }

    public int getChocolateCalorie() {
        return chocolateCalorie;
    }

    public void setChocolateCalorie(int chocolateCalorie) {
        this.chocolateCalorie = chocolateCalorie;
    }

    public int getSugarCalorie() {
        return sugarCalorie;
    }

    public void setSugarCalorie(int sugarCalorie) {
        this.sugarCalorie = sugarCalorie;
    }

    public int getWineCalorie() {
        return wineCalorie;
    }

    public void setWineCalorie(int wineCalorie) {
        this.wineCalorie = wineCalorie;
    }

    public int getNutsCalorie() {
        return nutsCalorie;
    }

    public void setNutsCalorie(int nutsCalorie) {
        this.nutsCalorie = nutsCalorie;
    }

    public int getFruitCalorie() {
        return fruitCalorie;
    }

    public void setFruitCalorie(int fruitCalorie) {
        this.fruitCalorie = fruitCalorie;
    }

    public int getEggCalorie() {
        return eggCalorie;
    }

    public void setEggCalorie(int eggCalorie) {
        this.eggCalorie = eggCalorie;
    }

    public int getFlourCalorie() {
        return flourCalorie;
    }

    public void setFlourCalorie(int flourCalorie) {
        this.flourCalorie = flourCalorie;
    }
}
