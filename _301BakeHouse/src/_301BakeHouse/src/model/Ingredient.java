package model;

public class Ingredient {
    private String name;
    private String textualDes;

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

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    private String calories;
}
