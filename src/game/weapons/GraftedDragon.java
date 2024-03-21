package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Tradable;
import game.util.TradeData;

/**
 * Grafted Dragon weapon used by Godrick the Grafted.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class GraftedDragon extends WeaponItem implements Tradable {

    /**
     * Price to buy this weapon from a trader
     */
    private final int BUY_PRICE = TradeData.GRAFTED_DRAGON.getBuyPrice();
    /**
     * Price to sell this weapon to a trader
     */
    private final int SELL_PRICE = TradeData.GRAFTED_DRAGON.getSellPrice();

    /**
     * Constructor
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "burns", 90);
        this.addToTradeManager();
    }

    @Override
    public int getBuyPrice() {
        return this.BUY_PRICE;
    }

    @Override
    public int getSellPrice() {
        return this.SELL_PRICE;
    }

}
