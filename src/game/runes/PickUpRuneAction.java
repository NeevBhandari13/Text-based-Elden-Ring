package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Action to pick up runes that have been dropped.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class PickUpRuneAction extends PickUpAction {

    /**
     * The rune item to drop
     */
    private RuneItem runes;

    /**
     * Constructor
     * @param runes The rune item to drop
     */
    public PickUpRuneAction(RuneItem runes) {
        super(runes);
        this.runes = runes;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).addRunes(this.runes.getValue());
            map.locationOf(actor).removeItem(this.runes);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves " + this.runes + " (value: " + this.runes.getValue() + ")";
    }

}
