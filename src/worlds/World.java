package dev.ryoung.tilegame.worlds;

import java.awt.Graphics;

import dev.ryoung.tilegame.Game;
import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.entities.EntityManager;
import dev.ryoung.tilegame.entities.creatures.Player;
import dev.ryoung.tilegame.entities.statics.BagEnd;
import dev.ryoung.tilegame.entities.statics.FenceDown;
import dev.ryoung.tilegame.entities.statics.FenceEnd;
import dev.ryoung.tilegame.entities.statics.FenceLeft;
import dev.ryoung.tilegame.tiles.Tile;
import dev.ryoung.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int [][] tiles;
	//Entities
	private EntityManager entityManager;
	private int entityWidth = 48;
	private int entityHeight = 48;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new BagEnd(handler, 170, 10));
		
		//World fence
		entityManager.addEntity(new FenceDown(handler, -7, 0));
		entityManager.addEntity(new FenceDown(handler, -7, entityHeight));
		for(int i = 2; i < 28; i++){
			entityManager.addEntity(new FenceDown(handler, -7, entityHeight * i));
		}
		entityManager.addEntity(new FenceEnd(handler, -7, entityHeight * 28));
		
		entityManager.addEntity(new FenceLeft(handler, 36, 0));
		for(int i = 1; i < 4; i++){
			entityManager.addEntity(new FenceLeft(handler, (entityWidth * i) + 36, 0));
		}
		entityManager.addEntity(new FenceEnd(handler, (entityWidth * 4) + 18, 0));
		
		for(int i = 13; i < 80; i++){
			entityManager.addEntity(new FenceLeft(handler, (entityWidth * i) + 36, 0));
		}
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1 );
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x,y).render(g, (int)(x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}
