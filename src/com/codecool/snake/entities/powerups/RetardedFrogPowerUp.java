package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.Timer;
import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.Powerup;
import com.codecool.snake.entities.snakes.SnakeHead;

import static com.codecool.snake.Globals.snakeHead;

public class RetardedFrogPowerUp extends Powerup implements Interactable {

    private static boolean isApplied;

    public RetardedFrogPowerUp() {
        super(pane);
        setImage(Globals.froggy);
        isApplied = false;
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        snakeHead.addPart(4);
        if  (!isApplied) {
            setApplied(true);
            snakeHead.changeSpeed(2);
            Globals.timer.setCounter(true);
            Globals.timer.setStart(Globals.timer.getActualValue());
            Globals.timer.setLimit(180);
            destroy();
        } else {
            Globals.timer.setLimit(180);
            destroy();
        }
    }

    @Override
    public String getMessage() {
        if (!isApplied) {
            return "Got faster!";
        } else {
            return "You already got this";
        }
    }

    @Override
    public void setScore() {
        Globals.score =Globals.score+ 15;
        System.out.println(Globals.score);
        Enemy.scoreTotal.setText("Score: "+ String.valueOf(Globals.score));
    }

    public static void setApplied(boolean bool) {
        isApplied = bool;
    }
}
