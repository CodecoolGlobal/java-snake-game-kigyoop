package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.powerups.BoostPowerUP;
import com.codecool.snake.entities.powerups.LifePowerUp;

import javafx.geometry.Point2D;


public class SnakeHead extends GameEntity implements Interactable {
    private float turnRate = 3;
    private Snake snake;
    public int numOfParts = 3;

    public SnakeHead(Snake snake, Point2D position) {
        this.snake = snake;
        setImage(Globals.getInstance().getImage("SnakeHead"));
        setPosition(position);
    }

    public void updateRotation(SnakeControl turnDirection, float speed) {
        double headRotation = getRotate();

        if (turnDirection.equals(SnakeControl.TURN_LEFT)) {
            headRotation = headRotation - turnRate;
        }
        if (turnDirection.equals(SnakeControl.TURN_RIGHT)) {
            headRotation = headRotation + turnRate;
        }

        // set rotation and position
        setRotate(headRotation);
        Point2D heading = Utils.directionToVector(headRotation, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {

        new SimplePowerUp();
        new SimpleEnemy();
        //new BoostPowerUP();
        //new LifePowerUp();

        if(entity instanceof Enemy) {
            System.out.println(getMessage());
            snake.changeHealth(((Enemy) entity).getDamage());
            snake.speed -= 0.2;
        }
        if(entity instanceof SimplePowerUp){
            System.out.println(getMessage());
            snake.addPart(numOfParts);
            snake.speed += 0.2;
        }
        if(entity instanceof BoostPowerUP){
            System.out.println(getMessage());
            snake.speed += 0.4;
            turnRate += 1;
        }
        if(entity instanceof LifePowerUp){
            System.out.println(getMessage());
            snake.speed += 0.4;
            turnRate += 1;
        }
    }

    @Override
    public String getMessage() {
        return "IMMA SNAEK HED! SPITTIN' MAH WENOM! SPITJU-SPITJU!";
    }
}
