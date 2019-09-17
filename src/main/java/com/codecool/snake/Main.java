package com.codecool.snake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        Scene mainScene = new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        game.start();

        Button button = new Button("Restart");
        game.getChildren().add(button);
        button.setOnAction(this);
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Exiting..");
    }

    @Override
    public void handle(ActionEvent event) {
        Globals.getInstance().stopGame();
        Globals.getInstance().display.clear();
        Globals.getInstance().game.init();
        Globals.getInstance().game.start();

        Button button = new Button("Restart");
        Globals.getInstance().game.getChildren().add(button);
        button.setOnAction(this);
    }
}
