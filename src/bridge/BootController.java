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

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * has a single method
 */
public class BootController {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private TextField url;
    @FXML
    private TextField role;


    /**
     * calls the corresponding method in the bridge class
     * @param e gets the stage
     */
    @FXML
    public void boot(ActionEvent e){
        try{
            Bridge.boot(user.getText(), pass.getText(), url.getText(),
                    (Stage) ((Button) e.getSource()).getScene().getWindow(), role.getText());
        } catch (NoSuchAlgorithmException | KeyManagementException |
                 InterruptedException | IOException t){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(t.getMessage());
            alert.show();
        }

    }


}
