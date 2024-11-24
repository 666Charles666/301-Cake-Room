package GUI;

import Controller.BakeGoodsController;
import Controller.IngredientsController;
import Controller.RecipesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.BakeGoods;
import model.Ingredient;
import model.Recipes;
import model.RecipesHash;

import java.awt.*;

public class UIController {
    private BakeGoodsController bakeGoods;
    private IngredientsController ingredients;
    private RecipesController recipes;

    @FXML
    private AnchorPane homePagePane;
    @FXML
    private AnchorPane displayALLPane;
        @FXML
        private AnchorPane displayPane;
    @FXML
    private AnchorPane GOODScontrolPane;
    @FXML
    private AnchorPane recipeControlPane;


    @FXML
    private Stage primaryStage;


    @FXML
    private Scene homePage;
    @FXML
    private Scene viewAllPage;
    @FXML
    private Scene itemAddUpdatePage;
    @FXML
    private Scene recepieAddUpdatePage;


    @FXML
    private Button displayAllButton;
    @FXML
    private Button GoodsControl1;
    @FXML
    private Button SAVEButton;
    @FXML
    private Button LOADButton;
    @FXML
    private Button BACKButton;

    //-----------------------------------------
    //PrimaryStage methods & main methods
    //-----------------------------------------
    @FXML
    public void back(ActionEvent event){
        primaryStage.setScene(homePage);
    }
    @FXML
    public void initialize(){
        primaryStage.setScene(homePage);
        initGoodList();
        initIngredients();
        initRecipes();
        initCombo();
    }

