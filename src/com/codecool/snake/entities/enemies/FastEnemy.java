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
    private  int speed = 4;



    public FastEnemy(Pane pane) {
        super(pane);

        setImage(Globals.fastEnemy);
    }

    @Override
    public void step() {
        enemyStep(this.speed);
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
        Globals.score =Globals.score - 2;
        scoreTotal.setText("Score: " + String.valueOf(Globals.score));
    }

    @Override
    public void addNewEntity() {
        Globals.newGameObjects.add(this);
    }
}