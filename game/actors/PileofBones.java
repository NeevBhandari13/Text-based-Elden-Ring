package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.TransformAction;
import game.reset.Resettable;
import game.runes.RuneDropper;
import game.runes.RuneManager;
import game.util.Capability;
import game.util.Status;

/**
 * Pile of Bones which undead enemies transform to after 0 hit-points.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class PileofBones extends Enemy implements Resettable, RuneDropper {

    /**
     * The amount of turns the pile of bones have to transform back
     */
    private int turns = 3;
    /**
     * The previous actor that was transformed
     */
    private Actor previous;

    /**
     * Constructor
     * @param previous The previous actor
     */
    public PileofBones(Actor previous) {
        super("Pile of Bones", 'X', 1);
        this.addResettable();
        this.addToRuneManager();
        this.previous = previous;
        this.addCapability(Status.SKELETON_TYPE);
        this.addCapability(Capability.CAN_DROP_RUNES);
        this.addWeaponToInventory(previous.getWeaponInventory().get(0));
    }

    /**
     * Counts number of turns, then transforms back to previous enemy if not hit
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return The action to transform back
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        this.turns--;
        if (this.turns == 0) {
            return new TransformAction(this.previous);
        }
        return new DoNothingAction();
    }

    @Override
    public int getRuneLowerBound() {
        if (RuneManager.getInstance().getRuneDroppers().contains(previous)) {
             return RuneManager.getInstance().getRuneDropper(previous).getRuneLowerBound();
        } else return 0;
    }

    @Override
    public int getRuneUpperBound() {
        if (RuneManager.getInstance().getRuneDroppers().contains(previous)) {
            return RuneManager.getInstance().getRuneDropper(previous).getRuneUpperBound();
        } else return 0;
    }

    @Override
    public void reset(GameMap map) {
        map.removeActor(this);
    }

}
