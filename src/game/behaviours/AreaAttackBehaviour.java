package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.util.Capability;
import game.util.RandomNumberGenerator;
import game.util.Status;

/**
 * A behaviour class to determine if an area attack should be performed
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class AreaAttackBehaviour implements Behaviour {

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
    public AreaAttackBehaviour(Status actorType) {
        this.type = actorType;
    }

    /**
     * Returns an area attack action if possible, else returns null
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
                        //if actor has area attack weapon, 50% chance of attacking area
                        if (this.weapon != null && this.weapon.hasCapability(Capability.AREA_ATTACK)) {
                            if (RandomNumberGenerator.getRandomInt(100) <= 50) {
                                return new AreaAttackAction(destination.getActor(), this.weapon);
                            }
                        }

                        //if actor has slam attack ability, 50% chance of attacking area with intrinsic weapon
                        if (actor.hasCapability(Capability.SLAM_ATTACK)) {
                            if (RandomNumberGenerator.getRandomInt(100) <= 50) {
                                return new AreaAttackAction(destination.getActor());
                            }
                        }
                    }
                }
            }

        }

        //if no surrounding enemies
        return null;

    }

}
