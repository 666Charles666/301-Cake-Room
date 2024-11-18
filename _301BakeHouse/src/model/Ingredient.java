package model;

import java.util.Objects;

public class Ingredient {
    private String name,textualDes;
    private String flour,eggs,milk,chocolate,sugar,alcoholicSpirits,fruits,nuts;
    private double calorie;


    public Ingredient(String name,String textualDes,double calorie){
        this.name = name;
        this.textualDes = textualDes;
        this.calorie = calorie;
    }
    public String toString() {
        return "Ingredient{name: " + name + ", textualDes:" + textualDes + ", calorie: "+ calorie + "g}";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextualDes() {
        return textualDes;
    }

    public void setTextualDes(String textualDes) {
        this.textualDes = textualDes;
    }


    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour;
    }

    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getAlcoholicSpirits() {
        return alcoholicSpirits;
    }

    public void setAlcoholicSpirits(String alcoholicSpirits) {
        this.alcoholicSpirits = alcoholicSpirits;
    }

    public String getFruits() {
        return fruits;
    }

    public void setFruits(String fruits) {
        this.fruits = fruits;
    }

    public String getNuts() {
        return nuts;
    }

    public void setNuts(String nuts) {
        this.nuts = nuts;
    }


    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }
}
