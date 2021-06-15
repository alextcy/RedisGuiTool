package com.alextcy.redisguitool.ViewModel;

import com.alextcy.redisguitool.Model.ConnectionConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ConnectionConfigListViewCell extends ListCell<ConnectionConfig>
{
    @FXML private Label nameLabel;

    private FXMLLoader loader;

    @FXML private GridPane gridPaneConnectionListCell;

    @Override
    protected void updateItem(ConnectionConfig config, boolean empty)
    {
        super.updateItem(config, empty);

        if(empty || config == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (loader == null) {
                loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ConnectionConfigListViewCell.fxml"));

                loader.setController(this);

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            nameLabel.setText(config.getName());

            setText(null);
            setGraphic(gridPaneConnectionListCell);
        }

    }
}
