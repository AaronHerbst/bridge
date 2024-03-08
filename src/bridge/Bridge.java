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

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.Base64;


/**
 * the bridge between the AI player, and human moderator and the game itself.
 */
public class Bridge extends Application {
    private static String role;
    private static final StringBuilder LOG = new StringBuilder();
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
     * @param roll the role
     * @param stage the stage
     * @throws NoSuchAlgorithmException checked exception
     * @throws KeyManagementException checked exception
     * @throws InterruptedException checked exception
     * @throws IOException checked exception
     */
    public static void boot(String username, String password, String uri, Stage stage, String roll)
            throws NoSuchAlgorithmException, KeyManagementException, IOException,
            InterruptedException {
        url = uri;
        role = roll;

        // Disable SSL certificate check
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, TrustAllManager.getTrustManagers(),
                new java.security.SecureRandom());
        encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        // Create a custom HttpClient with the disabled certificate check
        // only runs once
        client = HttpClient.newBuilder()
                .sslContext(sslContext)
                .build();

        // Make the HTTP request
        // will need to run each time you need to send something to the AI
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .setHeader("Authorization", "Basic " + encoding).build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        if(!response.body().contains("Blah")){
            throw new IOException("failed to connect to server \n"+response.body());
        }
        log(generatePrompt(null, null));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Bridge.class.getResource("bridge.fxml"));

        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();



    }




    /**
     * prompt generation logic. TODO
     * @param actionType either roleAction or voting
     * @param options all valid options
     * @return the prompt
     * @throws UnsupportedOperationException when the role given to
     * the boot method is unsupported.
     */
    public static String generatePrompt(String actionType, ArrayList<String> options){
        if (options==null||actionType==null){
            // initializer prompt
            if (role.equalsIgnoreCase("lookout")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Investigator")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Sheriff")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("spy")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("jailor")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vampire hunter")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("veteran")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vigilante")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("bodyguard")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("doctor")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("escort")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("mayor")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("medium")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("transporter")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("Retributionist")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("disguiser")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("forger")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("framer")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("Hypnotist")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("janitor")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("ambusher")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("godfather")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("mafioso")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("blackmailer")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Consigliere")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("consort")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("amnesiac")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("survivor")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vampire")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Executioner")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("jester")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("witch")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("arsonist")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("serial killer")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("werewolf")) {
                return "placeholder text";
            } else {
                throw new UnsupportedOperationException("role is not supported");
            }
        } else if(actionType.equalsIgnoreCase("voting")){
            return "placeholder text";
        } else{
            if (role.equalsIgnoreCase("lookout")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Investigator")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Sheriff")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("spy")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("jailor")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vampire hunter")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("veteran")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vigilante")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("bodyguard")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("doctor")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("escort")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("mayor")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("medium")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("transporter")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("Retributionist")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("disguiser")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("forger")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("framer")){
                return "placeholder text";
            } else if(role.equalsIgnoreCase("Hypnotist")){
                return "placeholder text";
            } else if (role.equalsIgnoreCase("janitor")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("ambusher")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("godfather")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("mafioso")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("blackmailer")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Consigliere")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("consort")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("amnesiac")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("survivor")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("vampire")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("Executioner")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("jester")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("witch")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("arsonist")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("serial killer")) {
                return "placeholder text";
            } else if (role.equalsIgnoreCase("werewolf")) {
                return "placeholder text";
            } else {
                throw new UnsupportedOperationException("role is not supported");
            }
        }

    }

    /**
     * parses the response from the AI, looking for the entered keyword(s).
     * this method will have to remove punctuation/ uppercase chars as needed.
     * @param response the response from the AI.
     * @param keywords anything the human moderator is looking for.
     * @return the first keyword that appears in the response,
     * or null if no keywords are in the response.
     */
    public static String parseResponse(String response, ArrayList<String> keywords){

        int currentEarliest = response.length()+1;
        int wordIndex = -1;

        for(int i = 0; i < keywords.size(); i++) {

            int firstOccurrence = response.indexOf(keywords.get(i));
            if(firstOccurrence < currentEarliest && firstOccurrence > -1) {

                currentEarliest = firstOccurrence;
                System.out.println(i);
                wordIndex = i;
            }

        }

        if (wordIndex != -1) {
            return keywords.get(wordIndex);
        }
        return null;
    }
    /**
     * generates a pre-written prompt containing the passed in options and sends it to the player.
     * to be used for both roleActions AND voting.
     * this method should call the other ones.
     * @param options the options to be included in the prompt. if null, ignore the return
     * @param actionType the type of action the request was made for
     * @return the selection made by the player
     * @throws IOException checked exceptions
     * @throws InterruptedException checked exceptions
     */
    public static String request(ArrayList<String> options,
                                 String actionType) throws InterruptedException, IOException{
        String prompt = generatePrompt(actionType, options);
        log(prompt);
        for (int i = 0; i < 3; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    //there should be a getLog() call here
                    .uri(URI.create(url+prompt))
                    .setHeader("Authorization", "Basic " + encoding).build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            String savedResponse = response.body();
            if (options == null) {
                return null;
            }
            String out = parseResponse(savedResponse, options);
            if (out != null){
                log(savedResponse);
                return out;
            }
        }


        return null;
    }

    /**
     * logs the responses of the AI. can also be used to log the prompts.
     * @param in the input.
     */
    public static void log(String in){
        LOG.append(in);
        LOG.append("\n");
    }
    public static String getLog(){
        return LOG.toString();
    }



    @Override
    public void start(Stage stage) {
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
