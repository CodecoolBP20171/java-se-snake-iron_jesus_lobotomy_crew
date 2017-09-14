package com.codecool.snake;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Sound {

    static String file;
    static Media sound;
    public static MediaPlayer player;

    public Sound(String file) {
        this.file = file;
        this.sound = new Media(new File(file).toURI().toString());
        this.player = new MediaPlayer(sound);
    }

    public  static void play(){
        player.play();
    }

    public  static void stop(){
        player.stop();

    }

    public void setVolume(double value){
        player.setVolume(value);
    }

    public double getVolume(){
        return player.getVolume();
    }
}

