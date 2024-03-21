package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;
import game.reset.FancyMessage;
import game.runes.RuneManager;

/**
 * A potion that expands the flask of crimson tears uses.
 * @author Neev Bhandari, Brendan Nguyen
 */
public class ExpandFlaskPotion extends PortableConsumable {
    /***
     * Constructor.
     */
    public ExpandFlaskPotion() {
        super("Expand Flask Potion", 'e', true);
    }

    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor) == true)
            {   Player player = RuneManager.getInstance().getPlayer(actor);
                int current_uses = player.getFlaskOfCrimsonTears().getMAX_USES();
                player.getFlaskOfCrimsonTears().setMAX_USES(current_uses + 1);
                actor.removeItemFromInventory(this);
                FancyMessage.printFancyMessage(FancyMessage.INCREASE_FLASK);
            }
    }
}
