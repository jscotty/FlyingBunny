package my.flying.bunny.upgrade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.referance.Stats;
import my.flying.bunny.saveload.SaveLoad;
import my.javagame.main.Vector2D;

public class UpgradeSlot extends Rectangle {

	private Vector2D pos = new Vector2D(0,0);
	private int Level;
	private int width =64, height= 64;
	private UpgradeType upgradeType;
	private boolean hoover = false, clicked = false, active = false;
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
		if(upgradeLevel == 0){
			upgradeType.getImage().setCurrentFrame(0);
		} else {
			upgradeType.getImage().setCurrentFrame(upgradeLevel-1);
		}
		if(this.contains(MouseManager.mouse)){
			hoover = true;
			if(MouseManager.pressed){
				clickCount++;
				if(clickCount==1)
					purchase();
				clicked = true;
			} else {
				clickCount = 0;
				clicked = false;
			}
		} else {
			hoover = false;
		}
	}
	
	private void purchase() {
		System.out.println(upgradeType.getImage().getSize());
		if(hasEnaugh()){
			if(upgradeType.getImage().getSize() == upgradeLevel){
				
			} else {
				upgradeType.getImage().nextFrame();
				Stats.coins -= value;
				upgradeLevel++;
				value = (int)(upgradeType.getCost()*(upgradeLevel*upgradeType.getUpgradeScale()))+1;
				SaveLoad.save();
				SaveLoad.saveSlot();
			}
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

		if(upgradeType.getImage().getSize() == upgradeLevel){
			g.setColor(Color.black);
			g.drawString("MAX",(int)pos.xPos+1, (int)(pos.yPos + (height))+1);
			g.setColor(Color.red);
			g.drawString("MAX",(int)pos.xPos, (int)(pos.yPos + (height)));

			g.setColor(Color.black);
			g.drawString("Level: max",(int)pos.xPos+1, (int)(pos.yPos+1 + (height+font.getSize()+3)));
			g.setColor(Color.white);
			g.drawString("Level: max",(int)pos.xPos, (int)(pos.yPos + (height+font.getSize()+3)));
		} else {
			g.setColor(Color.black);
			g.drawString("Cost: " + value,(int)pos.xPos+1, (int)(pos.yPos+1 + (height+font.getSize()+3)));
			g.setColor(Color.white);
			g.drawString("Cost: " + value,(int)pos.xPos, (int)(pos.yPos + (height+font.getSize()+3)));
			g.setColor(Color.black);
			g.drawString("Level: " + upgradeLevel,(int)pos.xPos+1, (int)(pos.yPos+1 + (height+(font.getSize()*2)+3)));
			g.setColor(Color.white);
			g.drawString("Level: " + upgradeLevel,(int)pos.xPos, (int)(pos.yPos + (height+(font.getSize()*2)+3)));
		}
		if(active){
			g.setColor(Color.black);
			g.drawString("Active",(int)pos.xPos+1, (int)(pos.yPos)+font.getSize()+1);
			g.setColor(Color.green);
			g.drawString("Active",(int)pos.xPos, (int)(pos.yPos)+font.getSize());
		}
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
	public void setUpgradeLevel(int upgradeLevel) {
		this.upgradeLevel = upgradeLevel;
		upgradeType.getImage().setCurrentFrame(upgradeLevel);
	}
	public int getUpgradeLevel() {
		return upgradeLevel;
	}
	public boolean isActive(){
		return active;
	}
	public boolean isClicked(){
		return clicked;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public UpgradeType getUpgradeType() {
		return upgradeType;
	}
}
