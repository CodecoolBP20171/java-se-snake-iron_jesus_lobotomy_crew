package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.snakes.SnakeBody;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

// The base class for every game entity.
public abstract class GameEntity extends ImageView {

    protected Pane pane;
    protected Random rnd = new Random();

    protected GameEntity(Pane pane) {
        this.pane = pane;
        // add to the main loop.
        Globals.addGameObject(this);
    }

    public void destroy() {
        if (getParent() != null) {
            pane.getChildren().remove(this);
        }
        Globals.removeGameObject(this);
    }

    public void setCoordinates() {
        for (GameEntity entity : Globals.getGameObjects()) {
            while (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof SnakeBody || entity instanceof SnakeHead) {
                    setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
                    setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
                }
            }
        }
    }

    protected boolean isOutOfBounds() {
        if (getX() >= Globals.WINDOW_WIDTH - 1|| getX() <= 0 ||
            getY() >= Globals.WINDOW_HEIGHT - 1|| getY() <= 0) {
            return true;
        }
        return false;
    }
}
