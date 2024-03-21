package game.traders;


import edu.monash.fit2099.engine.items.Item;

import java.util.ArrayList;

/**
 * A trade manager class that keeps track of all tradable & exchangeable items.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class TradeManager {

    /**
     * List of tradable items
     */
    private ArrayList<Tradable> tradables = new ArrayList<>();
    private ArrayList<Exchangeable> exchangeables = new ArrayList<>();

    /**
     * Instance of trade manager
     */
    private static TradeManager instance;

    /**
     * Static factory method to have only one instance of trade manager.
     * @return instance of trade manager
     */
    public static TradeManager getInstance() {
        if (instance == null) {
            instance = new TradeManager();
        }
        return instance;
    }

    /**
     * Adds a tradable item to the list of tradables
     * @param tradable A tradable item
     */
    public void addTradable(Tradable tradable) {
        this.tradables.add(tradable);
    }

    /**
     * Adds an exchangeable item to the list of exchangeables
     * @param exchangeable An exchangeable item
     */
    public void addExchangeable(Exchangeable exchangeable) { this.exchangeables.add(exchangeable); }

    /**
     * Retrieves a tradable item if in the trade manager list
     * @param item The item to retrieve
     * @return the tradable item if possible, else null
     */
    public Tradable getTradable(Item item) {
        for (Tradable tradable : this.tradables) {
            if (tradable.equals(item)) return tradable;
        }
        return null;
    }

    /**
     * Retrieves an exchangeable item if in the trade manager list
     * @param item The item to retrieve
     * @return the exchangeable item if possible, else null
     */
    public Exchangeable getExchangeable(Item item) {
        for (Exchangeable exchangeable  : this.exchangeables) {
            if (exchangeable.equals(item)) return exchangeable;
        }
        return null;
    }

    /**
     * Gives a copy of the tradables list
     * @return A copy of the tradables list
     */
    public ArrayList<Tradable> getTradables() {
        return new ArrayList<>(this.tradables);
    }

    /**
     * Gives a copy of the exchangeables list
     * @return A copy of the exchangebles list
     */
    public ArrayList<Exchangeable> getExchangeables() {
        return new ArrayList<>(this.exchangeables);
    }
    
}
