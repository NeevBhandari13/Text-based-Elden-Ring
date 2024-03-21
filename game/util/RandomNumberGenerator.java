package game.util;

import java.util.Random;

/**
 * A random number generator.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brendan Nguyen, Neev Bhandari
 *
 */
public class RandomNumberGenerator {
    /**
     * Generates random number between bound and 0. If bound is less than zero, will give 0
     * @param bound The upper bound value
     * @return a random number between 0 and bound
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * Generates a random number between lower and upper bounds.
     * @param lowerBound The lower bound value
     * @param upperBound The upper bound value
     * @return a random number generated between two bounds
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
