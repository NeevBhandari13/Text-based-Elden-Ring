package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Tradable;
import game.util.TradeData;

/**
 * A weapon that can be used to attack an enemy
 * It deals 75 damage with a 70% hit rate.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 *
 */
public class GreatKnife extends WeaponItem implements Tradable {

    /**
     * Price to buy this weapon from a trader
     */
    private final int BUY_PRICE = TradeData.GREAT_KNIFE.getBuyPrice();
    /**
     * Price to sell this weapon to a trader
     */
    private final int SELL_PRICE = TradeData.GREAT_KNIFE.getSellPrice();

    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "cuts", 70);
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

    @Override
    public void tick(Location currentLocation, Actor actor) {}

}
