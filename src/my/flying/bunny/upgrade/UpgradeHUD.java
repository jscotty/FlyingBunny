package my.flying.bunny.upgrade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.referance.Stats;

public class UpgradeHUD {

	Font font = new Font("Small Pixel",Font.LAYOUT_LEFT_TO_RIGHT, 60);
	Font f = new Font("Small Pixel",Font.LAYOUT_LEFT_TO_RIGHT, 10);
	
	public UpgradeHUD() {
		
	}
	
	public void init(){
		
	}
	
	public void tick(double deltaTime){
		
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.black);
		g.fillRect(0,0,800,100);

		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("UPGRADE",230,70);
		g.setFont(f);
		g.drawImage(Assets.getCoin(), 700,10,null);
		g.drawString(": " + Stats.coins, 740,30);
	}

}
