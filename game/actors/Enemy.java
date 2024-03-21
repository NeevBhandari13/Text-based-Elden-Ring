package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.util.Capability;
import game.util.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class for enemy actors.
 * @author Brendan Nguyen, Neev Bhandari
 */
public abstract class Enemy extends Actor {

    /**
     * HashMap of behaviours
     */
    Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor
     * @param name The name of the enemy
     * @param displayChar Char to represent enemy on map
     * @param hitPoints The hitpoints of the enemy
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The enemy can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        //add follow behaviour
        if (otherActor.hasCapability(Capability.FOLLOWABLE)) {
            this.behaviours.put(998, new FollowBehaviour(otherActor));
            this.addCapability(Status.FOLLOWING);
        }

        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            //attack actions for weapons
            if (!otherActor.getWeaponInventory().isEmpty()) {
                for (WeaponItem weapon : otherActor.getWeaponInventory()) {
                    actions.add(new AttackAction(this, direction, weapon));
                    if (weapon.hasCapability(Capability.AREA_ATTACK)) actions.add(new AreaAttackAction(this,weapon));
                }
            }
            //attack action for intrinsic weapon
            actions.add(new AttackAction(this, direction));

        }
        return actions;
    }

}
