package my.flying.bunny.state;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.flying.bunny.main.Loading;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.MouseManager;
import my.javagame.main.Vector2D;

public class GameStateButton extends Rectangle{

	private Vector2D pos = new Vector2D();
	private GameState gameState;
	private GameStateManager gsm;
	private BufferedImage button_normal;
	private BufferedImage button_active;
	
	private int width = 32*3 *2;
	private int height = 32 *2;
	
	private int count = 0;
	
	private boolean hoover;
	
	public GameStateButton(float xPos, float yPos, GameState gameState, GameStateManager gsm, BufferedImage button_normal, BufferedImage button_active) {
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.gameState = gameState;
		this.gsm = gsm;
		this.button_normal = button_normal;
		this.button_active = button_active;
		
		setBounds((int)pos.xPos, (int)pos.yPos, width, height);
	}
	
	public void tick(){
		setBounds((int)pos.xPos, (int)pos.yPos, width, height);
		if(getBounds().contains(new Point(MouseManager.mouse))){
			hoover = true;
		} else
			hoover = false;
		
		if(gameState != null){
			if(hoover){
				if(isPressed()){
					Loading.isLoading();
					
					count++;
					if(count >= 3){
						//clicked function
						hoover = false;
						MouseManager.pressed = false;
						gsm.states.push(gameState);
						gsm.states.peek().init();
					}
					
				}
			}
		}
		
	}
	
	public void render(Graphics2D g){
		if(!hoover){
			g.drawImage(button_normal, (int)pos.xPos, (int)pos.yPos, width, height, null);
		} else {
			g.drawImage(button_active, (int)pos.xPos, (int)pos.yPos, width, height, null);
		}
	}
	
	public boolean isPressed(){
		return MouseManager.pressed;
	}

}
