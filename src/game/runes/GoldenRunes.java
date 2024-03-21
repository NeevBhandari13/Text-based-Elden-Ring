package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import game.items.PortableConsumable;
import game.util.RandomNumberGenerator;

/**
 * Class that represents golden runes that can be found.
 * Consuming the golden runes gives the player 200-10000 runes.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class GoldenRunes extends PortableConsumable {

    /**
     * Lower bound value for rune awarding
     */
    private final int LOWER_BOUND_VALUE = 200;
    /**
     * Upper bound value for rune awarding
     */
    private final int UPPER_BOUND_VALUE = 10000;

    /**
     * Constructor
     */
    public GoldenRunes() {
        super("Golden Runes", '*',true);
    }

    /**
     * When item is used, give the player runes between 200-10000 and remove from inventory.
     * @param actor The actor using the item.
     */
    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).addRunes(RandomNumberGenerator.getRandomInt(LOWER_BOUND_VALUE,UPPER_BOUND_VALUE));
            actor.removeItemFromInventory(this);
        }
    }

}
