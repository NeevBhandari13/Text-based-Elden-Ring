package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.runes.RuneManager;

/**
 * An Action to trade with another actor.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 *
 */
public class BuyAction extends Action {

    /**
     * Weapon involved in trade
     */
    private WeaponItem weapon;
    /**
     * Actor the player is trading with
     */
    private Actor target;
    /**
     * The price involved in the trade
     */
    private int price;

    /**
     * Constructor
     * @param target The actor to trade with
     * @param weapon The weapon to trade
     * @param price The weapon price
     */
    public BuyAction(Actor target, WeaponItem weapon, int price) {
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
        return actor + " purchases the " + this.weapon + " from " + this.target + " for " + this.price;
    }

    /**
     * Adds weapon to actor's inventory and takes away runes.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            if (RuneManager.getInstance().getPlayer(actor).getRunes() >= this.price) {
                RuneManager.getInstance().getPlayer(actor).takeRunes(this.price);
                RuneManager.getInstance().getPlayer(actor).addWeaponToInventory(weapon);
                return menuDescription(actor);
            } else return RuneManager.getInstance().getPlayer(actor) + " doesn't have enough runes to purchase " + weapon;
        }
        return null;
    }
}
