package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.environments.RestingPlace;
import game.reset.ResetManager;
import game.runes.RuneManager;

/**
 * Rest action for player at resting places.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class RestAction extends Action {

    /**
     * The resting place
     */
    private RestingPlace restingPlace;

    /**
     * Constructor
     * @param restingPlace The resting place
     */
    public RestAction(RestingPlace restingPlace) {
        this.restingPlace = restingPlace;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).setLastRestLocation(map.locationOf(actor));
        }
        ResetManager.getInstance().run(map);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + this.restingPlace;
    }

}
