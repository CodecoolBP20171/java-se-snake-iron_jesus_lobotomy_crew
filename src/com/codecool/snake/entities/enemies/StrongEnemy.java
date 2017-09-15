package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class StrongEnemy  extends Enemy implements Animatable, Interactable {

    private static int speed = 2;
    private static int damage = 5;

    public StrongEnemy(Pane pane) {
        super(pane);
        setImage(Globals.strongEnemy);
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
        scoreTotal.setText("Score: " + String.valueOf(Globals.score));
        Globals.score =Globals.score- 2;
    }
    }