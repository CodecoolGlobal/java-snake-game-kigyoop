package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

public abstract class Enemy extends GameEntity implements Animatable, Interactable {
    private final int damage;
    protected Point2D heading;

    public Enemy(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}
