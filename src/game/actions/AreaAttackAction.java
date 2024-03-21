package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.util.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * An Action to attack the surrounding area.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 *
 */
public class AreaAttackAction extends Action {

    /**
     * Hashmap representing surrounding enemies and their string direction
     */
    private Actor target;
    /**
     * The weapon using this action
     */
    private Weapon weapon;

    /**
     * Constructor
     * @param target Target actor who will be attacked
     * @param weapon The weapon using the action
     */
    public AreaAttackAction(Actor target, Weapon weapon) {
        this.target = target;
        this.weapon = weapon;
    }

    /**
     * Constructor with intrinsic weapon as default.
     * @param target Target actor who will be attacked
     */
    public AreaAttackAction(Actor target) {
        this.target = target;
    }

    /**
     * When executed, attack actions on the surrounding enemies will be executed, individually having their own
     * chances of being hit.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of the area attack
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        String result = this.menuDescription(actor);
        for (Map.Entry<Actor, String> enemy : this.getSurroundingEnemies(actor, map).entrySet()) {
            if (this.weapon == null) this.weapon = actor.getIntrinsicWeapon();
            result += "\n" + new AttackAction(enemy.getKey(), enemy.getValue(), this.weapon).execute(actor, map);
        }
        return result;
    }

    /**
     * Gets surrounding enemies of the player
     * @param map the map containing the Actor
     * @param actor the actor who is attacking
     * @return a hashmap of actors and string directions
     */
    private HashMap<Actor, String> getSurroundingEnemies(Actor actor, GameMap map) {
        HashMap<Actor, String> surroundingEnemies = new HashMap<>();
        Location playerLocation = map.locationOf(actor);
        for (Exit exit : playerLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && !destination.getActor().hasCapability(Status.PEACEFUL)) {
                surroundingEnemies.put(destination.getActor(), exit.getName());
            }
        }
        return surroundingEnemies;
    }

    /**
     * Describes which actor is using an area attack with what weapon.
     *
     * @param actor The actor performing the action.
     * @return a description used for menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " " + (weapon != null ? weapon.verb() : "slams")
                + " surrounding area with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
