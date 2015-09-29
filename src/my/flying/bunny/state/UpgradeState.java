package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.main.Loading;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.particle.ParticleSystem;
import my.flying.bunny.upgrade.Upgrade;
import my.javagame.main.Vector2D;

public class UpgradeState extends GameState {

	GameStateButton startButton;
	Upgrade upgrade;
	MouseManager mm;
	private ParticleSystem ps;
	
	private float r=20,g=30,b=28;
	
	private Color color;
	
	
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		ps = new ParticleSystem(new Vector2D(400,300), 1500, 600, 1, 350, false);
		ps.init();
		mm = new MouseManager();
		upgrade = new Upgrade();
		upgrade.init();
		startButton = new GameStateButton(10, 515,new LevelLoader(gsm),gsm,Assets.getButton_normal(),Assets.getButton_active(),"Start", 20);
		Loading.stopLoading();
		

		color = new Color((int)r,(int)g,(int)b);
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);
		ps.tick(deltaTime);
		upgrade.tick(deltaTime);

		startButton.tick();
		
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(0, 0, 800, 600);
		
		ps.render(g);
		upgrade.render(g);
		startButton.render(g);
		
	}

}
