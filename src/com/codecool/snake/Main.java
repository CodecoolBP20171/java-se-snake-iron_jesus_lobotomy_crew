package com.codecool.snake;

import com.codecool.snake.entities.Enemy;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        System.setProperty("quantum.multithreaded", "false");
        Application.launch(Main.class, args);
    }



    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        Sound sound = new Sound("nyan.mp3");

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));

        BackgroundImage myBI= new BackgroundImage(new Image("nyancat-bg.gif",Globals.WINDOW_WIDTH,Globals.WINDOW_HEIGHT,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        game.setBackground(new Background(myBI));

        SnakeHead.healthTotal.setLayoutX(100);
        Enemy.scoreTotal.setLayoutX(300);
        SnakeHead.healthTotal.setTextFill(Color.WHITE);
        Enemy.scoreTotal.setTextFill(Color.WHITE);
        SnakeHead.healthTotal.setFont(Font.font("Verdana", 20));
        Enemy.scoreTotal.setFont(Font.font("Verdana", 20));

        game.getChildren().add(SnakeHead.healthTotal);
        game.getChildren().add(Enemy.scoreTotal);

        // Restart button
        Button restart = new Button();
        restart.setText("Restart");
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                restart(primaryStage);

            }
        });
        game.getChildren().add(restart);

        primaryStage.show();
        sound.play();
        game.start();
    }

    public void cleanup(){
        Globals.restartGlobalScore();
        Globals.newGameObjects.clear();
        Globals.oldGameObjects.clear();
        Globals.gameObjects.clear();
        Globals.gameLoop.stop();
    }

    public void restart(Stage stage){
        cleanup();
        start(stage);
    }



}
