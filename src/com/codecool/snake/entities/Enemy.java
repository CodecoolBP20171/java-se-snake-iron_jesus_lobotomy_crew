package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

abstract public class Enemy extends GameEntity{

    protected Point2D heading;
    protected static final int damage = 10;
    protected Random rnd = new Random();
    protected double direction;


    protected Enemy(Pane pane) {
        super(pane);

        GameEntity.pane.getChildren().add(this);
        int speed = 1;

        Random rnd = new Random();
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        }
    }

