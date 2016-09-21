package dev.ryoung.tilegame.states;

import java.awt.Graphics;

import dev.ryoung.tilegame.Game;
import dev.ryoung.tilegame.Handler;
import dev.ryoung.tilegame.gfx.Assets;
import dev.ryoung.tilegame.ui.ClickListener;
import dev.ryoung.tilegame.ui.UIImageButton;
import dev.ryoung.tilegame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 120, 30, Assets.startButton, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
	
	
}
