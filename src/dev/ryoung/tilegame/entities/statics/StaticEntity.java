package dev.ryoung.tilegame.entities.statics;

import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height){
		super(handler, x, y, width, height);
	}
	
	
	
}
