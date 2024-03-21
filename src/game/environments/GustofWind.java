package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.GiantDog;
import game.actors.LoneWolf;

/**
 * A class that represents a gust of wind where wolves spawn.
 * Created by:
33andari
 */
public class GustofWind extends SpawningGround {

    /**
     * Chance for lone wolf to spawn
     */
    private final int LONE_WOLF_CHANCE = 33;
    /**
     * Chance for giant dog to spawn
     */
    private final int GIANT_DOG_CHANCE = 4;

    /**
     * Constructor
     */
    public GustofWind() {
        super('&');
    }

    @Override
    public void tick(Location location) {
        //if on east side, chance of spawning giant dog
        if (location.x() > (location.map().getXRange().max()/2)) {
            this.Spawn(new GiantDog(), this.GIANT_DOG_CHANCE, location);
        } else { //if on west side, chance of spawning lone wolf
            this.Spawn(new LoneWolf(), this.LONE_WOLF_CHANCE, location);
        }
    }
}
