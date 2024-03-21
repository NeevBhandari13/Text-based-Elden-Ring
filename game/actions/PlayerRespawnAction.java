package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.reset.FancyMessage;
import game.reset.ResetManager;
import game.runes.RuneItem;
import game.runes.RuneManager;

/**
 * Player respawn action that is executed when player is killed.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class PlayerRespawnAction extends Action {

    /**
     * The amount of runes to drop
     */
    private int runeAmount;

    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        if (RuneManager.getInstance().getPlayers().contains(target)) {

            Player player = RuneManager.getInstance().getPlayer(target);
            this.runeAmount = player.getRunes();

            ResetManager.getInstance().resetRunes(map);

            player.getLastLocation().addItem(new RuneItem(this.runeAmount, player.getLastLocation()));
            if (player.getLastRestLocation() != null) map.moveActor(target, player.getLastRestLocation());

            ResetManager.getInstance().run(map);
            FancyMessage.printFancyMessage(FancyMessage.YOU_DIED);
            result += menuDescription(target);
        }
        return result;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drops " + this.runeAmount + " runes";
    }

}
