package my.flying.bunny.state;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.main.Loading;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;

public class UpgradeState extends GameState {

	GameStateButton startButton;
	MouseManager mm;
	
	public UpgradeState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		mm = new MouseManager();
		startButton = new GameStateButton(10, 480,new LevelLoader(gsm),gsm,Assets.getStartButton_normal(),Assets.getStartButton_active());
		Loading.stopLoading();
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick(deltaTime);

		startButton.tick();;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(164,233,183));
		g.fillRect(0, 0, 800, 600);
		startButton.render(g);
		
	}

}
