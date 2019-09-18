package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeBody;
import javafx.geometry.Point2D;

public class ChasingEnemy extends Enemy{

    public ChasingEnemy(){
        super(10);
        setImage(Globals.getInstance().getImage("EnemyDog"));
        setFullHeading(rnd.nextDouble() * 360, 1);
        setRotate(getDirection());

    }
    @Override
    protected void updateHeading() {
       GameEntity head = Globals.getInstance().game.getSnake().getHead();
        Point2D snakeHeadPosition = head.getPosition();
        Point2D startPosition = this.getPosition();
        double direction = Utils.vectorToDirection(startPosition, snakeHeadPosition);
        setDirectionAndHeading(direction);

    }

    @Override
    protected void actionDisappear() {
        setUpPosition();
    }
}
