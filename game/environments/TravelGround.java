package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.util.Status;

/**
 * Travel ground abstract class that represents grounds that can be used to travel.
 * @author Brendan Nguyen, Neev Bhandari
 */
public abstract class TravelGround extends Ground {

    /**
     * The location for the actor to move
     */
    private Location moveLocation;
    /**
     * The move string representation
     */
    private String moveDirection;

    /**
     * Constructor
     * @param displayChar the char representation of the ground
     * @param moveLocation the location to move to
     * @param moveDirection the move string representation
     */
    public TravelGround(char displayChar, Location moveLocation, String moveDirection) {
        super(displayChar);
        this.moveLocation = moveLocation;
        this.moveDirection = moveDirection;
    }

    /**
     * Returns a list of allowable actions for the player to choose from.
     * If actor is a player, return move action.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.PLAYER_TYPE)) {
            actions.add(new MoveActorAction(this.moveLocation, moveDirection));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.PLAYER_TYPE);
    }

}
