package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.util.RandomNumberGenerator;

/**
 * Abstract class that represents a ground that can spawn actors.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public abstract class SpawningGround extends Ground {

    /**
     * Constructor
     * @param displayChar The character to represent the ground on the map
     */
    public SpawningGround(char displayChar) {
        super(displayChar);
    }

    /**
     * Spawning method that spawns a specified actor if there is no actor there, based on chance
     * @param actor The actor to spawn
     * @param chance The chance for the actor to spawn
     * @param location The location to spawn the actor
     */
    public void Spawn(Actor actor, int chance, Location location) {
        if (!location.containsAnActor()) {
            if (RandomNumberGenerator.getRandomInt(1, 100) <= chance)
            {location.addActor(actor);}
        }
    }

}
