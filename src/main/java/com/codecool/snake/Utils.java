package com.codecool.snake;

import com.codecool.snake.entities.powerups.BoostPowerUP;
import javafx.geometry.Point2D;

import java.util.Random;
import java.util.function.ToDoubleBiFunction;

public class Utils {

    /*
    Converts a direction in degrees (0...360) to x and y coordinates.
    The length of this vector is the second parameter
    */
    public static Point2D directionToVector(double directionInDegrees, double length) {
        double directionInRadians = directionInDegrees / 180 * Math.PI;
        Point2D heading = new Point2D(length * Math.sin(directionInRadians), - length * Math.cos(directionInRadians));
        return heading;
    }

    public void randomChance(int chance){
        if (new Random().nextInt(chance) == 0) {
            new BoostPowerUP();
        }
    }

    public static double vectorToDirection(Point2D startPosition, Point2D endPosition) {
        //TODO
        return 0;
    }
}
