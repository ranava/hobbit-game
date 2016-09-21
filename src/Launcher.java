package dev.ryoung.tilegame;

import dev.ryoung.tilegame.display.Display;

public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("Tile Game!", 940, 760);
		game.start();
	}
}
