package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brendan Nguyen, Neev Bhandari
 */
public interface Resettable {

    /**
     * Adds resettable object to reset manager list
     */
    default void addResettable() {
        ResetManager.getInstance().registerResettable(this);
    }

    default void addRuneResettable() { ResetManager.getInstance().registerRuneResettable(this);}

    /**
     * Removes resettable object from reset manager list
     */
    default void removeResettable() {
        ResetManager.getInstance().removeResettable(this);
    }

    /**
     * Method that implements reset on the class
     * @param map The map the resettable object is currently in.
     */
    void reset(GameMap map);

}
