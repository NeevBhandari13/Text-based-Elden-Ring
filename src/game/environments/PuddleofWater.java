package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.GiantCrab;
import game.actors.GiantCrayfish;

/**
 * A class that represents a puddle of water where sea enemies spawn.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class PuddleofWater extends SpawningGround {

    /**
     * Chance for giant crab to spawn
     */
    private final int GIANT_CRAB_CHANCE = 2;
    /**
     * Chance for giant crayfish to spawn
     */
    private final int GIANT_CRAYFISH_CHANCE = 1;

    /**
     * Constructor
     */
    public PuddleofWater() {
        super('~');
    }

    @Override
    public void tick(Location location) {
        //if on east side, chance of spawning giant crayfish
        if (location.x() > (location.map().getXRange().max()/2)) {
            this.Spawn(new GiantCrayfish(), this.GIANT_CRAYFISH_CHANCE, location);
        } else { //if on west side, chance of spawning giant crab
            this.Spawn(new GiantCrab(), this.GIANT_CRAB_CHANCE, location);
        }
    }
}
