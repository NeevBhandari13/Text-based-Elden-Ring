package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.RuneManager;

/**
 * Action that represents a player selling an item to trader.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class SellItemAction extends Action {

    /**
     * The item to sell
     */
    private Item item;
    /**
     * The actor to sell to
     */
    private Actor target;
    /**
     * The price of the item
     */
    private int price;

    /**
     * Constructor
     * @param target The actor to trade to
     * @param item The item to sell
     * @param price The price of the item
     */
    public SellItemAction(Actor target, Item item, int price) {
        this.item = item;
        this.target = target;
        this.price = price;
    }

    /**
     * Removes item from inventory and adds runes to actor
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).removeItemFromInventory(this.item);
            RuneManager.getInstance().getPlayer(actor).addRunes(this.price);
            return this.menuDescription(actor);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells the " + this.item + " to " + this.target + " for " + this.price;
    }
}
