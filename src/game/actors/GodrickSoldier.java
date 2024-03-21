package game.actors;

import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.*;
import game.reset.Resettable;
import game.runes.RuneDropper;
import game.util.RuneData;
import game.util.Status;
import game.weapons.HeavyCrossbow;

/**
 * A class that represents a godrick soldier enemy.
 * Created by: Neev Bhandari
 */
public class GodrickSoldier extends Enemy implements Resettable, RuneDropper {

    /**
     * Lower bound of runes awarded when killed
     */
    private final int RUNE_LOWER_BOUND = RuneData.GODRICK_SOLDIER.getLowerBound();
    /**
     * Upper bound of runes award when killed
     */
    private final int RUNE_UPPER_BOUND = RuneData.GODRICK_SOLDIER.getUpperBound();

    /**
     * Constructor
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(997, new AttackBehaviour(Status.STORMVEIL_TYPE));
        this.behaviours.put(995, new DespawnBehaviour());
        this.addCapability(Status.STORMVEIL_TYPE);
        this.addWeaponToInventory(new HeavyCrossbow());
        this.addResettable();
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

