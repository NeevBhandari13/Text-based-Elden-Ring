package game.traders;

/**
 * Tradable interface for items that are tradable.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public interface Tradable {

    /**
     * Gets the purchase price for the item
     * @return the purchase price
     */
    int getBuyPrice();

    /**
     * Gets the selling price for the item
     * @return the selling price
     */

    int getSellPrice();

    /**
     * default method that adds tradable object to trade manager.
     */
    default void addToTradeManager() {
        TradeManager.getInstance().addTradable(this);
    }

}
