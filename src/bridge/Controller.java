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
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * the controller for the actual program
 */

public class Controller {
    @FXML
    private TextField chat;
    @FXML
    private TextField options;
    @FXML
    private TextField act;
    @FXML
    private void request(){
        Scanner s = new Scanner(options.getText());
        ArrayList<String> in = new ArrayList<>();
        while (s.hasNext()){
            in.add(s.next());
        }
        try {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(Bridge.request(in, act.getText()));
            a.show();
        } catch (IOException | InterruptedException t){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(t.getMessage());
            a.show();
        }

    }
    @FXML
    private void logChat(){
        Bridge.log(chat.getText());
    }
    @FXML
    private void getLog(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(Bridge.getLog());
        a.show();
    }





}