    @FXML
    public void displayAll (ActionEvent event){
          primaryStage.setScene(viewAllPage);
          primaryStage.show();
    }
    @FXML
    public void GoodsControl1(ActionEvent event){
        primaryStage.setScene(itemAddUpdatePage);
    }
    @FXML
    public void GoodsControl2(ActionEvent event){
        primaryStage.setScene(recepieAddUpdatePage);
    }
    @FXML
    public void save(ActionEvent event){

    }
    @FXML
    public void load (ActionEvent event){

    }
    //-----------------------------------------
    //viewAllPage methods
    //-----------------------------------------
    @FXML
    private ListView<String> viewGoods;
    @FXML
    private TextArea viewDescription;
    @FXML
    private ImageView showImage;
    ObservableList<String> goodList;
    public void initGoodList(){
        viewGoods.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //line 83 is quoted from kimi ai , 11/22 21:12
        //question: how to add data into a viewList
         goodList = FXCollections.observableArrayList();
        for (int i = 0; i < bakeGoods.size; i++) {
            BakeGoods item = bakeGoods.BakeGoodsTable.get(i);
            goodList.add(item.toString());
        }
        viewGoods.setItems(goodList);

        viewGoods.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount()==1 && viewGoods.getSelectionModel().getSelectedItems()!=null){
                    for (int i = 0; i < bakeGoods.size; i++) {
                        BakeGoods item = bakeGoods.BakeGoodsTable.get(i);
                        if (item.toString().equals(viewGoods.getSelectionModel().getSelectedItem())){
                            viewDescription.clear();
                            viewDescription.appendText(item.getTextualDES());
                            showImage.setImage(null);
                            showImage.setImage(new Image(item.getImgURL()));
                        }
                    }
                }
            }
        });
    }

    @FXML
    private ListView<String> viewIngredients;
    ObservableList<String> inggredientList;

    public void initIngredients(){
        viewIngredients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        inggredientList = FXCollections.observableArrayList();
        for (int i = 0; i < ingredients.size; i++) {
            Ingredient item = ingredients.ingredientHashTable.get(i);
            inggredientList.add(item.toString());
        }
        viewIngredients.setItems(inggredientList);
    }

    @FXML
    private ListView<String> viewRecipes;
    ObservableList<String> recipeList;
    public void initRecipes(){
      viewRecipes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
      recipeList = FXCollections.observableArrayList();
        for (RecipesHash.Object object : recipes.recipesHashTable.getTable()) {
            String goodName = object.getKey();
            String ingredients = object.getValue();
            recipeList.add(goodName+ingredients);
        }
      viewRecipes.setItems(recipeList);
    }

    @FXML
    private Button deleteButton;
    @FXML
    public void delete(ActionEvent event){
        if (!viewGoods.getSelectionModel().getSelectedIndices().isEmpty()){
            int index = viewGoods.getSelectionModel().getSelectedIndex();
            String value = viewGoods.getSelectionModel().getSelectedItem();
            for (int i = 0; i < goodList.size(); i++) {
                if (value.equals(goodList.get(i))){
                    viewGoods.getSelectionModel().getSelectedItems().remove(index);
                    bakeGoods.deleteGoods(bakeGoods.BakeGoodsTable.get(index));
                    goodList.removeAll();
                    for (int j = 0; j < bakeGoods.size; j++) {
                        BakeGoods item = bakeGoods.BakeGoodsTable.get(i);
                        goodList.add(item.toString());
                    }
                }
            }
            viewGoods.setItems(goodList);
        }
        if (!viewIngredients.getSelectionModel().getSelectedIndices().isEmpty()){
            int index = viewIngredients.getSelectionModel().getSelectedIndex();
            String value = viewIngredients.getSelectionModel().getSelectedItem();
            for (int i = 0; i < inggredientList.size(); i++) {
                if (value.equals(inggredientList.get(i))){
                    viewIngredients.getSelectionModel().getSelectedItems().remove(index);
                    ingredients.deleteIngredient(ingredients.ingredientHashTable.get(index));
                    inggredientList.removeAll();
                    for (int j = 0; j < ingredients.size; j++) {
                        Ingredient item = ingredients.ingredientHashTable.get(i);
                        inggredientList.add(item.toString());
                    }
                }
            }
            viewIngredients.setItems(inggredientList);
        }
        if (!viewRecipes.getSelectionModel().getSelectedIndices().isEmpty()){
            int index = viewRecipes.getSelectionModel().getSelectedIndex();
            String value = viewRecipes.getSelectionModel().getSelectedItem();
            for (int i = 0; i < recipeList.size(); i++) {
                if (value.equals(recipeList.get(i))){
                    for (RecipesHash.Object object : recipes.recipesHashTable.getTable()) {
                        String goodName = object.getKey();
                        String ingredients = object.getValue();
                        if ((goodName+ingredients).equals(value)){
                            recipes.delete(goodName);
                            break;
                        }
                    }
                    viewRecipes.getSelectionModel().getSelectedItems().remove(index);
                    recipeList.removeAll();
                    for (RecipesHash.Object object : recipes.recipesHashTable.getTable()) {
                        String goodName = object.getKey();
                        String ingredients = object.getValue();
                        recipeList.add(goodName+ingredients);
                    }
                    viewRecipes.setItems(recipeList);
                }
            }
        }
    }


    @FXML
    private ComboBox<String> sortComboBox;
    public void initCombo(){
        ObservableList<String> comboList = FXCollections.observableArrayList();
        comboList.add(0,"name(ASC)");
        comboList.add(1,"calories");
        sortComboBox.setItems(comboList);


        ObservableList<String> addComboList = FXCollections.observableArrayList();
        comboList.add(0,"BakeGoods");
        comboList.add(1,"Ingredients");
        ADDCombo.setItems(addComboList);

        ObservableList<String> UpdateComboList = FXCollections.observableArrayList();
        comboList.add(0,"BakeGoods");
        comboList.add(1,"Ingredients");
        UpdateCombo.setItems(UpdateComboList);
       //------------------
       //未完
       //------------------

    }

    @FXML
    private TextField searchField;
    @FXML
    private Button SearchButton;

    @FXML
    public void Search(ActionEvent event){
        //-------------
        //未完
        //-------------
    }


    //-------------------------------
    //itemAddUpdatePage
    //-------------------------------
    @FXML
    private TextField GoodName;
    @FXML
    private TextField addURL;
    @FXML
    private TextField GoodCountry;
    @FXML
    private TextField addCalory;
    @FXML
    private TextArea addDES;
    @FXML
    private TextArea ADDresponseArea;
    @FXML
    private Button ADDItemButton;
    @FXML
    private ComboBox<String> ADDCombo;
    @FXML
    public void addItems(ActionEvent event){
        ADDresponseArea.clear();
        String name = GoodName.getText();
        String URL = addURL.getText();
        String DES = addDES.getText();
        String country = GoodCountry.getText();
        double calory = Double.parseDouble(addCalory.getText());
        if (ADDCombo.getSelectionModel().isSelected(0)){
            BakeGoods newGood = new BakeGoods(name,country,DES,URL);
            boolean success = bakeGoods.addGoods(newGood);
            if (success){
                goodList.add(newGood.toString());
                ADDresponseArea.appendText("BakeGood add success");
            }
            else ADDresponseArea.appendText("BakeGood add failed");
        }
        if (ADDCombo.getSelectionModel().isSelected(1)){
            Ingredient newIngredient = new Ingredient(name,DES,calory);
            boolean success = ingredients.addIngredient(name,DES,calory);
            if (success){
                inggredientList.add(newIngredient.toString());
                ADDresponseArea.appendText("Ingredient add success");
            }
            else ADDresponseArea.appendText("Ingredient add failed");
        }
    }

    @FXML
    private ComboBox<String> UpdateCombo;
    @FXML
    private TextField OldName;
    @FXML
    private TextField UpdateName;
    @FXML
    private TextField UpdateCalory;
    @FXML
    private TextField UpdateCountry;
    @FXML
    private TextField UpdateURL;
    @FXML
    private TextArea UpdateDES;
    @FXML
    private TextArea UPDATEresponseArea;
    @FXML
    private Button UPDATEItemButton;

    @FXML
    public void UPDATEitems(ActionEvent event){
        UPDATEresponseArea.clear();
        String oldName = OldName.getText();
        String URL = UpdateURL.getText();
        String DES = UpdateDES.getText();
        String country = UpdateCountry.getText();
        double calory = Double.parseDouble(UpdateCalory.getText());
        if (UpdateCombo.getSelectionModel().isSelected(0)){
            BakeGoods newGood = new BakeGoods(oldName,country,DES,URL);
            BakeGoods oldGood = bakeGoods.searchGoods(oldName);
            boolean success = bakeGoods.updateGoods(oldName,newGood);
            if (success){
                for (int i = 0; i < goodList.size(); i++) {
                    if (goodList.get(i).equals(oldGood.toString())){
                        goodList.set(i,newGood.toString());
                        break;
                    }
                }
                UPDATEresponseArea.appendText("BakeGood update success");
            }
            else UPDATEresponseArea.appendText("BakeGood update failed");
        }
        if (UpdateCombo.getSelectionModel().isSelected(1)){
            Ingredient newIngredient = new Ingredient(oldName,DES,calory);
            Ingredient oldIngredient = ingredients.search(oldName);
            boolean success = ingredients.update(newIngredient);
            if (success){
                for (int i = 0; i < inggredientList.size(); i++) {
                    if (inggredientList.get(i).equals(oldIngredient.toString())){
                        inggredientList.set(i,newIngredient.toString());
                        break;
                    }
                }
                UPDATEresponseArea.appendText("Ingredient update success");
            }
            else UPDATEresponseArea.appendText("Ingredient update failed");
        }
    }

    //-------------------------------
    //recipeAddUpdatePage
    //-------------------------------
    @FXML
    private TextField addRecipeName;
    @FXML
    private TextField addIngredient1;
    @FXML
    private TextField addAmount1;
    @FXML
    private TextField addIngredient2;
    @FXML
    private TextField addAmount2;
    @FXML
    private TextField addIngredient3;
    @FXML
    private TextField addAmount3;
    @FXML
    private TextField addIngredient4;
    @FXML
    private TextField addAmount4;
    @FXML
    private Button ADDRecipe;
    @FXML
    private TextArea ADDResponseArea;

    @FXML
    public void ADDRecipe(ActionEvent event){
        UPDATEresponseArea.clear();
        String name = addRecipeName.getText();
        String in1 = addIngredient1.getText();
        String in2 = addIngredient2.getText();
        String in3 = addIngredient3.getText();
        String in4 = addIngredient4.getText();
        double i1 = Double.parseDouble(addAmount1.getText());
        double i2 = Double.parseDouble(addAmount2.getText());
        double i3 = Double.parseDouble(addAmount3.getText());
        double i4 = Double.parseDouble(addAmount4.getText());
        String ingredients = in1+i1+in2+i2+in3+i3+in4+i4;
        recipes.add(name,ingredients);
        UPDATEresponseArea.appendText("add Success");
    }







}
