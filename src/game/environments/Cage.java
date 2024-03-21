package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.Dog;

/**
 * A class that represents a gust of wind where wolves spawn.
 * Created by: Neev Bhandari
 */

public class Cage extends SpawningGround {

    /**
     * Chance for dog to spawn
     */
    private final int DOG_CHANCE = 37;

    /**
     * Constructor
     */
    public Cage() {
        super('<');
    }

    @Override
    public void tick(Location location) {
        this.Spawn(new Dog(), this.DOG_CHANCE, location);
    }
}
