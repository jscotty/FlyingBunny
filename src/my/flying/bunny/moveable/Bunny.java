package my.flying.bunny.moveable;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.generator.World;
import my.flying.bunny.main.Main;
import my.javagame.main.Vector2D;

public class Bunny extends Rectangle implements KeyListener  {
	
	private Vector2D pos = new Vector2D(0, 0);
	private World world;
	
	private static boolean up = false, down = false, left = false, right = false;
	
	private int width = 16*2, height = 16*3, rot = 0;
	private float scale = 2f;
	
	public Bunny() {
		pos  = new Vector2D((Main.getWidth() / 2)  , (Main.getHeight() / 2) - (height / 2) + 90);
	}
	
	public void init(World world){
		this.world = world;
	}
	
	public void tick(double deltaTime){
		setBounds((int)pos.xPos, (int)pos.yPos, width, height);
		if(up){

			world.worldPos.yPos-=5;
		} else if(down){
			world.worldPos.yPos+=5;
		} else if(right){
			rot+= 1;
		} else if(left){
			rot-= 1;
		}
	}
	
	public void render(Graphics2D g){
		//g.rotate(0.001, pos.xPos, pos.yPos);
		
		AffineTransform originalTrans = g.getTransform();
		
		g.rotate(Math.toRadians(rot),pos.xPos - width/2, pos.yPos - height/2);
		g.drawImage(Assets.getBunny(),(int)(pos.xPos - width*1.5f),(int)(pos.yPos - height*1.5f),(int)(width*scale),(int)(height*scale),null);
		g.setTransform(originalTrans);
		
	}
	
	public Vector2D getPos() {
		return pos;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = true;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = false;
		} if(e.getKeyCode() == KeyEvent.VK_DOWN){
			down = false;
		} if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = false;
		} if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
