package dev.ryoung.tilegame.tiles;

import dev.ryoung.tilegame.gfx.Assets;

public class GrassBrownTile extends Tile{

	public GrassBrownTile(int id) {
		super(Assets.grassBrown, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}