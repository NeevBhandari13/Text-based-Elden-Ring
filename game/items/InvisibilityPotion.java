package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.FancyMessage;
import game.runes.RuneManager;
import game.util.Capability;
import game.util.Status;

/**
 * Invisibility potion to hide from your enemies
 * @author Brendan Nguyen, Neev Bhandari
 */
public class InvisibilityPotion extends PortableConsumable {
    private boolean activated = false;
    private final int MAX_TURNS = 5;
    private int turns;
    public InvisibilityPotion() {
        super("Invisibility Potion", 'i', true);
        this.turns = MAX_TURNS;
    }

    /**
     * When used, effects get activated and can no longer drop or consume the item
     * @param actor The actor using the item.
     */
    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            this.activated = true;
            this.removeAction(this.consumeAction);
            this.togglePortability();
            actor.addCapability(Status.PEACEFUL);
            if (actor.hasCapability(Capability.FOLLOWABLE)) {
                actor.removeCapability(Capability.FOLLOWABLE);
            }
            FancyMessage.printFancyMessage(FancyMessage.INVISIBLE);
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
            if (RuneManager.getInstance().getPlayers().contains(actor)) {
                if (actor.hasCapability(Status.PEACEFUL)) {
                    actor.removeCapability(Status.PEACEFUL);
                }
                actor.addCapability(Capability.FOLLOWABLE);
                actor.removeItemFromInventory(this);
                FancyMessage.printFancyMessage(FancyMessage.VISIBLE);
            }
        }
        if (activated) {
            this.turns--;
        } else {
            if (!this.getAllowableActions().contains(consumeAction)) {
                this.addAction(consumeAction);
            }
        }
    }

}
