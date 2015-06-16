package com.oswinso.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Game extends BasicGame implements Runnable{

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12 * 9;
	public static final int SCALE = 4;
	public static final String NAME = "Game";
	
	private Animation player;
	
	public static void main(String[] args) {
		try {
            AppGameContainer app = new AppGameContainer(new Game());
            app.setDisplayMode(WIDTH*SCALE, HEIGHT*SCALE, false);
            app.setTargetFrameRate(60);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
	}
	
	public Game() {
		super(NAME);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		player.draw(5,5);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		SpriteSheet sheet = new SpriteSheet("img/player.png", 8, 8);
		player = new Animation();
		player.setAutoUpdate(true);
		for(int frame = 0; frame < 3; frame ++) {
			player.addFrame(sheet.getSprite(frame, 0), 150);
		}
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
	}
	
	public synchronized void start() {
		new Thread(this).start();
	}
	
	public synchronized void stop() {

	}

	@Override
	public void run() {
		
	}

}
