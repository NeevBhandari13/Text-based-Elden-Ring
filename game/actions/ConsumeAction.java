package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * Consume action for consumable items.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class ConsumeAction extends Action {

    /**
     * Item to consume
     */
    private Consumable item;

    /**
     * Constructor
     * @param item The item to consume
     */
    public ConsumeAction(Consumable item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        item.use(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses " + this.item;
    }
}
