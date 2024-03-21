package game.environments;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class that represents a golden fog door used for travelling.
 * @author Brendan Nguyen, Neev Bhandari
 */
public class GoldenFogDoor extends TravelGround {

    /**
     * Constructor
     * @param moveLocation the location that can be travelled to.
     * @param direction the move string representation.
     */
    public GoldenFogDoor(Location moveLocation, String direction) {
        super('D', moveLocation, direction);
    }

}
