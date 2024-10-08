package wansbot.ui;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import wansbot.WansBot;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private WansBot wansBot;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/daUser.png"));
    private Image wansImage = new Image(this.getClass().getResourceAsStream("/images/daWansBot.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the WansBot instance */
    public void setWansBot(WansBot w) {
        wansBot = w;
        dialogContainer.getChildren().addAll(
                DialogBox.getWansBotDialog(wansBot.getResponse("hello"), wansImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = wansBot.getResponse(input);
        DialogBox userBox =  DialogBox.getUserDialog(input, userImage);
        DialogBox botBox = DialogBox.getWansBotDialog(response, wansImage);
        dialogContainer.getChildren().addAll(
                userBox,
                botBox
        );
        if (input.equals("bye")) {
            delay();
        }
        userInput.clear();
    }

    private void delay() {
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        userInput.setDisable(true);
        sendButton.setDisable(true);
        pause.setOnFinished(event -> Platform.exit());
        pause.play();
    }
}