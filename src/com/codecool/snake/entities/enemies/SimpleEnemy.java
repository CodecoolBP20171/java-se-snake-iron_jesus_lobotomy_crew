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
       enemyStep(this.speed);

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
