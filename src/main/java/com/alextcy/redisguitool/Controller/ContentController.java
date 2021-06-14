/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alextcy.redisguitool.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author aleksei.tsymbaliuk
 */
public class ContentController implements Initializable
{
    private Stage previousStage;
    
    public ContentController()
    {
        
    }
    
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public void setPreviousStage(Stage stage) {
        this.previousStage = stage;
    }
    
    @FXML protected void backToMainAction() throws IOException
    {
        this.displayMainStage();
    }
    
    private void displayMainStage() throws IOException {
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();

        MainController controller = loader.getController();
        controller.setPreviousStage(stage);

        var scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main");

        this.previousStage.close();
        stage.show();
    }
}
