package dev.ryoung.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.ryoung.tilegame.Game;
import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.gfx.Animation;
import dev.ryoung.tilegame.gfx.Assets;

public class Player extends Creature {
	
	//Animations
	private Animation animateDown, animateUp, animateLeft, animateRight;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT + 24);
		
		bounds.x = 0;
		bounds.y = 28;
		bounds.width = 48;
		bounds.height = 40;
		
		//Animations
		animateDown = new Animation(250, Assets.player_down);
		animateUp = new Animation(250, Assets.player_up);
		//animateLeft = new Animation(500, Assets.player_left);
		//animateRight = new Animation(500, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animations
		animateDown.tick();
		animateUp.tick();
		//animateLeft.tick();
		//animateRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if (yMove > 0){
			return animateDown.getCurrentFrame();
		}else if (yMove < 0){
			return animateUp.getCurrentFrame();
		}else if (xMove < 0){
			return animateDown.getCurrentFrame();
			//change this to if xMove < 0 while yMove == 0? so only pure left/right
			//return animateLeft.getCurrentFrame();
		}else if (xMove > 0){
			return animateDown.getCurrentFrame();
			//return animateRight.getCurrentFrame();
		}else{
			return Assets.bilbo_forward;
		}
	}

}
