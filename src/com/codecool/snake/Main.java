package com.codecool.snake;

import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.application.Application;

import javafx.beans.property.IntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static com.codecool.snake.Globals.health;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));

        game.getChildren().add(SnakeHead.healthTotal);
        game.getChildren().add(Enemy.scoreTotal);

        // Restart button
        /*Button restart = new Button();
        restart.setText("Restart");
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                restart(primaryStage);

            }
        });
        game.getChildren().add(restart);*/

        primaryStage.show();
        game.start();
    }

    public void cleanup(){
        Globals.restartGlobalScore();
        Globals.newGameObjects.removeAll(Globals.newGameObjects);
        Globals.oldGameObjects.removeAll(Globals.oldGameObjects);
        Globals.gameObjects.removeAll(Globals.gameObjects);
        Globals.gameLoop.stop();
    }

    public void restart(Stage stage){
        cleanup();
        start(stage);
    }



}
