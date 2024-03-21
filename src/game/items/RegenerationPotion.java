package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.FancyMessage;
import game.runes.RuneManager;

/**
 * A regeneration potion that gives the player a regen effect for a certain amount of turns.
 * @author Neev Bhandari, Brendan Nguyen
 */
public class RegenerationPotion extends PortableConsumable {

    /**
     * Whether the potion has been consumed
     */
    private boolean activated = false;

    /**
     * The max turns the potion lasts for
     */
    private final int MAX_TURNS = 5;

    /**
     * The amount of turns the potion has lasted for
     */
    private int turns;

    /**
     * The healing value of the potion
     */
    private int HEAL_VALUE = 30;

    /***
     * Constructor.
     */
    public RegenerationPotion() {
        super("Healing Potion", '^', true);
        this.turns = MAX_TURNS;
    }


    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            this.activated = true;
            this.removeAction(this.consumeAction);
            this.togglePortability();
            FancyMessage.printFancyMessage(FancyMessage.HEALTH_REGEN);
        }
    }

    /**
     * Inform a carried Item of the passage of time.
     * If activated, count turns, if turns reach 0, remove effects.
     * This method is called once per turn, if the Item is being carried.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.turns == 0) {
            actor.removeItemFromInventory(this);
            FancyMessage.printFancyMessage(FancyMessage.HEALTH_REGEN_OFF);
        }
        if (activated) {
            actor.heal(this.HEAL_VALUE);
            this.turns--;
        } else {
            if (!this.getAllowableActions().contains(consumeAction)) {
                this.addAction(consumeAction);
            }
        }
    }
}
