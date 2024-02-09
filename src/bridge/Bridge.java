/*
 * Course: stop yelling at me checkstyle
 */
package bridge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.net.ssl.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;

/**
 * the bridge between the AI player, and human moderator and the game itself.
 */
public class Bridge extends Application {
    // this should only be used to store the most recent response.
    private static String response;
    // this will store all the responses
    private static StringBuilder log = new StringBuilder();
    private static String encoding;
    private static String url;
    private static HttpClient client;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * sets up the HTTP client
     * @param username the username
     * @param password the password
     * @param uri the URL
     */
    public static Boolean boot(String username, String password, String uri,Stage stage){
        url = uri;
        try {
            // Disable SSL certificate check
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, TrustAllManager.getTrustManagers(),
                    new java.security.SecureRandom());
            encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

            // Create a custom HttpClient with the disabled certificate check
            client = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();

            // Make the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .setHeader("Authorization", "Basic " + encoding).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());



            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Bridge.class.getResource("bridge.fxml"));
            try {
                Parent root = loader.load();
                stage.setScene(new Scene(root));

                stage.show();

            } catch (IOException e){
                System.err.println(" I am broken");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }




    /**
     * prompt generation logic.
     * @param role the player's role, or VOTING if the player needs to vote
     * @param options all valid options
     * @return the prompt
     */
    public String generatePrompt(String role, ArrayList<Integer> options){
        return null;
    }

    /**
     * parses the response from the AI, looking for the entered keyword(s).
     * this method will have to remove punctuation/ uppercase chars as needed.
     * @param response the response from the AI.
     * @param keywords anything the human moderator is looking for.
     * @return the first keyword that appears in the response,
     * or null if no keywords are in the response.
     */
    public String parseResponse(String response, ArrayList<String> keywords){
        return null;
    }
    /**
     * generates a pre-written prompt containing the passed in options and sends it to the player.
     * to be used for both roleActions AND voting.
     * this method should call the other ones.
     * @param options the options to be included in the prompt
     * @param actionType the type of action the request was made for
     * @return the selection made by the player
     */
    public int request(ArrayList<Integer> options, String actionType){
        return 0;
    }

    /**
     * logs the responses of the AI. can also be used to log the prompts.
     * @param response the response from the AI.
     */
    public void logResponse(String response){
        log.append(response);
        log.append("\n");
    }
    public String getLog(){
        return log.toString();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("boot.fxml"));
        try {
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e){
            System.err.println(" I am broken");
        }
    }
}