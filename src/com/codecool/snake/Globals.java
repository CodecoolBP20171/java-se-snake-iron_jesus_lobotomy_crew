package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static int score;

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;
    public static int health;

    public static Image snakeHead = new Image("nyancat-resize.gif");
    public static Image snakeBody = new Image("nyanrainbow-resize.gif");
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image strongEnemy = new Image("strong_enemy.png");
    public static Image fastEnemy = new Image ("fast_enemy.png");
    public static Image powerupBerry = new Image("powerup_berry.png");
    public static Image ironJesus = new Image("ironjesuspowerup.png");
    public static Image froggy = new Image("retardedfrog.png");
    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static Timer timer;
    public static GameLoop gameLoop;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }

    public static void restartGlobalScore(){
        Globals.score = 0;
    }
}
