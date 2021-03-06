package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.enemies.FastEnemy;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.enemies.StrongEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class Game extends Pane {


    public Game() {
        newGame();
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
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }




    public  void newGame(){

        new SnakeHead(this, 500, 500);

        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);
        new SimpleEnemy(this);

        new StrongEnemy(this);
        new FastEnemy(this);

        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
        new SimplePowerup(this);
    }


    //Show Congratulation popup window when player won
    public static void showPopup(){

        // Creating pop up window
        Stage newStage = new Stage();
        VBox winPopup = new VBox();
        Button exit = new Button();

        // setting button function
        exit.setText("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(1);
            }
        });

        // Adding text
        Text gameOver = new Text("Game Over");
        Text score = new Text ("Your score is "+ Globals.score);
        winPopup.getChildren().add(gameOver);
        winPopup.getChildren().add(score);

        // Setting scene
        Scene stageScene = new Scene(winPopup, 200, 100);
        newStage.setScene(stageScene);

        // Styling


        // Show
        winPopup.getChildren().add(exit);
        newStage.show();
    }


}

