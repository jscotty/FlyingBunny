package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.main.Loading;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.upgrade.Upgrade;

public class UpgradeState extends GameState {

	GameStateButton startButton;
	Upgrade upgrade;
	MouseManager mm;
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		mm = new MouseManager();
		upgrade = new Upgrade();
		upgrade.init();
		startButton = new GameStateButton(10, 515,new LevelLoader(gsm),gsm,Assets.getButton_normal(),Assets.getButton_active(),"Start", 20);
		Loading.stopLoading();
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);
		upgrade.tick(deltaTime);

		startButton.tick();;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(164,133,103));
		g.fillRect(0, 0, 800, 600);

		upgrade.render(g);
		startButton.render(g);
		
	}

}
