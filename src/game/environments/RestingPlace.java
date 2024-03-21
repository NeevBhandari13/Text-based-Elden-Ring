package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.util.Capability;
import game.util.Status;

/**
 * Abstract resting place class where players reset the map.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public abstract class RestingPlace extends Ground {

    /**
     * Name of the resting place;
     */
    private String name;

    /**
     * Constructor
     * @param name The name of the resting place
     * @param displayChar Character to display on map
     */
    public RestingPlace(String name, char displayChar) {
        super(displayChar);
        this.name = name;
    }

    /**
     * Returns a list of actions. Resting actions.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (location.containsAnActor() && location.getActor().hasCapability(Capability.CAN_REST)) {
            actions.add(new RestAction(this));
        }
        return actions;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
