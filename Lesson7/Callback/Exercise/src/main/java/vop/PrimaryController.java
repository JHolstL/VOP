package vop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) throws URISyntaxException {
        if (event.getSource() == startButton) {
            // Initialize the facade and start it.
            facade = new FacadeWithCallback(this);
            facade.start();
            // handle access to the buttons
            startButton.setDisable(true);
            stopButton.setDisable(false);
        } else {
            // Stop the facade
            facade.interrupt();
            stopButton.setDisable(true);
            startButton.setDisable(false);
        }
    }

    @Override
    public void updateMessage(String message) {
        // This is the implementation of the CallBack. Remember it is called fro a Thread!
        // append the message to the textArea
        synchronized (this){
            textArea.appendText(message);


            if(!facade.isAlive()){
                stopButton.setDisable(true);
                startButton.setDisable(false);
                stopButton.fire();
            }
        }
    }

    @Override
    public void updateImages(File i1, File i2) {
        // change the pictures on the imageViews
        synchronized (this){
            die1view.setImage(new Image(i1.toURI().toString()));
            die2view.setImage(new Image(i2.toURI().toString()));
        }
    }


}