package game.actors;

import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.*;
import game.reset.Resettable;
import game.runes.RuneDropper;
import game.util.Capability;
import game.util.RuneData;
import game.util.Status;
import game.weapons.Grossmesser;

/**
 * Heavy Skeletal Swordsman of skeleton type, holds the Grossmesser weapon.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class HeavySkeletalSwordsman extends Enemy implements Resettable, RuneDropper {

    /**
     * Lower bound of runes awarded when killed
     */
    private final int RUNE_LOWER_BOUND = RuneData.HEAVY_SKELETAL_SWORDSMAN.getLowerBound();
    /**
     * Upper bound of runes award when killed
     */
    private final int RUNE_UPPER_BOUND = RuneData.HEAVY_SKELETAL_SWORDSMAN.getUpperBound();

    /**
     * Constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour(Status.SKELETON_TYPE));
        this.behaviours.put(996, new AreaAttackBehaviour(Status.SKELETON_TYPE));
        this.behaviours.put(995, new DespawnBehaviour());
        this.addCapability(Status.SKELETON_TYPE);
        this.addCapability(Capability.CAN_TRANSFORM);
        this.addWeaponToInventory(new Grossmesser());
        this.addResettable();
        this.addToRuneManager();
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

