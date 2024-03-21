package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.items.FlaskofCrimsonTears;
import game.reset.Resettable;
import game.runes.RuneManager;
import game.util.Capability;
import game.util.Status;
import game.weapons.Club;


/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brendan Nguyen
 *
 */
public class Player extends Actor implements Resettable {

	/**
	 * Menu to display
	 */
	private final Menu menu = new Menu();
	/**
	 * Amount of runes the player has
	 */
	private int runes;

	private Location lastLocation;
	private Location lastRestLocation;

	private FlaskofCrimsonTears flaskOfCrimsonTears = new FlaskofCrimsonTears();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Capability.CAN_TRADE);
		this.addCapability(Capability.CAN_GET_RUNES);
		this.addCapability(Capability.FOLLOWABLE);
		this.addCapability(Status.PLAYER_TYPE);
		this.addCapability(Capability.CAN_REST);
		this.addCapability(Capability.RESPAWNABLE);
		this.addWeaponToInventory(new Club());
		this.runes = 0;
		RuneManager.getInstance().addPlayer(this);
		this.addResettable();
		this.addItemToInventory(flaskOfCrimsonTears);
	}

	/**
	 * At each turn, select a valid action to perform.
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the valid action that can be performed in that iteration or null if no valid action is found
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		//updates last location
		this.lastLocation = map.locationOf(this);
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		display.println("Hit Points: " + this.hitPoints + "/" + this.maxHitPoints);
		display.println("Runes: " + this.runes);
		display.println("Flask of Crimson Tears: " + this.flaskOfCrimsonTears.getUses());
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Returns amount of runes the player has.
	 * @return the current amount of runes the player has.
	 */
	public int getRunes() { return this.runes; }

	/**
	 * Adds a specified amount to player's runes.
	 * @param amount Amount of runes to add
	 */
	public void addRunes(int amount) { this.runes += amount; }

	/**
	 * Takes a specified amount from player's runes.
	 * @param amount Amount of runes to take
	 */
	public void takeRunes(int amount) { this.runes -= amount; }

	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(11, "punches");
	}

	/**
	 * Sets the last location the player rested
	 * @param lastRestLocation The last resting location
	 */
	public void setLastRestLocation(Location lastRestLocation) {
		this.lastRestLocation = lastRestLocation;
	}

	/**
	 * Gets the last location the player was
	 * @return the last location of the player
	 */
	public Location getLastLocation() { return this.lastLocation; }

	/**
	 * Gets the last resting location
	 * @return the last resting location
	 */
	public Location getLastRestLocation() {
		return this.lastRestLocation;
	}

	public FlaskofCrimsonTears getFlaskOfCrimsonTears() {
		return flaskOfCrimsonTears;
	}

	@Override
	public void reset(GameMap map) {
		this.hitPoints = maxHitPoints;
		this.runes = 0;
	}

}
