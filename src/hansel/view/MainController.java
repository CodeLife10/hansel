package hansel.view;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable{

    Stage openDirectoryStage;
    private Desktop desktop = Desktop.getDesktop();

    public MenuItem open_directory;

    public void openDirectory() {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        fileChooser.setTitle("Open Directory");

        File file = fileChooser.showOpenDialog(openDirectoryStage);
        if(file != null) {
            openFile(file);
        }
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    FileChooser.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    private static void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp3", "*.mp3")
        );
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
