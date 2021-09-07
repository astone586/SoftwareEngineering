import java.io.*;
import java.nio.file.Paths;
import java.lang.*;
import javafx.scene.media.*;
import javafx.embed.swing.JFXPanel;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;

/**
 * Launches a music player that does all the things I want it to.  Command-line usage: java BestMusicPlayer
 *
 *
 * @author Kyle Burke <paithanq@gmail.com>
 * @author Alston Stone <ajstone@plymouth.edu>
 * @author Maxwell Schlichte <mtschlichte@plymouth.edu>
 */
public class BestMusicPlayer extends Application {

    public static Label noSongPlaying = new Label("No song currently playing.");
    public static String songName = "Pride of the Wolverines";
    public static String STAGE_TITLE = "The Best Music Player Ever!";


    public static String getSongName() {
        return songName;
    }

    public static Button getButton() {
        return new Button();
    }

    /**
     * Main method to launch the program.
     *
     * @param args  Command-line arguments for the program.  Currently unused.
     */

    public static void main(String[] args) {launch(args);}
    // launch is part of aplication. It sets up the window and we have to override its start method.

    @Override
    public void start(Stage primaryStage){
    //solution from stackoverflow user Sagar Damani at: https://stackoverflow.com/questions/14025718/javafx-toolkit-not-initialized-when-trying-to-play-an-mp3-file-through-mediap

        final JFXPanel fxPanel = new JFXPanel();
        primaryStage.setTitle(this.STAGE_TITLE);
        Button button = getButton();
        button.setText("Play Wolverines Pride (3:42)");
        button.setOnAction(new EventHandler<ActionEvent>() {

        String song = "songs/PrideOfTheWolverines.mp3";
        Media media = new Media(new File(song).toURI().toString());
        // moved the song and media creation outside of the handle override to prevent garbage colector from deleteing the media after the play method
        // solution from stack overflow user Jojo at: https://stackoverflow.com/questions/29870368/javafx-mediaplayer-music-stops-after-10-seconds
        @Override
        public void handle(ActionEvent event) {
        //code to play a song modified from stackoverflow user jasonwaste's answer on https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
            noSongPlaying.setText(BestMusicPlayer.getSongName());
            }

        });


        GridPane paneLayout = new GridPane();
            paneLayout.setAlignment(Pos.CENTER);
            paneLayout.setVgap(10);
            paneLayout.add(button, 0, 0);
            paneLayout.add(noSongPlaying, 0, 1);

        primaryStage.setScene(new Scene(paneLayout, 300, 250));
        primaryStage.show();
        }

} //end of BestMusicPlayer.java
