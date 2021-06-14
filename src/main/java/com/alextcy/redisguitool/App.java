package com.alextcy.redisguitool;

import com.alextcy.redisguitool.Controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.setProperty("prism.lcdtext", "false");
               
        //scene = new Scene(loadFXML("primary"), 640, 480);
        scene = this.initMainScene(primaryStage);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Redis GUI Tool");
        primaryStage.show();
    }

    //static void setRoot(String fxml) throws IOException {
    //    scene.setRoot(loadFXML(fxml));
    //}

    /*private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/

    public static void main(String[] args) {
        launch();
    }

    private Scene initMainScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controller/Main.fxml"));
        Parent root = loader.load();

        MainController controller = loader.getController();
        controller.setPreviousStage(stage);

        return new Scene(root);
    }
}