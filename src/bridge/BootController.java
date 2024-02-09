/*
 * Course: CS 1011
 *Fall 2023
 * Roby Velez
 * Cameron Konicek
 * 2/9/2024
 */
package bridge;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * has a single method
 */
public class BootController {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private TextField URL;

    @FXML
    public void boot(ActionEvent e){
        if(!Bridge.boot(user.getText(), pass.getText(), URL.getText(),
                (Stage) ((Button) e.getSource()).getScene().getWindow())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("something went wrong");
            alert.show();
        }

    }


}
