package com.codecool.snake;

import com.codecool.snake.entities.enemies.FastEnemy;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.enemies.StrongEnemy;
import com.codecool.snake.entities.powerups.IronJesusPowerUp;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 500, 500);
        
        new SimpleEnemy();
        new SimpleEnemy();
        new SimpleEnemy();
        new SimpleEnemy();

        new StrongEnemy();
        new StrongEnemy();
        new StrongEnemy();
        new StrongEnemy();
        new StrongEnemy();
        new StrongEnemy();

        new FastEnemy();
        new FastEnemy();
        new FastEnemy();
        new FastEnemy();

        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);

        new IronJesusPowerUp(this);
        new IronJesusPowerUp(this);
        new IronJesusPowerUp(this);
        new IronJesusPowerUp(this);
    }

    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
            }
        });
        Globals.timer = new Timer();
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }
}
