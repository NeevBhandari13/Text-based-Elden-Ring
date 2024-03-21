package game.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.util.RandomNumberGenerator;

/**
 * An Action to award player with runes based on enemy killed.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class AwardRuneAction extends Action {

    /**
     * The amount to reward player
     */
    private int amount;
    /**
     * The enemy killed
     */
    private RuneDropper killedEnemy;

    /**
     * Constructor
     * @param killedEnemy The enemy that is killed
     */
    public AwardRuneAction(RuneDropper killedEnemy) {
        this.killedEnemy = killedEnemy;
        this.amount = RandomNumberGenerator.getRandomInt(this.killedEnemy.getRuneLowerBound()
                                                         ,this.killedEnemy.getRuneUpperBound());
    }

    /**
     * Perform the Action. Rewards the player with runes if they kill an enemy.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    public String execute(Actor actor, GameMap map) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            RuneManager.getInstance().getPlayer(actor).addRunes(this.amount);
            return menuDescription(actor);
        }
        return null;
    }

    /**
     * String of event displayed in menu display
     * @param actor The actor performing the action.
     * @return the String representation of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " awarded " + this.amount + " runes for killing " + this.killedEnemy;
    }

}
