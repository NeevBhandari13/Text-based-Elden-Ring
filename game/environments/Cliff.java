package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PlayerRespawnAction;
import game.util.Capability;
import game.util.Status;

/**
 * A class that represents a cliff.
 * Player dies when stepped on.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class Cliff extends Ground {

    /**
     * Constructor
     */
    public Cliff() { super('+'); }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) {
            if (location.getActor().hasCapability(Status.PLAYER_TYPE) && location.getActor().hasCapability(Capability.RESPAWNABLE)) {
                new PlayerRespawnAction().execute(location.getActor(), location.map());
            }
        }
    }

}
