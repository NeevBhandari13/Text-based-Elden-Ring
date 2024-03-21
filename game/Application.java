package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.environments.*;
import game.items.*;
import game.reset.FancyMessage;
import game.runes.GoldenRunes;
import game.traders.FingerReaderEnia;
import game.traders.MerchantKale;
import game.util.Maps;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Brendan Nguyen, Neev Bhandari
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(),
																	new GustofWind(), new PuddleofWater(), new SiteofLostGrace(),
																	new Cliff(), new Barrack(), new Cage());

		GameMap limgrave = new GameMap(groundFactory, Maps.LIMGRAVE_MAP);
		world.addGameMap(limgrave);
		GameMap roundtableHold = new GameMap(groundFactory, Maps.ROUNDTABLE_HOLD_MAP);
		world.addGameMap(roundtableHold);
		GameMap stormveilCastle = new GameMap(groundFactory, Maps.STORMVEIL_CASTLE_MAP);
		world.addGameMap(stormveilCastle);
		GameMap bossRoom = new GameMap(groundFactory, Maps.BOSS_ROOM_MAP);
		world.addGameMap(bossRoom);

		// BEHOLD, ELDEN RING
		FancyMessage.printFancyMessage(FancyMessage.ELDEN_RING);

		//adding grounds and actors to Limgrave
		limgrave.at(40,12).addActor(new MerchantKale());
		limgrave.at(11,21).addActor(new FingerReaderEnia());
		limgrave.at(6, 23).setGround(new GoldenFogDoor(roundtableHold.at(9, 10), "to Roundtable Hold"));
		limgrave.at(29, 0).setGround(new GoldenFogDoor(stormveilCastle.at(38, 23), "to Stormveil Castle"));
		//adding golden runes to Limgrave and potions
		limgrave.at(10,4).addItem(new GoldenRunes());
		limgrave.at(4,20).addItem(new GoldenRunes());
		limgrave.at(70,21).addItem(new GoldenRunes());
		limgrave.at(60,4).addItem(new GoldenRunes());
		limgrave.at(63,14).addItem(new GoldenRunes());
		limgrave.at(48,7).addItem(new ExpandFlaskPotion());
		limgrave.at(24, 5).addItem(new RegenerationPotion());
		limgrave.at(35,12).addItem(new UnknownPotion());
		limgrave.at(2,9).addItem(new TeleportPotion());
		limgrave.at(38,8).addItem(new InvisibilityPotion());


		//adding grounds to Roundtable Hold
		roundtableHold.at(9,10).setGround(new GoldenFogDoor(limgrave.at(6,23), "to Limgrave"));

		//adding grounds to Stormveil Castle
		stormveilCastle.at(38,23).setGround(new GoldenFogDoor(limgrave.at(29,0), "to Limgrave"));
		stormveilCastle.at(0,1).setGround(new GoldenFogDoor(bossRoom.at(0,4), "to Boss Room"));
		//adding golden runes to Stormveil Castle
		stormveilCastle.at(6,0).addItem(new GoldenRunes());
		stormveilCastle.at(60,2).addItem(new GoldenRunes());
		stormveilCastle.at(1,4).addItem(new GoldenRunes());
		stormveilCastle.at(64,19).addItem(new GoldenRunes());

		//add grounds to boss room
		bossRoom.at(0,4).setGround(new GoldenFogDoor(stormveilCastle.at(0,1), "to Stormveil Castle"));

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300); //300 hit-points default
		world.addPlayer(player, limgrave.at(36, 10));

		world.run();
	}
}
