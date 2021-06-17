package com.alextcy.redisguitool.Controller;

import com.alextcy.redisguitool.Model.ConnectionConfig;
import com.alextcy.redisguitool.ViewModel.ConnectionConfigListViewCell;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author aleksei.tsymbaliuk
 */
public class MainController implements Initializable
{
    @FXML private Button connectButton;
    @FXML private ListView<ConnectionConfig> connectionConfigListView;
    
    private ObservableList<ConnectionConfig> connectionConfigObservableList;
    
    private Stage previousStage;
    
    public MainController()
    {
        this.connectionConfigObservableList = FXCollections.observableArrayList();
        this.connectionConfigObservableList.addAll(this.loadConnectionConfgis());
    }
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        connectionConfigListView.setItems(this.connectionConfigObservableList);
        connectionConfigListView.setCellFactory(connectionConfigListView -> new ConnectionConfigListViewCell());
        
        
        this.connectionConfigObservableList.addListener(new ListChangeListener<ConnectionConfig>() {
            @Override
            public void onChanged(Change<? extends ConnectionConfig> c) {
                
                //TODO: move to separate service
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String userDirectory = System.getProperty("user.dir");
                
                try (FileWriter writer = new FileWriter(userDirectory + "/connections.json")) {
                    gson.toJson(connectionConfigObservableList, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    @FXML protected void onConnectAction(ActionEvent event) throws IOException {
        connectButton.setText("Clicked");
        
        this.displayContentStage();
    }
    
    public void setPreviousStage(Stage stage)
    {
        this.previousStage = stage;
    }
    
    @FXML protected void onAddConnectionConfigDialog(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddConnectionConfigDialog.fxml"));
        Parent root = loader.load();
        
        AddConnectionConfigDialogController dialogController = loader.getController();
        dialogController.setConnectionConfigObservableList(this.connectionConfigObservableList);
        
        var stage = new Stage();
        var scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setTitle("Add Connection Config");
        stage.showAndWait();
    }
    
    private void displayContentStage() throws IOException 
    {
        Stage stage = new Stage();
        
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
    
    //TODO: move to separate service class
    private List<ConnectionConfig> loadConnectionConfgis() {
        String userDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<ConnectionConfig> connections = new ArrayList();

        try ( Reader reader = new FileReader(userDirectory + "/connections.json")) {
            Type connectionsType = new TypeToken<ArrayList<ConnectionConfig>>() {
            }.getType();
            connections = gson.fromJson(reader, connectionsType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connections;
    }
}
