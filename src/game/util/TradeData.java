package game.util;

/**
 * Use this enum for retrieving trade prices for items.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public enum TradeData {

    /**
     * Club trading prices
     */
    CLUB(600, 100),
    /**
     * Great Knife trading prices
     */
    GREAT_KNIFE(3500, 350),
    /**
     * Uchigatana trading prices
     */
    UCHIGATANA(5000, 500),
    /**
     * Grossmesser trading prices
     */
    GROSSMESSER(null, 100),
    /**
     * Scimitar trading prices
     */
    SCIMITAR(600, 100),
    /**
     * Axe of Godrick trading prices
     */
    AXE_OF_GODRICK(null, 100),
    /**
     * Remembrance of the Grafted trading prices
     */
    REMEMBRANCE_OF_THE_GRAFTED(null, 20000),
    /**
     * Grafted Dragon trading prices
     */
    GRAFTED_DRAGON(null, 200);

    /**
     * Purchase price for an item
     */
    private final Integer buyPrice;
    /**
     * Selling price for an item
     */
    private final Integer sellPrice;

    /**
     * Private constructor that assigns enum values
     * @param buyPrice Purchase price for an item
     * @param sellPrice Selling price for an item
     */
    TradeData(Integer buyPrice, Integer sellPrice) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    /**
     * Gets buying price for an item
     * @return the buying price for an item
     */
    public int getBuyPrice() {
        if (this.buyPrice == null) return -1;
        return this.buyPrice;
    }

    /**
     * Gets the selling price for an item
     * @return the selling price for an item
     */
    public int getSellPrice() {
        if (this.sellPrice == null) return -1;
        return this.sellPrice;
    }

}
