package com.codecool.snake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
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
