package com.codecool.snake.entities;

import com.codecool.snake.Globals;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

// The base class for every game entity.
public abstract class GameEntity extends ImageView {

    protected static Pane pane;
    protected static double direction;

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

    protected boolean isOutOfBounds() {
        if (getX() > Globals.WINDOW_WIDTH - this.getImage().getWidth() - 10  || getX() < 0 ||
            getY() > Globals.WINDOW_HEIGHT - this.getImage().getHeight() - 10 || getY() < 0) {
            return true;
        }
        return false;
    }
}
