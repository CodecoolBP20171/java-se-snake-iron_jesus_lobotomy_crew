package com.codecool.snake;
import java.awt.*;
import java.applet.*;
public class Sound extends Applet {
    public static AudioClip nyan;

    public void init() {
        nyan = getAudioClip(getCodeBase(), "nyan.mp3");
    }

    public void start() {
        if (nyan != null) {
            nyan.loop();
        }
    }

    public void stop() {
        if (nyan != null)
            nyan.stop();
    }
}
