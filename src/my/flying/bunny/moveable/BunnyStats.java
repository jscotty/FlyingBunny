package my.flying.bunny.moveable;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.listener.KeyEventListener;

public class BunnyStats {
	
	private Bunny player;
	private float fuel = 150;
	private float fuelSubstract = 0.05f;
	
	public static boolean hasFuel;
	
	private int width = (int)fuel, height = 12;
	
	public BunnyStats(Bunny player) {
		this.player = player;
	}
	
	public void tick(double deltaTime){
		if(fuel >= 0){
			hasFuel = true;
		} else if(fuel < 0) {
			fuel = 0;
			hasFuel = false;
		}
		
		if(KeyEventListener.up && KeyEventListener.space){
			fuel-= fuelSubstract;
		}
	}
	
	public void render(Graphics2D g){

		g.setColor(Color.yellow);
		g.fillRect(550, 10, (int)fuel, height);
		g.setColor(Color.black);
		g.drawRect(550, 10, width, height);
	}
	

}
