package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.Random;

public abstract class Enemy extends GameEntity implements Animatable, Interactable {
    private final int damage;
    protected Point2D heading;
    protected static Random rnd = new Random();
    protected double direction;
    protected int speed;

    public Enemy(int damage) {
        this.damage = damage;
        setUpPosition();
    }

    public int getDamage() {
        return damage;
    }

    protected void updateHeading() {
        //Default empty
    }

    protected void setUpPosition() {
        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    protected void actionDisappear() {
       destroy();
    }

    @Override
    public void step() {
        updateHeading();
        if (isOutOfBounds()) {
            actionDisappear();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {
        if (entity instanceof SnakeHead) {
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}
