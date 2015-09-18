package my.flying.bunny.upgrade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.referance.Stats;
import my.javagame.main.Vector2D;

public class UpgradeSlot extends Rectangle {

	private Vector2D pos = new Vector2D(0,0);
	private int Level;
	private int width =64, height= 64;
	private UpgradeType upgradeType;
	private boolean hoover = false;
	private int clickCount = 0;
	private int value;
	private int upgradeLevel = 1;

	private Font font = new Font("Small Pixel", Font.CENTER_BASELINE, 12);
	
	public UpgradeSlot(float xPos, float yPos, UpgradeType upgradeType) {
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.upgradeType = upgradeType;
		
		value = upgradeType.getCost();
	}
	
	public void tick(double deltaTime){
		setBounds((int)pos.xPos, (int)pos.yPos, width, height);
		
		if(this.contains(MouseManager.mouse)){
			hoover = true;
			if(MouseManager.pressed){
				clickCount++;
				if(clickCount==1)
					purchase();
			} else {
				clickCount = 0;
			}
		} else {
			hoover = false;
		}
	}
	
	private void purchase() {
		if(hasEnaugh()){
			upgradeType.getImage().nextFrame();
			Stats.coins -= value;
			upgradeLevel++;
			value = (int)(upgradeType.getCost()*(upgradeLevel*upgradeType.getUpgradeScale()))+1;
		}
		
	}

	public void render(Graphics2D g){
		if(hoover)
			g.setColor(Color.red);
		else {
			if(hasEnaugh()){
				g.setColor(Color.green);
			} else 
				g.setColor(Color.black);
		}
		g.setFont(font);
		g.drawRect((int)pos.xPos, (int)pos.yPos, width, height);
		g.drawImage(upgradeType.getImage().sprite,(int)pos.xPos, (int)pos.yPos, width, height,null);

		g.setColor(Color.black);
		g.drawString("Cost: " + value,(int)pos.xPos, (int)(pos.yPos + (height+font.getSize()+3)));
		g.drawString("Level: " + upgradeLevel,(int)pos.xPos, (int)(pos.yPos + (height+(font.getSize()*2)+3)));
	}
	
	public int getLevel() {
		return Level;
	}
	
	public Vector2D getPos() {
		return pos;
	}
	
	private boolean hasEnaugh(){
		return value<=Stats.coins;
	}

}
