package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RuneManager;

/**
 * Sell action for trading purposes.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class SellWeaponAction extends Action {

    /**
     * The weapon to sell
     */
    private WeaponItem weapon;
    /**
     * The actor to sell to
     */
    private Actor target;
    /**
     * The price of the weapon
     */
    private int price;

    /**
     * Constructor
     * @param target The actor to sell to
     * @param weapon The weapon to sell
     * @param price The weapon price
     */
    public SellWeaponAction(Actor target, WeaponItem weapon, int price) {
        this.target = target;
        this.weapon = weapon;
        this.price = price;
    }

    /**
     * Describe the action in a format suitable for displaying in the menu.
     *
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player picks up the rock"
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells the " + this.weapon + " to " + this.target + " for " + this.price;
    }

    /**
     * Removes weapon from inventory and adds runes to actor
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).removeWeaponFromInventory(this.weapon);
            RuneManager.getInstance().getPlayer(actor).addRunes(this.price);
            return this.menuDescription(actor);
        }
        return null;
    }

}
