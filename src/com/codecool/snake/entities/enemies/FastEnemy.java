package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class FastEnemy extends Enemy implements Animatable, Interactable {

    private static final int damage = 5;
    private static int speed = 4;



    public FastEnemy(Pane pane) {
        super(pane);
        setImage(Globals.fastEnemy);
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
        return damage + " damage";
    }

    @Override
    public void setScore(){
        Globals.score =- 2;
    }
}
/*public class FastEnemy extends Enemy implements Animatable, Interactable {

    private static final int damage = 5;
    private static int speed = 4;

    public FastEnemy() {
        super();
        setImage(Globals.fastEnemy);
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
    public void setScore(){
        Globals.score =- 2;
    }
}
*/
