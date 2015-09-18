package my.flying.bunny.upgrade;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.referance.Stats;

public class UpgradeHUD {

	public UpgradeHUD() {
		
	}
	
	public void init(){
		
	}
	
	public void tick(double deltaTime){
		
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.white);
		g.fillRect(0,0,800,100);

		g.setColor(Color.black);
		g.drawImage(Assets.getCoin(), 700,10,null);
		g.drawString(": " + Stats.coins, 740,30);
	}

}
