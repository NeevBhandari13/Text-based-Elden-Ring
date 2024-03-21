package game.runes;


/**
 * Rune Dropper interface for actors that can drop runes.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public interface RuneDropper {

    /**
     * gets rune dropper lower bound for rune award amount
     * @return int of lower bound amount
     */
    int getRuneLowerBound();
    /**
     * gets rune dropper upper bound for rune award amount
     * @return int of upper bound amount
     */
    int getRuneUpperBound();

    /**
     * default method that adds rune dropper object to rune manager.
     */
    default void addToRuneManager() {
        RuneManager.getInstance().addRuneDropper(this);
    }

}
