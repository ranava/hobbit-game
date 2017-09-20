package dev.ryoung.tilegame.entities.statics;

import java.awt.Graphics;

import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.gfx.Assets;
import dev.ryoung.tilegame.tiles.Tile;

public class HobbitHole1 extends StaticEntity{

	public HobbitHole1(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 6);
		
		bounds.x = 0;
		bounds.y = 2;
		bounds.width = width - 5;
		bounds.height = (int) (height - 24);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.hobbitHole1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	
}
