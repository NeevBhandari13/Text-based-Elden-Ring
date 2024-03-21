package game.reset;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brendan Nguyen, Neev Bhandari
 */
public class ResetManager {
    /**
     * List of resettable objects to manage
     */
    private List<Resettable> resettables;

    /**
     * List of resettable runes
     */
    private List<Resettable> runeResettables;

    /**
     * Instance of reset manager
     */
    private static ResetManager instance;

    /**
     * Private Constructor
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
        this.runeResettables = new ArrayList<>();
    }

    /**
     * Static factory method to have only one instance of reset manager.
     * @return the static instance of reset manager.
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Iterates through all resettables and resets them
     * @param map The map the resettables are currently in.
     */
    public void run(GameMap map) {
        for (Resettable resettable : resettables ) {
            resettable.reset(map);
        }
    }

    /**
     * Iterates through all rune resettables and resets them
     * @param map The map the rune resettables are currently in
     */
    public void resetRunes(GameMap map) {
        for (Resettable resettable : runeResettables) {
            resettable.reset(map);
        }
    }

    /**
     * Adds a rune ressettable object to the reset manager list of runes
     * @param resettable The object to add
     */
    public void registerRuneResettable(Resettable resettable) { runeResettables.add(resettable); }

    /**
     * Adds a resettable object to the reset manager list
     * @param resettable The object to add.
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * Removes a resettable object from the reset manager list
     * @param resettable The object to remove from the reset manager.
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }

    /**
     * Gets a resettable actor from the reset manager list
     * @param actor The actor to get from the list.
     * @return the resettable actor.
     */
    public Resettable getResettable(Actor actor) {
        for (Resettable resettable : this.resettables) {
            if (resettable.equals(actor)) return resettable;
        }
        return null;
    }

    /**
     * Gives a copy of the resettables.
     * @return a copy of resettables.
     */
    public ArrayList<Resettable> getResettables() {
        return new ArrayList<>(this.resettables);
    }

}
