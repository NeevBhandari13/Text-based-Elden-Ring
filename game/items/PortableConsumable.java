package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;

/**
 * Abstract class for items that can only be consumed while in inventory.
 * @author Brendan Nguyen, Neev Bhandari
 */
public abstract class PortableConsumable extends Item implements Consumable {

    /**
     * Consume action.
     */
    final Action consumeAction = new ConsumeAction(this);

    /**
     * Constructor
     * @param name Name of the item
     * @param displayChar char to represent item on map
     * @param portable if the item can be picked up and dropped
     */
    public PortableConsumable(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * Makes sure there is no consume option if on ground.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (this.getAllowableActions().contains(consumeAction)) {
            this.removeAction(consumeAction);
        }
    }

    /**
     * Inform a carried Item of the passage of time.
     * Adds consume action if player is holding it.
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (!this.getAllowableActions().contains(consumeAction)) {
            this.addAction(consumeAction);
        }
    }

}
