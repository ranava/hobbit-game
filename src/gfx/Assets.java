package dev.ryoung.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 16;
	private static final int height = 16;
	
	public static BufferedImage[] startButton;
	
	public static BufferedImage grass, grassPuff, grassBrownPuff, grassBrown, grassLong, grassPatch, grassWater;
	public static BufferedImage dirtPatch, brick, grassHole, pathGreen, pathRed, pathRock, water;
	public static BufferedImage dirtPathUp, dirtPathDown, dirtPathLeft, dirtPathRight, dirtPathNW, dirtPathNE, dirtPathSW, dirtPathSE;
	
	public static BufferedImage hobbitHole1, hobbitHole2, hobbitHole3;
	public static BufferedImage hedgeTop, hedgeUpAndDown, hedgeSideToSide, hedgeWestCorner, hedgeEastCorner, hedgeLeftCap, hedgeRightCap;
	
	public static BufferedImage bilbo_forward;
	public static BufferedImage[] player_down, player_up;
	public static int playerHeight = 26;
	
	public static BufferedImage bagend;
	public static BufferedImage fenceDown, fenceEnd, fenceLeft;
	public static BufferedImage greenTree;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/hobbitsprite4.png"));
	
		bilbo_forward = sheet.crop(0, (height + 1) * 2, width, playerHeight);
		
		player_down = new BufferedImage[6];
		player_down[0] = sheet.crop((width + 1), (height + 1) * 2, width, playerHeight);
		player_down[1] = sheet.crop((width + 1) * 2, (height + 1) * 2, width, playerHeight);
		player_down[2] = sheet.crop((width + 1) * 3, (height + 1) * 2, width, playerHeight);
		player_down[3] = sheet.crop((width + 1) * 4, (height + 1) * 2, width, playerHeight);
		player_down[4] = sheet.crop((width + 1) * 5, (height + 1) * 2, width, playerHeight);
		player_down[5] = sheet.crop((width + 1) * 6, (height + 1) * 2, width, playerHeight);
		
		player_up = new BufferedImage[6];
		player_up[0] = sheet.crop((width + 1), ((height + 1) * 2) + playerHeight, width, playerHeight);
		player_up[1] = sheet.crop((width + 1) * 2, ((height + 1) * 2) + playerHeight, width, playerHeight);
		player_up[2] = sheet.crop((width + 1) * 3, ((height + 1) * 2) + playerHeight, width, playerHeight);
		player_up[3] = sheet.crop((width + 1) * 4, ((height + 1) * 2) + playerHeight, width, playerHeight);
		player_up[4] = sheet.crop((width + 1) * 5, ((height + 1) * 2) + playerHeight, width, playerHeight);
		player_up[5] = sheet.crop((width + 1) * 6, ((height + 1) * 2) + playerHeight, width, playerHeight);
		
		grass = sheet.crop(0, 0, width, height);
		grassPuff = sheet.crop(width + 1, 0, width, height);
		grassBrownPuff = sheet.crop((width + 1) * 2, 0, width, height);
		grassBrown = sheet.crop((width + 1) * 3, 0, width, height);
		grassLong = sheet.crop((width + 1) * 4, 0, width, height);
		grassPatch = sheet.crop((width + 1) * 5, height + 1, width, height);
		grassWater = sheet.crop((width + 1) * 10, 0, width, height);
		dirtPatch = sheet.crop((width + 1) * 5, 0, width, height);
		brick = sheet.crop(0, height + 1, width, height);
		grassHole = sheet.crop(width + 1, height + 1, width, height);
		pathGreen = sheet.crop((width + 1) * 2, height + 1, width, height);
		pathRed = sheet.crop((width + 1) * 3, height + 1, width, height);
		pathRock = sheet.crop((width + 1) * 4, height + 1, width, height);
		water = sheet.crop((width + 1) * 9, 0, width, height);
		dirtPathUp = sheet.crop((width +1) * 7, (height + 1) * 2, width, height);
		dirtPathDown = sheet.crop((width +1) * 8, (height + 1) * 2, width, height);
		dirtPathLeft = sheet.crop((width +1) * 10, (height + 1) * 2, width, height);
		dirtPathRight = sheet.crop((width +1) * 9, (height + 1) * 2, width, height);
		dirtPathNW = sheet.crop((width +1) * 7, (height + 1) * 3, width, height);
		dirtPathNE = sheet.crop((width +1) * 10, (height + 1) * 3, width, height);
		dirtPathSW = sheet.crop((width +1) * 8, (height + 1) * 3, width, height);
		dirtPathSE = sheet.crop((width +1) * 9, (height + 1) * 3, width, height);
		
		hobbitHole1 = sheet.crop(((width + 1) * 11) + 1, (height * 7) + 1, width * 7, height * 5);
		//hobbitHole2 = sheet.crop((width + 1) * 12, 0, width * 15, height * 7);
		//hobbitHole3 = sheet.crop((width + 1) * 12, 0, width * 15, height * 7);
		
		greenTree = sheet.crop((width + 1) * 7, (height + 1) * 5, (width * 4), (height * 5));
		
		hedgeTop = sheet.crop((width + 1) * 12, (height * 12) + 3, width, height);
		hedgeUpAndDown = sheet.crop((width + 1) * 12, (height * 15) + 3, width, height);
		hedgeSideToSide = sheet.crop((width + 1) * 13, (height * 16) + 4, width, height);
		hedgeWestCorner = sheet.crop((width + 1) * 12, (height * 16) + 4, width, height);
		hedgeEastCorner = sheet.crop((width + 1) * 12, 0, width, height);
		hedgeLeftCap = sheet.crop((width + 1) * 12, 0, width, height);
		hedgeRightCap = sheet.crop((width + 1) * 12, 0, width, height);
		
		startButton = new BufferedImage[2];
		startButton[0] = sheet.crop(0, 170, width * 8, height * 2);
		startButton[1] = sheet.crop(0, 170 + (height * 2) + 1, width * 8, height * 2);
		
		bagend = sheet.crop((width + 1) * 12, 0, width * 15, height * 7);
		fenceDown = sheet.crop((width + 1) * 6, height + 1, width, height);
		fenceEnd = sheet.crop((width +1) * 7, height + 1, width, height);
		fenceLeft = sheet.crop((width +1) * 8, height + 1, width, height);
	}
	
}
