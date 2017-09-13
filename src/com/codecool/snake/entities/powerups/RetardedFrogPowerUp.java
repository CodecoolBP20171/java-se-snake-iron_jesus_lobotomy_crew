package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.Timer;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.Powerup;
import com.codecool.snake.entities.snakes.SnakeHead;

import static com.codecool.snake.Globals.snakeHead;

public class RetardedFrogPowerUp extends Powerup implements Interactable {

    private static boolean isApplied;

    public RetardedFrogPowerUp() {
        super();
        setImage(Globals.froggy);
        isApplied = false;
    }

    @Override
    public void apply(SnakeHead snakeHead) {
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

    public static void setApplied(boolean bool) {
        isApplied = bool;
    }
}
