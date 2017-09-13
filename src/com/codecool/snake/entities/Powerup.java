package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;

import java.util.Random;

abstract public class Powerup extends GameEntity {

    protected static Pane pane = GameEntity.pane;
    protected static Random rnd = new Random();

    public Powerup(){
        super(pane);
        pane.getChildren().add(this);
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }
}
