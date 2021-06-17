package com.alextcy.redisguitool.Controller;

import com.alextcy.redisguitool.Model.ConnectionConfig;
import com.alextcy.redisguitool.Model.SshTunnelConfig;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author aleksei.tsymbaliuk
 */
public class AddConnectionConfigDialogController implements Initializable
{
    @FXML TextField configName;
    @FXML TextField configHost;
    @FXML TextField configPort;
    @FXML TextField configPassword;
    
    @FXML TextField sshHost;
    @FXML TextField sshUser;
    @FXML TextField sshPassword;
    @FXML TextField sshPort;
    
    @FXML CheckBox sshTunnelCheckbox;
    @FXML VBox sshTunnelBlock;
    
    private Boolean isSSHTunnelEnabled = false;
    
    private ObservableList<ConnectionConfig> connectionConfigObservableList;
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.sshTunnelCheckbox.selectedProperty().set(false);

        this.sshTunnelCheckbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                sshTunnelCheckbox.setSelected(newValue);
                sshTunnelBlock.disableProperty().set(!newValue);
                
                isSSHTunnelEnabled = newValue;
            }
        });
    }
    
    public void setConnectionConfigObservableList(ObservableList<ConnectionConfig> connectionConfigObservableList)
    {
        this.connectionConfigObservableList = connectionConfigObservableList;
    }
    
    //TODO: add form field validation
    @FXML public void onAddConnectionConfig(ActionEvent event) throws IOException
    {
        SshTunnelConfig sshTunnelConfig = null;
        
        String configName = this.configName.getText().trim();
        String configHost = this.configHost.getText().trim();
        int configPort = Integer.valueOf(this.configPort.getText().trim());
        String configPassword = this.configPassword.getText().trim();
        
        var connectionConfig = new ConnectionConfig(
                configName,
                configHost,
                configPort,
                configPassword
        );
        
        if (this.isSSHTunnelEnabled) {
            String sshHost = this.sshHost.getText().trim();
            String sshUser = this.sshUser.getText().trim();
            String sshPassword = this.sshPassword.getText().trim();
            int sshPort = Integer.valueOf(this.sshPort.getText().trim());
            
            sshTunnelConfig = new SshTunnelConfig(sshHost, sshUser, sshPassword, sshPort);
            
            connectionConfig.setSshTunnel(sshTunnelConfig);
        }
        
        this.connectionConfigObservableList.add(connectionConfig);
        
        this.closeDialog(event);
    }
    
    private void closeDialog(ActionEvent event)
    {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        
        stage.close();
    }
    
}
