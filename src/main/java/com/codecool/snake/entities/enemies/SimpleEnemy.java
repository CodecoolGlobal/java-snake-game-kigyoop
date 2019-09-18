package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import java.util.Random;

import javafx.geometry.Point2D;



public class SimpleEnemy extends Enemy implements Animatable, Interactable {

    public SimpleEnemy() {
        super(10);

        setImage(Globals.getInstance().getImage("EnemyScooter"));

        this.direction = rnd.nextDouble() * 360;
        setRotate(direction);

        this.speed = 1;
        this.heading = Utils.directionToVector(direction, speed);
    }



    @Override
    protected void actionDisappear() {
        direction = (direction + 180) % 360;
        heading = Utils.directionToVector(direction, speed);
    }
}
