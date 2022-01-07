package com.shelbot.utils;

/**
 * Contains some math utils
 * 
 * @author  
 * @version 5/13/20
 */
public class MathUtils {

    /**
     * Used to calc distance between 2 points
     * 
     * @param x1 the x coord of point 1
     * @param y1 the y coord of point 1
     * @param x2 the x coord of point 2
     * @param y2 the y coord of point 2
     * @return the distance between the coordinates
     */
    public static double calcDistance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

}