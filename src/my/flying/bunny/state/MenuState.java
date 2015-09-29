package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Animations;
import my.flying.bunny.assets.Assets;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.particle.ParticleSystem;
import my.javagame.main.Vector2D;

public class MenuState extends GameState {
	
	GameStateButton startButton;
	GameStateButton quitButton;
	BufferedImage logo;
	BufferedImage bg;
	MouseManager mm;
	ParticleSystem ps;
	ParticleSystem ps2;
	
	 
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		logo = Assets.getLogo();
		bg = Assets.getMenuBG();
		mm = new MouseManager();
		startButton = new GameStateButton((800/2) - (40*3+16), 300,new UpgradeState(gsm),gsm,Assets.getButton_normal(),Assets.getButton_active(),"Start", 40);
		ps = new ParticleSystem(new Vector2D(400,180), 1500, 400, 1, 350, false);
		//ps2 = new ParticleSystem(new Vector2D(400,180), new Vector2D(0,0), 5, 5, 10000, Animations.getExtremly_bunny_dead(), true, false, false, 15);
		ps.init();
		//ps2.init();
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);
		startButton.tick();
		ps.tick(deltaTime);
		//ps2.tick(deltaTime);
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(bg, 0,-30,null);
		//g.setColor(new Color(113,162,152));
		//g.fillRect(0, 0, 800, 400);
		ps.render(g);
		//ps2.render(g);
		g.drawImage(logo, 200,50,null);
	        
		startButton.render(g);
		
	        
		
	}

}
