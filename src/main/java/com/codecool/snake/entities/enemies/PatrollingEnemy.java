package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import javafx.scene.image.Image;

public class PatrollingEnemy extends Enemy{

    public PatrollingEnemy(){
        super(10);

        setImage(Globals.getInstance().getImage("EnemyBird"));
        this.direction = rnd.nextDouble() * 360;
        this.speed = 1;
        //setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    protected void updateHeading() {
        direction += 0.5;
        heading = Utils.directionToVector(direction, speed);
    }

    @Override
    protected void actionDisappear() {
       setUpPosition();
    }
}
