package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


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
        if (getX() >= 960) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
            setX(10 + this.getImage().getWidth()+heading.getX() );
        }
        if (getX() <= 10) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
            setX(960 - this.getImage().getWidth()+ heading.getX());
        }
        if (getY() >= 620) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
            setY(10 + this.getImage().getHeight()+ heading.getY());
        }
        if (getY() <= 10) {
            direction = rnd.nextDouble() * 360;
            heading = Utils.directionToVector(direction, speed);
            setY(620 - this.getImage().getHeight() + heading.getY());

        }else{

            setX(getX() + heading.getX());
            setY(getY() + heading.getY());
        }

    }


    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        player.addPart(-4);
        destroy();
    }

    @Override
    public String getMessage() {
        return damage + " damage";
    }


    @Override
    public void setScore(){
        Globals.score =Globals.score- 2;
        scoreTotal.setText("Score: " + String.valueOf(Globals.score));
    }

}
