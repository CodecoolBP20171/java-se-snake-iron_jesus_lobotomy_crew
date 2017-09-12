package com.codecool.snake.entities.enemies;

import com.codecool.snake.Game;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

public class FastEnemy extends GameEntity implements Animatable, Interactable {
    private Point2D heading;
    private static final int damage = 5;
    private static Random rnd = new Random();
    private static double direction;
    private static int speed = 4;

    public FastEnemy(Pane pane) {
        super(pane);
        setImage(Globals.fastEnemy);
        setCoordinates();
        pane.getChildren().add(this);
        direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
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
        return "5 damage";
    }
}

