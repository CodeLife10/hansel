package hansel.view;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.*;

public class MainController implements Initializable{

    Stage openDirectoryStage;
    //private final Desktop desktop = Desktop.getDesktop();

    public MenuItem open_directory;

    public void openDirectory() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        fileChooser.setTitle("Open Directory");

        File file = fileChooser.showOpenDialog(openDirectoryStage);
        if(file != null) {
            //is file an audio file??? check here
            openFile(file);
            autoPlay(file);
        }
    }

    private void openFile(File file) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        String song = file.getName();
        long size = file.getTotalSpace();
        //AudioInputStream in= AudioSystem.getAudioInputStream(file);
        //AudioFormat baseFormat = in.getFormat();
        //String format = baseFormat.toString();
        String format = "mp3";
        LibraryController lC = new LibraryController();
        lC.displayFile(song,size,format);
    }

    public void autoPlay(File file) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

      try {
            //File f = new File("E:\\malayalam good song\\01_ISHTAMANU.MP3");
            File f = file;
            Media hit = new Media(f.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(hit);
            mediaPlayer.play();
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
    private static void configureFileChooser(final FileChooser fileChooser){
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );

        fileChooser.getExtensionFilters().addAll(
                //new FileChooser.ExtensionFilter("mp3", "*.mp3")
        );
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
