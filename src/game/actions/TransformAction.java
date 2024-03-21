package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Transform action that transforms one actor into another actor.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class TransformAction extends Action {

    /**
     * The actor to transform to
     */
    Actor next;

    /**
     * Constructor
     * @param actor The actor to transform to
     */
    public TransformAction(Actor actor) {
        this.next = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        map.removeActor(actor);
        map.addActor(this.next, location);
        return menuDescription(actor);

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " transforms to " + this.next;
    }
}
