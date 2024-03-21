package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.GodrickSoldier;

/**
 * A class that represents a barrack where godrick soldiers spawn.
 * Created by: Neev Bhandari
 */
public class Barrack extends SpawningGround {

    /**
     * Chance for dog to spawn
     */
    private final int GODRICK_SOLDIER_CHANCE = 45;

    /**
     * Constructor
     */
    public Barrack() {
        super('B');
    }

    @Override
    public void tick(Location location) {
        this.Spawn(new GodrickSoldier(), this.GODRICK_SOLDIER_CHANCE, location);
    }
}
