package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;

public class ChasingEnemy extends Enemy{

    public ChasingEnemy(){
        super(10);
        setImage(Globals.getInstance().getImage("EnemyDog"));
        setFullHeading(rnd.nextDouble() * 360, 1);
        setRotate(getDirection());

    }
    @Override
    protected void updateHeading() {
        setDirectionAndHeading(getDirection() + 0.5);
    }

    @Override
    protected void actionDisappear() {
        setUpPosition();
    }
}
