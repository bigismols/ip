package wansbot.ui;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Represents a dialog box consisting of an ImageView to represent the speaker's face
 * and a label containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
        dialog.getStyleClass().add("reply-label");
    }

    public static DialogBox getUserDialog(String text, Image img) {
        DialogBox userBox = new DialogBox(text, img);
        return userBox;
    }

    /**
     * Displays WansBot text bubbles when User inputs a command.
     *
     * @param text WansBot's response.
     * @param img Image representing WansBot.
     * @return DialogBox with image of WansBot and WansBots' response.
     */
    public static DialogBox getWansBotDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        db.flip();
        if (text.startsWith("I'm sorry") || text.startsWith("You need")
        || text.startsWith("You can't") || text.startsWith("I don't")
        || text.startsWith("Your date")) {
            db.editDialog("-fx-border-color: red");
        }

        return db;
    }

    private void editDialog(String edits) {
        dialog.setStyle(edits);
    }
}