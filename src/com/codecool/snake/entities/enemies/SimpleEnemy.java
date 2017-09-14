package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple enemy TODO make better ones.
public class SimpleEnemy extends Enemy implements Animatable, Interactable {

    private static final int damage = 10;
    private static int speed = 1;

    public SimpleEnemy(Pane pane) {
        super(pane);
        setImage(Globals.simpleEnemy);

    }

    @Override
    public void step() {
        heading = Utils.directionToVector(direction, speed);
        if (isOutOfBounds()) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
        }

        if (enemyX >= 1000 || enemyY >= 700) {
            setX(getX() - this.getImage().getWidth() + heading.getX());
            setY(getY() - this.getImage().getHeight() + heading.getY());
        } else if (enemyX <= 0 || enemyY <= 0) {
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
        return "10 damage";
    }

    @Override
    public void setScore(){
        Globals.score =- 2;
    }
}
