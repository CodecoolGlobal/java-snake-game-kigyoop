package com.codecool.snake;

import com.codecool.snake.entities.powerups.BoostPowerUP;
import javafx.geometry.Point2D;
import java.lang.Math;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;

import static java.lang.StrictMath.atan;

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
        double StartX = startPosition.getX();
        double StartY = startPosition.getY();

        double EndX = endPosition.getX();
        double EndY = endPosition.getY();

        double VectorX = EndX - StartX;
        double VectorY = EndY - StartY;
        System.out.println(EndX);
        System.out.println(EndY);
        double VectorDivision = VectorY/VectorX;

        double Shortdegree = Math.toDegrees(atan(VectorDivision));


        if (VectorX > 0 || VectorY > 0){ // + +
            return Shortdegree;
        } else if (VectorX < 0 || VectorY > 0){  // - +
            return 180-Shortdegree;
        } else if (VectorX < 0 || VectorY < 0){  // - -
            return 180+Shortdegree;
        } else if (VectorX > 0 || VectorY < 0){  // + -
            return 360-Shortdegree;
        } else if (VectorX == 0 || VectorY>0){   // 0 +
            return 90;
        } else if (VectorX == 0 || VectorY<0){   // 0 -
            return 270;
        } else if (VectorY == 0 || VectorX>0){   // + 0
            return 0;
        } else if (VectorY == 0 || VectorX<0){   // - 0
            return 180;
        }

        return 180;
        /*
        if (Shortdegree >= 30) {
            return -45;
        } else {
            return -45;
        }
        */
    }

}
