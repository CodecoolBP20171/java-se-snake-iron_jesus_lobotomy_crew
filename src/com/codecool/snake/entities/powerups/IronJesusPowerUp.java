package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.Powerup;
import com.codecool.snake.entities.snakes.SnakeHead;


public class IronJesusPowerUp extends Powerup implements Interactable{

    public IronJesusPowerUp() {
        super(pane);
        setImage(Globals.ironJesus);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.changeHealth(42);
        destroy();
    }

    @Override
    public String getMessage() {
            return "42 HP";
        }

    @Override
    public void setScore() {
        Globals.score =Globals.score+ 10;
        System.out.println(Globals.score);
        Enemy.scoreTotal.setText("Score: "+ String.valueOf(Globals.score));
    }
}