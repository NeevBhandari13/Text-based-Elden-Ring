package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RuneManager;

/**
 * An exchange action to exchange items for weapons from a trader
 * @author Brendan Nguyen, Neev Bhandari
 */
public class ExchangeAction extends Action {

    /**
     * The item to exchange
     */
    private Item item;
    /**
     * The actor to sell to
     */
    private Actor target;

    /**
     * The item to exchange for
     */
    private WeaponItem exchangeItem;

    /**
     * Constructor
     * @param target The actor to exchange with
     * @param item The item to exchange
     * @param exchangeItem The item to receive
     */
    public ExchangeAction(Actor target, Item item, WeaponItem exchangeItem) {
        this.item = item;
        this.target = target;
        this.exchangeItem = exchangeItem;
    }

    /**
     * Removes item from inventory and receives item in exchange.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).removeItemFromInventory(this.item);
            RuneManager.getInstance().getPlayer(actor).addWeaponToInventory(this.exchangeItem);
            return menuDescription(actor);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges the " + this.item + " to " + this.target + " for " + this.exchangeItem;
    }
}
