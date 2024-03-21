package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Tradable;
import game.util.TradeData;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Tradable {

    /**
     * Price to buy this weapon from a trader
     */
    private final int BUY_PRICE = TradeData.CLUB.getBuyPrice();
    /**
     * Price to sell this weapon to a trader
     */
    private final int SELL_PRICE = TradeData.CLUB.getSellPrice();

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
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
