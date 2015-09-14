package my.flying.bunny.gameloop;

import my.flying.bunny.assets.Animations;
import my.flying.bunny.assets.Assets;
import my.flying.bunny.main.Loading;
import my.flying.bunny.managers.GameStateManager;
import my.javagame.main.IDGameLoop;

public class GameLoop extends IDGameLoop{

	GameStateManager gsm;
	public static Assets assets = new Assets();
	public static Animations animations;
	Loading loading = new Loading();
	
	public GameLoop(int width, int height) {
		super(width, height);
	}
	@Override
	public void init() {
		gsm = new GameStateManager();
		animations = new Animations();
		
		assets.init();
		gsm.init();
		animations.init();
		
		
		
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
		gsm.tick(deltaTime);
		assets.tick(deltaTime);
	}
	
	@Override
	public void render() {
		gsm.render(graphics2D);
		loading.render(graphics2D);
		clear();
		super.render();
	}
	
	@Override
	public void clear() {
		super.clear();
	}

}
