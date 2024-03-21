package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Consumable interface for items that can be consumed.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public interface Consumable {
    /**
     * Use method to implement for consumable items.
     * @param actor The actor using the item.
     */
    void use(Actor actor);
}
