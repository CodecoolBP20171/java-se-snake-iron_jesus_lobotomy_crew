package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class StrongEnemy  extends Enemy implements Animatable, Interactable {

    private static int speed = 2;
    private double direction;


    public StrongEnemy(Pane pane) {
        super(pane);
        setImage(Globals.snakeBody);
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());


    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        destroy();


    }

    @Override
    public String getMessage() {
        return damage + " damage";
    }

    @Override
    public void setScore() {
        Globals.score =- 2;

    }
}


