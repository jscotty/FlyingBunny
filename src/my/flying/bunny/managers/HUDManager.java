package my.flying.bunny.managers;

import java.awt.Graphics2D;

import my.flying.bunny.moveable.BoostBar;
import my.flying.bunny.moveable.Bunny;

public class HUDManager {
	
	private Bunny player;
	private BoostBar boostBar;
	
	public HUDManager(Bunny player) {
		this.player = player;
	}
	
	public void init(){

		boostBar = new BoostBar(player, 700, 200);
		boostBar.init();
	}
	
	public void tick(double deltaTime){
		boostBar.tick(deltaTime);
	}
	
	public void render(Graphics2D g){
		boostBar.render(g);
	}

}
