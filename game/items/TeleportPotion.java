package game.items;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.FancyMessage;
import game.runes.RuneManager;
import game.util.RandomNumberGenerator;

/**
 * Teleportation potion to get you out of a scrap. (or in more trouble)
 * @author Brendan Nguyen, Neev Bhandari
 */
public class TeleportPotion extends PortableConsumable {

    /**
     * Constructor
     */
    public TeleportPotion() {
        super("Teleport Potion", '%', true);
    }

    /**
     * When item is used, teleports user to a random spot on the current map.
     * @param actor The actor using the item.
     */
    @Override
    public void use(Actor actor) {
        if (RuneManager.getInstance().getPlayers().contains(actor)) {
            while (true) {
                //loop until new location can be entered
                Location newLocation = getRandomLocation(actor);
                if (newLocation.canActorEnter(actor)) {
                    new MoveActorAction(newLocation, "to random location").execute(actor, newLocation.map());
                    actor.removeItemFromInventory(this);
                    FancyMessage.printFancyMessage(FancyMessage.TELEPORTED);
                    break;
                }
            }
        }
    }

    /**
     * Gets a random location to teleport to
     * @param actor the actor being teleported
     * @return the new location
     */
    private Location getRandomLocation(Actor actor) {
        GameMap actorMap = RuneManager.getInstance().getPlayer(actor).getLastLocation().map();
        int xCoord = RandomNumberGenerator.getRandomInt(actorMap.getXRange().min(), actorMap.getXRange().max());
        int yCoord = RandomNumberGenerator.getRandomInt(actorMap.getYRange().min(), actorMap.getYRange().max());
        return actorMap.at(xCoord, yCoord);
    }

}
