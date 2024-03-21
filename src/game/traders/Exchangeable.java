package game.traders;

import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;

/**
 * Interface for items that can be exchanged for weapons.
 * @author Brendan Nguyen, Neev Bhandari
 */
public interface Exchangeable {

    /**
     * default method that adds exchangeable object to trade manager.
     */
    default void addExchangeableToTradeManager() {
        TradeManager.getInstance().addExchangeable(this);
    }

    /**
     * Gets the exchangeable weapons for the item
     * @return a list of exchangeable weapons
     */
    ArrayList<WeaponItem> getExchangeableItems();

}
