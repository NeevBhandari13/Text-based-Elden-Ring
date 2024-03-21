package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;

/**
 * Rune item classes that holds the value the player dropped.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class RuneItem extends Item implements Resettable {

    /**
     * The value of the rune item
     */
    private int value;
    /**
     * The location of the rune item
     */
    private Location location;

    /**
     * Constructor
     * @param value The value of the runes
     * @param location The location of the rune items
     */
    public RuneItem(int value, Location location) {
        super("Runes", '$', true);
        this.value = value;
        this.location = location;
        this.addRuneResettable();
    }

    /**
     * Create and return an action to pick this Item up.
     * If this Item is not portable, returns null.
     *
     * @return a new PickUpItemAction if this Item is portable, null otherwise.
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(portable)
            return new PickUpRuneAction(this);
        return null;
    }

    /**
     * Gets the rune item value
     * @return the rune item value
     */
    public int getValue() { return this.value; }

    @Override
    public void reset(GameMap map) {
        this.location.removeItem(this);
    }

}
