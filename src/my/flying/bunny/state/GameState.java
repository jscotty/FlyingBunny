package my.flying.bunny.state;

import java.awt.Graphics2D;

import my.flying.bunny.managers.GameStateManager;


public abstract class GameState {

GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}

	public abstract void init();
	public abstract void tick(double deltaTime);
	public abstract void render(Graphics2D g);

}
