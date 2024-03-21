package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.traders.Tradable;
import game.util.Capability;
import game.util.TradeData;

/**
 * A weapon that can be used to attack an enemy
 * It deals 115 damage with an 85% hit rate.
 * Has special ability: area attack
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class Grossmesser extends WeaponItem implements Tradable {

    /**
     * Price to buy this weapon from a trader
     */
    private final int BUY_PRICE = TradeData.GROSSMESSER.getBuyPrice();
    /**
     * Price to sell this weapon to a trader
     */
    private final int SELL_PRICE = TradeData.GROSSMESSER.getSellPrice();

    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "strikes", 85);
        this.addCapability(Capability.AREA_ATTACK);
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




