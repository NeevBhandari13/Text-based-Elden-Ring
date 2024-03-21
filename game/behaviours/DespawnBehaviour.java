package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DespawnAction;
import game.util.RandomNumberGenerator;
import game.util.Status;

/**
 * A behaviour class to will determine whether an actor should despawn.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class DespawnBehaviour implements Behaviour {

    /**
     * Returns a despawn action if possible
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return a despawn action if possible, else returns null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        //if actor is not following and 10% chance
        if (!actor.hasCapability(Status.FOLLOWING) && RandomNumberGenerator.getRandomInt(1,100) <= 10) {
            return new DespawnAction();
        }
        return null;

    }

}
