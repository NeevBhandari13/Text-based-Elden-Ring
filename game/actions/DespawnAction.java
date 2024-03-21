package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An Action to despawn the actor.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class DespawnAction extends Action {

    /**
     * When executed, the actor will be removed from the map.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string describing the action event
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return menuDescription(actor);
    }

    /**
     * Describes which actor is being despawned.
     * @param actor The actor performing the action.
     * @return a description used for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has despawned";
    }

}
