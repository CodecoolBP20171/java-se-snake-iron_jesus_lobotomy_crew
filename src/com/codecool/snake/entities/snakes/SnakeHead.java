package com.codecool.snake.entities.snakes;

import com.codecool.snake.Sound;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


import static com.codecool.snake.Game.*;

public class SnakeHead extends GameEntity implements Animatable {

    private static float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    public static Label healthTotal = new Label();


    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        Globals.health = 100;
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);


        addPart(4);
    }

    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
            direction = dir;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
            direction = dir;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    interactable.setScore();
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || Globals.health <= 0) {
            System.out.println(Globals.health);
            System.out.println("Game Over");
            System.out.println("ANYÁDAT TE MOCSOK SZAR");

            Globals.gameLoop.stop();
            Sound.nyan.stop();
            showPopup();
        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart;
            newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public int getCurrentHealth(){
        return Globals.health;
    }

    public void changeHealth(int diff) {
        Globals.health += diff;
        healthTotal.setText("Health:" + String.valueOf(Globals.health));


    }

    public void changeSpeed(int multiplier) {
        speed *= multiplier;
    }

    public static void setSpeedToDefault() {
        speed = 2;
    }
}
