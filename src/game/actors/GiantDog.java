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
 * Giant dog class of canine type.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class GiantDog extends Enemy implements RuneDropper, Resettable {
    /**
     * Lower bound of runes awarded when killed
     */
    private final int RUNE_LOWER_BOUND = RuneData.GIANT_DOG.getLowerBound();
    /**
     * Upper bound of runes award when killed
     */
    private final int RUNE_UPPER_BOUND = RuneData.GIANT_DOG.getUpperBound();

    /**
     * Constructor
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour(Status.CANINE_TYPE));
        this.behaviours.put(996, new AreaAttackBehaviour(Status.CANINE_TYPE));
        this.behaviours.put(995, new DespawnBehaviour());
        this.addCapability(Capability.CAN_DROP_RUNES);
        this.addCapability(Capability.SLAM_ATTACK);
        this.addCapability(Status.CANINE_TYPE);
        this.addToRuneManager();
        this.addResettable();
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "head slams", 90);
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


