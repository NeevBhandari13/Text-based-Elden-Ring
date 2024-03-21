package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.HeavySkeletalSwordsman;
import game.actors.SkeletalBandit;

/**
 * A class that represents a graveyard where skeletal enemies spawn.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class Graveyard extends SpawningGround {

    /**
     * Chance for spawning heavy skeletal swordsman
     */
    private final int HEAVY_SKELETAL_SWORDSMAN_CHANCE = 27;
    /**
     * Chance for spawning skeletal bandit
     */
    private final int SKELETAL_BANDIT_CHANCE = 27;

    /**
     * Constructor
     */
    public Graveyard() {
        super('n');
    }

    @Override
    public void tick(Location location) {
        //if on east side, chance of spawning skeletal bandit
        if (location.x() > (location.map().getXRange().max()/2)) {
            this.Spawn(new SkeletalBandit(), this.SKELETAL_BANDIT_CHANCE, location);
        } else { //if on west side, chance of spawning heavy skeletal swordsman
            this.Spawn(new HeavySkeletalSwordsman(), this.HEAVY_SKELETAL_SWORDSMAN_CHANCE, location);
        }
    }
}
