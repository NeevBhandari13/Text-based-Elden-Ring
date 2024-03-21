package game.traders;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.util.Capability;
import game.util.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Trader class that buys and sells items.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 *
 */
public abstract class Trader extends Actor {

    /**
     * Goods that the trader is selling
     */
    private ArrayList<WeaponItem> goods;

    /**
     * Constructor
     * @param name Name of the trader
     * @param DisplayChar Display character of trader on map
     * @param hitPoints Hit points of trader
     */
    public Trader(String name, char DisplayChar, int hitPoints) {
        super(name, DisplayChar, hitPoints);
        this.goods = this.addGoods();
    }

    /**
     * Add items to list of goods the trader will sell
     * @return a list of goods being sold
     */
    public abstract ArrayList<WeaponItem> addGoods();

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Capability.CAN_TRADE)) {
            for (WeaponItem weapon : this.goods) {
                if (TradeManager.getInstance().getTradables().contains(weapon)) {
                    actions.add(new BuyAction(this, weapon, TradeManager.getInstance().getTradable(weapon).getBuyPrice()));
                }
            }
            List<WeaponItem> sellableWeapons = otherActor.getWeaponInventory();
            for (WeaponItem weapon : sellableWeapons) {
                if (TradeManager.getInstance().getTradables().contains(weapon)) {
                    actions.add(new SellWeaponAction(this, weapon, TradeManager.getInstance().getTradable(weapon).getSellPrice()));
                }
            }
            List<Item> playerItems = otherActor.getItemInventory();
            for (Item item : playerItems) {
                if (TradeManager.getInstance().getTradables().contains(item)) {
                    actions.add(new SellItemAction(this, item, TradeManager.getInstance().getTradable(item).getSellPrice()));
                }
                if (TradeManager.getInstance().getExchangeables().contains(item)) {
                    for (WeaponItem exchangeItem : TradeManager.getInstance().getExchangeable(item).getExchangeableItems()) {
                        actions.add(new ExchangeAction(this, item, exchangeItem));
                    }
                }
            }
        }
        return actions;
    }


}
