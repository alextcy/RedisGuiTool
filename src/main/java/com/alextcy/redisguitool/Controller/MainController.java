package com.alextcy.redisguitool.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author aleksei.tsymbaliuk
 */
public class MainController implements Initializable
{
    @FXML private Button connectButton;
    
    private Stage previousStage;
    
    public MainController()
    {
        
    }
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }
    
    @FXML protected void onConnectAction(ActionEvent event) throws IOException {
        connectButton.setText("Clicked");
        
        this.displayContentStage();
    }
    
    public void setPreviousStage(Stage stage)
    {
        this.previousStage = stage;
    }
    
    private void displayContentStage() throws IOException 
    {
        Stage stage = new Stage();
        
     
        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Content.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Content.fxml"));
        Parent root = loader.load();

        ContentController controller = loader.getController();
        controller.setPreviousStage(stage);

        var scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Content");
        
        this.previousStage.close();
        stage.show();
    }
}
