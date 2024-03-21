package game.actors;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.*;
import game.reset.Resettable;
import game.runes.RuneDropper;
import game.util.Capability;
import game.util.RuneData;
import game.util.Status;

/**
 * BEHOLD, DOG!
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Brendan Nguyen, Neev Bhandari
 */
public class LoneWolf extends Enemy implements RuneDropper, Resettable {
    /**
     * Lower bound of runes awarded when killed
     */
    private final int RUNE_LOWER_BOUND = RuneData.LONE_WOLF.getLowerBound();
    /**
     * Upper bound of runes award when killed
     */
    private final int RUNE_UPPER_BOUND = RuneData.LONE_WOLF.getUpperBound();

    /**
     * Constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour(Status.CANINE_TYPE));
        this.behaviours.put(996, new AreaAttackBehaviour(Status.CANINE_TYPE));
        this.behaviours.put(995, new DespawnBehaviour());
        this.addCapability(Capability.CAN_DROP_RUNES);
        this.addCapability(Status.CANINE_TYPE);
        this.addToRuneManager();
        this.addResettable();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    @Override
    public int getRuneLowerBound() { return this.RUNE_LOWER_BOUND; }

    @Override
    public int getRuneUpperBound() { return this.RUNE_UPPER_BOUND; }

    @Override
    public void reset(GameMap map) {
        map.removeActor(this);
    }
}
