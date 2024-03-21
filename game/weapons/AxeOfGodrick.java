package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Tradable;
import game.util.TradeData;

/**
 * Axe of Godrick used by Godrick the Grafted.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class AxeOfGodrick extends WeaponItem implements Tradable {

    /**
     * Price to buy this weapon from a trader
     */
    private final int BUY_PRICE = TradeData.AXE_OF_GODRICK.getBuyPrice();
    /**
     * Price to sell this weapon to a trader
     */
    private final int SELL_PRICE = TradeData.AXE_OF_GODRICK.getSellPrice();

    /**
     * Constructor
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "chops", 84);
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
