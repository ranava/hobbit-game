package dev.ryoung.tilegame.entities.statics;

import java.awt.Graphics;

import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.gfx.Assets;
import dev.ryoung.tilegame.tiles.Tile;

public class FenceDown extends StaticEntity{
	
	public FenceDown(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		bounds.x = 15;
		bounds.y = 10;
		bounds.width = width / 3;
		bounds.height = height - 10;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.fenceDown, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

}
