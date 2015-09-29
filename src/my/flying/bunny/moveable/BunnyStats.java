package my.flying.bunny.moveable;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.listener.KeyEventListener;

public class BunnyStats {
	
	private Bunny player;
	private float fuel = 90;
	private float fuelSubstract = 0.1f;
	private float yPos = 40;
	
	public static boolean hasFuel;
	
	private int height= (int)fuel;
	
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
			yPos += fuelSubstract;
		}
	}
	
	public void render(Graphics2D g){

		g.setColor(new Color(64,41,40));
		g.fillRect(570, 40, Assets.getFuelBar().getWidth()-40, height);
		g.fillRect(570, (int)yPos, Assets.getFuelBar().getWidth()-40, (int)fuel);
		g.setColor(Color.red);
		g.fillRect(570, (int)yPos, Assets.getFuelBar().getWidth()-40, (int)fuel);
		g.drawImage(Assets.getFuelBar(), 550,10,null);
	}
	

}
