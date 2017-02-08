package hansel.view;

import java.io.File;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {
    private Label lblArtist;
    private Label lblAlbum;
    private Label lblTrack;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    
    public void displayFile(String name, Long size, String format){
        //lblTrack.setText("hello");
    }
}
