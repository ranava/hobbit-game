package dev.ryoung.tilegame.states;

import java.awt.Graphics;

import dev.ryoung.tilegame.Game;
import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.entities.creatures.Player;
import dev.ryoung.tilegame.entities.statics.BagEnd;
import dev.ryoung.tilegame.gfx.Assets;
import dev.ryoung.tilegame.tiles.Tile;
import dev.ryoung.tilegame.worlds.World;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/hobbiton1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

	
	
}
