package uk.co.anthonygrimes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {


    public static void main(String[] args) {
	    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
        Node playlists = FXMLLoader.load(getClass().getResource("view/Playlists.fxml"));
        root.setLeft(playlists);

        primaryStage.setTitle("Hansel - Music Player");
        primaryStage.setScene(new Scene(root, 990, 660));
        primaryStage.show();
    }
}