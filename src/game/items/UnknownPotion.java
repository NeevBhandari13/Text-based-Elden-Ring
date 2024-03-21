package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.PlayerRespawnAction;
import game.reset.FancyMessage;
import game.runes.RuneManager;
import game.util.RandomNumberGenerator;

/**
 * Unknown potion that has a change of giving a good or bad effect to the player.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class UnknownPotion extends PortableConsumable {

    /**
     * Constructor
     */
    public UnknownPotion() {
        super("Unknown Potion", '!', true);
    }

    /**
     * 50/50 chance of increase max health or being cursed (dying and health being set to 3:14).
     * @param actor The actor using the item.
     */
    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            if (RandomNumberGenerator.getRandomInt(100) < 50) {
                actor.increaseMaxHp(1500);
                FancyMessage.printFancyMessage(FancyMessage.GODS_BLESSING);
                FancyMessage.printFancyMessage(FancyMessage.HEALTH_INCREASE);
            } else {
                FancyMessage.printFancyMessage(FancyMessage.GODS_WRATH);
                new PlayerRespawnAction().execute(actor, RuneManager.getInstance().getPlayer(actor).getLastLocation().map());
                actor.resetMaxHp(14);
                actor.hurt(11);
            }
            actor.removeItemFromInventory(this);
        }
    }


}
