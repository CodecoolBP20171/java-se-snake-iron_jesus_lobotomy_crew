package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.Powerup;
import com.codecool.snake.entities.snakes.SnakeHead;


// a simple powerup that makes the snake grow TODO make other powerups
public class SimplePowerup extends Powerup implements Interactable {

    public SimplePowerup() {
        super(pane);
        setImage(Globals.powerupBerry);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }

    @Override
    public void setScore(){
        Globals.score =Globals.score+ 5;
        System.out.println(Globals.score);
        Enemy.scoreTotal.setText("Score: "+ String.valueOf(Globals.score));
    }

}
