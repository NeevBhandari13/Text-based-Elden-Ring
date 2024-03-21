package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Exchangeable;
import game.traders.Tradable;
import game.util.TradeData;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

import java.util.ArrayList;

/**
 * Remembrance of the Grafted Item.
 * Dropped by Godrick the Grafted, can be sold or exchanged.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class RemembranceofTheGrafted extends Item implements Tradable, Exchangeable {

    /**
     * Price to buy item from a trader
     */
    private final int BUY_PRICE = TradeData.REMEMBRANCE_OF_THE_GRAFTED.getBuyPrice();
    /**
     * Price to sell item to a trader
     */
    private final int SELL_PRICE = TradeData.REMEMBRANCE_OF_THE_GRAFTED.getSellPrice();

    /**
     * A list of weapons that this item can be exchanged for
     */
    private ArrayList<WeaponItem> exchangeableWeapons = new ArrayList<>();

    /**
     * Constructor
     */
    public RemembranceofTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        this.exchangeableWeapons.add(new AxeOfGodrick());
        this.exchangeableWeapons.add(new GraftedDragon());
        this.addToTradeManager();
        this.addExchangeableToTradeManager();
    }

    @Override
    public int getBuyPrice() {
        return this.BUY_PRICE;
    }

    @Override
    public int getSellPrice() {
        return this.SELL_PRICE;
    }

    @Override
    public ArrayList<WeaponItem> getExchangeableItems() {
        return new ArrayList<>(this.exchangeableWeapons);
    }
}
