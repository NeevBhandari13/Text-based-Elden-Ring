package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.util.Status;

/**
 * A behaviour class to determine if single attack should be performed
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class AttackBehaviour implements Behaviour {

    /**
     * The type of actor associated with this behaviour
     */
    private Status type;
    /**
     * The weapon of actor (null if no weapon)
     */
    private WeaponItem weapon;

    /**
     * Constructor
     *
     * @param actorType Status enum of type of actor
     */
    public AttackBehaviour(Status actorType) {
        this.type = actorType;
    }

    /**
     * Returns an attack action if possible, else returns null
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an attack action if possible or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        if (!actor.getWeaponInventory().isEmpty()) {
            this.weapon = actor.getWeaponInventory().get(0);
        }

        Location actorLocation = map.locationOf(actor);
        for (Exit exit : actorLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                //if the surrounding actor is the player or not the same type
                if (destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY) || !destination.getActor().hasCapability(this.type)) {
                    if (!destination.getActor().hasCapability(Status.PEACEFUL)) {
                        //single attack with first weapon or intrinsic weapon
                        if (this.weapon == null) {
                            return new AttackAction(destination.getActor(), exit.getName());
                        } else return new AttackAction(destination.getActor(), exit.getName(), this.weapon);
                    }
                }
            }

        }

        //if no surrounding enemies
        return null;

    }
}
