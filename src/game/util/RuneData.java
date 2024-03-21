package game.util;

/**
 * Use this enum for rune awarding data of each enemy.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public enum RuneData {

    /**
     * Lone wolf rune drop bounds
     */
    LONE_WOLF(55, 1470),
    /**
     * heavy skeletal swordsman rune drop bounds
     */
    HEAVY_SKELETAL_SWORDSMAN(35, 892),
    /**
     * Giant crab rune drop bounds
     */
    GIANT_CRAB(318, 4961),
    /**
     * Giant dog rune drop bounds
     */
    GIANT_DOG(313,1808),
    /**
     * Giant crayfish rune drop bounds
     */
    GIANT_CRAYFISH(500, 2374),
    /**
     * Skeletal bandit rune drop bounds
     */
    SKELETAL_BANDIT(35,892),
    /**
     * Dog rune drop bounds
     */
    DOG(52,1390),
    /**
     * Godrick soldier rune drop bounds
     */
    GODRICK_SOLDIER(38, 70);

    /**
     * Lower bound rune value for enemy
     */
    private final int lowerBound;
    /**
     * Upper bound rune value for enemy
     */
    private final int UpperBound;

    /**
     * Private constructor that assigns enum values
     * @param lowerBound Lower bound rune value for enemy
     * @param UpperBound Upper bound rune value for enemy
     */
    RuneData(int lowerBound, int UpperBound) {
        this.lowerBound = lowerBound;
        this.UpperBound = UpperBound;
    }

    /**
     * Gets the lower bound value of an enum value
     * @return the lower bound rune value
     */
    public int getLowerBound() {
        return this.lowerBound;
    }

    /**
     * Gets the upper bound value of an enum value
     * @return the upper bound rune value
     */
    public int getUpperBound() {
        return this.UpperBound;
    }

}
