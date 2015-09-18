package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;

public class MenuState extends GameState {
	
	GameStateButton startButton;
	GameStateButton quitButton;
	BufferedImage logo;
	BufferedImage bg;
	MouseManager mm;
	
	 
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		logo = Assets.getLogo();
		bg = Assets.getLauncheBG();
		mm = new MouseManager();
		startButton = new GameStateButton((800/2) - (40*3+16), 300,new UpgradeState(gsm),gsm,Assets.getButton_normal(),Assets.getButton_active(),"Start", 40);
		
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);
		startButton.tick();
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(bg, 0,-30,null);
		g.drawImage(logo, 100,50,64*9,64*4,null);
	        
		startButton.render(g);
		
	        
		
	}

}
