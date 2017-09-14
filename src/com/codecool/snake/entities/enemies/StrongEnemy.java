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
    private static int damage = 5;

    public StrongEnemy(Pane pane) {
        super(pane);
        setImage(Globals.strongEnemy);
    }

    @Override
    public void step() {
        heading = Utils.directionToVector(direction, speed);
        if (isOutOfBounds()) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
        }

        if (this.getX() >= Globals.WINDOW_WIDTH || this.getY() >= Globals.WINDOW_HEIGHT) {
            System.out.println("Out of bounds");
            setX(getX() - this.getImage().getWidth() + heading.getX());
            setY(getY() - this.getImage().getHeight() + heading.getY());
        } else if (this.getX() <= 0 || this.getY() <= 0) {
            System.out.println("out of bounds");
            setX(getX() + this.getImage().getWidth() + heading.getX());
            setY(getY() + this.getImage().getHeight() + heading.getY());
        } else {
            setX(getX() + heading.getX());
            setY(getY() + heading.getY());
        }

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


