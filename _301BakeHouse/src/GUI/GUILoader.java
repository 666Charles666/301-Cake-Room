package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUILoader extends Application {
    // 在initialize或其他方法中


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("itemAddUpdatePage.fxml"));
        Parent root = loader.load();
        UIController controller = loader.getController();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
