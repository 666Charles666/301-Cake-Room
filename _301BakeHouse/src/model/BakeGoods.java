package model;

public class BakeGoods {
    private String name,originCountry,textualDES,imgURL,
                   cakes,breads,biscuits,tarts,pies;
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

    public String getCakes() {
        return cakes;
    }

    public String getBreads() {
        return breads;
    }

    public String getBiscuits() {
        return biscuits;
    }

    public String getTarts() {
        return tarts;
    }

    public String getPies() {
        return pies;
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

    public void setCakes(String cakes) {
        this.cakes = cakes;
    }

    public void setBreads(String breads) {
        this.breads = breads;
    }

    public void setBiscuits(String biscuits) {
        this.biscuits = biscuits;
    }

    public void setTarts(String tarts) {
        this.tarts = tarts;
    }

    public void setPies(String pies) {
        this.pies = pies;
    }
    public String toString() {
        return "Bake goods{name: " + name + ",origin Country is :" + originCountry + ",textualDES is  "+ textualDES ;
    }

}
