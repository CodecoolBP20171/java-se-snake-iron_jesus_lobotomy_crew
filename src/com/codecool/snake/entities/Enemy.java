package com.codecool.snake.entities;

import com.codecool.snake.Utils;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Random;

abstract public class Enemy extends GameEntity {

    protected static Pane pane = GameEntity.pane;
    protected static double direction;
    protected Point2D heading;
    protected static Random rnd = new Random();
    protected static int speed;
    protected static int damage;
    public static Label scoreTotal = new Label();

    public Enemy() {
        super(pane);
        setCoordinates();
        pane.getChildren().add(this);
        direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }



}
