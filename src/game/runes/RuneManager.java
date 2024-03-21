package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Player;

import java.util.ArrayList;

/**
 * A rune manager class that keeps track of all rune droppers and players.
 * Created by:
 * @author Brendan Nguyen, Neev Bhandari
 */
public class RuneManager {

    /**
     * List of rune droppers.
     */
    private ArrayList<RuneDropper> runeDroppers = new ArrayList<>();
    /**
     * List of players.
     */
    private ArrayList<Player> players = new ArrayList<>();
    /**
     * Instance of rune manager.
     */
    private static RuneManager instance;

    /**
     * Static factory method to have only one instance of rune manager.
     * @return the static instance of rune manager.
     */
    public static RuneManager getInstance() {
        if (instance == null) {
            instance = new RuneManager();
        }
        return instance;
    }

    /**
     * Adds a rune dropper to the list.
     * @param runeDropper the rune dropper to add
     */
    public void addRuneDropper(RuneDropper runeDropper) {
        this.runeDroppers.add(runeDropper);
    }

    /**
     * Adds player to the list of players.
     * @param player The player to add.
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * Gets the rune dropper asked for.
     * @param actor The actor to look for.
     * @return the rune dropper asked for.
     */
    public RuneDropper getRuneDropper(Actor actor) {
        for (RuneDropper runeDropper : this.runeDroppers) {
            if (runeDropper.equals(actor)) return runeDropper;
        }
        return null;
    }

    /**
     * Gets the player asked for.
     * @param actor The actor to look for.
     * @return the player asked for.
     */
    public Player getPlayer(Actor actor) {
        for (Player player : this.players) {
            if (player.equals(actor)) return player;
        }
        return null;
    }

    /**
     * Gives a copy of the rune droppers.
     * @return a copy of rune droppers.
     */
    public ArrayList<RuneDropper> getRuneDroppers() {
        return new ArrayList<>(this.runeDroppers);
    }

    /**
     * Gives a copy of the players.
     * @return a copy of players.
     */
    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

}
