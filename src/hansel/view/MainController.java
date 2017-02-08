package hansel.view;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    Stage openDirectoryStage;

    public MenuItem open_directory;

    public void openDirectory() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Directory");
        fileChooser.showOpenDialog(openDirectoryStage);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
