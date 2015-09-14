package my.flying.bunny.moveable;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.generator.World;
import my.flying.bunny.main.Loading;
import my.flying.bunny.main.Main;
import my.javagame.main.Vector2D;

public class Bunny extends Rectangle implements KeyListener  {
	
	private Vector2D velocity = new Vector2D(0,1);
	private Vector2D pos = new Vector2D(0, 0);
	private World world;

	private int renderDistanceWidth = 28;
	private int renderDistanceHeight = 25;
	public static Rectangle render;
	
	private static boolean up = false, down = false, left = false, right = false, space = false;
	
	private int width = 16*2, height = 16*2, rot = 0;
	private float scale = 2f;
	
	private float speed = 0;
	private float maxSpeed = 3;
	
	public Bunny() {
		pos  = new Vector2D((Main.getWidth() / 2)  , (Main.getHeight() / 2) - (height / 2) + 90);
	}
	
	public void init(World world){
		this.world = world;
		
	}
	
	public void tick(double deltaTime){
		
		render = new Rectangle(	(int)(pos.xPos - pos.getWorldLocation().xPos + pos.xPos - renderDistanceWidth*16 + width / 2),
				(int)(pos.yPos - pos.getWorldLocation().yPos + pos.yPos - renderDistanceHeight*16 + height / 2),
				renderDistanceWidth*32,renderDistanceHeight*32);
		
		
		if(speed >= 0 && up){
			velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));
		} else if(speed == 0){
			velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));
		} else if(speed >= 0){
			
		} else {
			velocity.yPos = -speed;
		}
		
		setBounds((int)pos.xPos, (int)pos.yPos, width, height);
		world.move(velocity, speed);
		
		if(up){
			speed += 0.02;
			if(velocity.xPos >= 0){
				rot ++;
			} else if(velocity.xPos < 0){
				rot --;
			}
		}

		if(right){
			rot+= 2;
		} else if(left){
			rot-= 2;
		}
		if(!up){
			 if(speed > 0){
				//System.out.println(speed);
				speed -= 0.01f;
			} else if( speed < -maxSpeed){
				speed = -maxSpeed;
			} else if( speed < 0){
				speed -= 0.02f;
				
				if(velocity.xPos >= 0.8f || velocity.xPos >= -0.8f){
					rot --;
				} else if(velocity.xPos >= 0){
					rot --;
				} else if(velocity.xPos < 0){
					rot ++;
				}
			}
		} else {
			if( speed > maxSpeed){
				speed = -0.01f;
				if(speed <= maxSpeed){
					speed = maxSpeed;
				}
			} else if(speed > 0){
				//System.out.println(speed);
				speed -= 0.01f;
			}
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
	
	public static boolean getUp(){
		return up;
	}
	
	public float getMaxSpeed() {
		return maxSpeed;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
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
		} if(e.getKeyCode() == KeyEvent.VK_SPACE){
			space = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
