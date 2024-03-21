package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.reset.Resettable;

/**
 * Flask of crimson tears that heals the user.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class FlaskofCrimsonTears extends Item implements Consumable, Resettable {

    /**
     * The amount the flask heals by
     */
    private int HEAL_VALUE = 250;
    /**
     * The amount of uses the flask has
     */
    private int uses;
    /**
     * The max amount of uses the flask can have.
     */
    private int MAX_USES = 2;

    /**
     * Constructor.
     */
    public FlaskofCrimsonTears() {
        super("Flask of Crimson Tears", 'f' , false);
        this.addResettable();
        this.addAction(new ConsumeAction(this));
        this.uses = MAX_USES;
    }

    public FlaskofCrimsonTears(int Uses) {
        super("Flask of Crimson Tears", 'f' , false);
        this.addResettable();
        this.addAction(new ConsumeAction(this));
        this.uses = MAX_USES;
        this.MAX_USES = Uses;
    }

    /**
     * Use methods that heals the player for 250 hit-points
     * @param actor The actor using the flask
     */
    public void use(Actor actor) {
        if (this.uses > 0) {
            actor.heal(this.HEAL_VALUE);
            this.uses--;
        }
    }

    /**
     * Get the max usages of the flask
     * @return the max usages of the flask
     */
    public int getMAX_USES() {
        return MAX_USES;
    }

    /**
     * Sets the max uses of the flask
     * @param MAX_USES the new max uses
     */
    public void setMAX_USES(int MAX_USES) {
        this.MAX_USES = MAX_USES;
        this.uses = this.MAX_USES;
    }

    /**
     * Gets the amount of usages left
     * @return the amount of usages left
     */
    public int getUses() {
        return this.uses;
    }

    /**
     * Reset method that resets uses to max amount.
     * @param map The map the resettable object is currently in.
     */
    @Override
    public void reset(GameMap map) {
        uses = MAX_USES;
    }

}