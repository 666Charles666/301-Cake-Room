package model;

public class BakeGoods {
    private String name,originCountry,textualDES,imgURL;
    private double BakeGoodsCalories;
    public BakeGoods(String name,String originCountry,String textualDES,String imgURL){
        this.name = name;
        this.originCountry = originCountry;
        this.textualDES = textualDES;
        this.imgURL = imgURL;
    }



    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getTextualDES() {
        return textualDES;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setTextualDES(String textualDES) {
        this.textualDES = textualDES;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String toString() {
        return "Bake goods name: " + name + ",origin Country  :" + originCountry ;
    }

}