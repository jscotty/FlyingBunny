package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;

public class MenuState extends GameState {
	
	GameStateButton startButton;
	GameStateButton quitButton;
	BufferedImage logo;
	MouseManager mm;

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		logo = Assets.getLogo();
		mm = new MouseManager();
		startButton = new GameStateButton((800/2) - (32*3+16), 300,new LevelLoader(gsm),gsm,Assets.getStartButton_normal(),Assets.getStartButton_active());
		
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);
		startButton.tick();
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(91,181,77));
		g.fillRect(0, 0, 800, 600);
		g.drawImage(logo, 100,50,64*9,64*4,null);
		
		startButton.render(g);
		
	}

}
