    public static Label scoreTotal = new Label();
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
    protected double enemyX = rnd.nextDouble() * Globals.WINDOW_WIDTH;
    protected double enemyY = rnd.nextDouble()* Globals.WINDOW_HEIGHT;


    protected Enemy(Pane pane) {
        super(pane);

        GameEntity.pane.getChildren().add(this);
        int speed = 1;

        startCoordinate();



        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        }

    public void startCoordinate(){
        

        System.out.println(enemyX);

        if (enemyX>495 && enemyX<505){
            setX((rnd.nextDouble() * Globals.WINDOW_WIDTH)+15);

        }else if (enemyY>495 && enemyY<505){
            setY((rnd.nextDouble() * Globals.WINDOW_HEIGHT)+15);
        }else{
            setX((rnd.nextDouble() * Globals.WINDOW_WIDTH));
            setY((rnd.nextDouble() * Globals.WINDOW_HEIGHT));
        }

    }
    public void enemyStep(int speed){
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
    }


