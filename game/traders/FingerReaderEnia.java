package game.traders;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.util.Status;

import java.util.ArrayList;

/**
 * Finger Reader Enia trader.
 * Located in boss room.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class FingerReaderEnia extends Trader {

    /**
     * Constructor
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 1);
        this.addCapability(Status.PEACEFUL);
    }

    /**
     * Add items to list of goods the trader will sell
     * @return a list of goods being sold
     */
    public ArrayList<WeaponItem> addGoods() {
        return new ArrayList<>();
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
        return new DoNothingAction();
    }

}
