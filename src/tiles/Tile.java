package dev.ryoung.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile grassPuffTile = new GrassPuffTile(1);
	public static Tile grassBrownTile = new GrassBrownTile(2);
	public static Tile grassWaterTile = new GrassWaterTile(3);
	public static Tile waterTile = new WaterTile(4);
	public static Tile dirtPathUpTile = new DirtPathUpTile(5);
	public static Tile dirtPathDownTile = new DirtPathDownTile(6);
	public static Tile dirtPathLeftTile = new DirtPathLeftTile(7);
	public static Tile dirtPathRightTile = new DirtPathRightTile(8);
	public static Tile dirtPathNWTile = new DirtPathNWTile(9);
	public static Tile dirtPathNETile = new DirtPathNETile(10);
	public static Tile dirtPathSWTile = new DirtPathSWTile(11);
	public static Tile dirtPathSETile = new DirtPathSETile(12);
	
	//CLASS
	
	public static final int TILE_WIDTH = 48, TILE_HEIGHT = 48;
	
	protected BufferedImage texture;
	protected final int id; //final because it should never change
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){ //x and y position
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
