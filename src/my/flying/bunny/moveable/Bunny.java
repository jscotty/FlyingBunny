package my.flying.bunny.moveable;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.assets.Animations;
import my.flying.bunny.assets.Assets;
import my.flying.bunny.generator.World;
import my.flying.bunny.listener.KeyEventListener;
import my.flying.bunny.main.Check;
import my.flying.bunny.main.Loading;
import my.flying.bunny.main.Main;
import my.flying.bunny.particle.ParticleSystem;
import my.flying.bunny.referance.Stats;
import my.javagame.main.Animator;
import my.javagame.main.Vector2D;

public class Bunny extends Rectangle  {
	
	private Vector2D velocity = new Vector2D(0,1);
	private Vector2D pos = new Vector2D(0, 0);
	private World world;
	private CopyOnWriteArrayList<ParticleSystem> particles = new CopyOnWriteArrayList<ParticleSystem>();
	
	private Animator animIdle;	
	private Animator animUp;	
	private Animator animDown;

	private int renderDistanceWidth = 60;
	private int renderDistanceHeight = 100;
	public static Rectangle render;
	
	public enum anim{UP,DOWN,IDLE}
	private anim animState = anim.IDLE;
	
	private int width = 16, height = 16;
	private double rot = 0;
	private float scale = 2f;
	
	public float speed = 0;
	private float maxSpeed = 1;
	private float canonSpeed = 1;
	int diff, diffY;
	
	private boolean died = false, done = false;
	private int bloodCount = 0;
	
	public Bunny() {
		pos  = new Vector2D((Main.getWidth()/2)  , (Main.getHeight() / 2) - (height / 2) + 235);
	}
	
	public void init(World world){
		this.world = world;
		animIdle = Animations.getAnimBunny_idle();
		animUp = Animations.getAnimBunny_up();
		animDown = Animations.getAnimBunny_down();

		for (ParticleSystem ps : particles) {
			ps.init();
		}
	}
	
	public void tick(double deltaTime){
		Point p1 = new Point((int) pos.xPos, (int)pos.yPos);
		
		diffY = (int)(world.getWorldYPos() + pos.yPos);
		if(diffY >= 49146){
			
		}
		
		for (ParticleSystem ps : particles) {
			ps.tick(deltaTime);
		}

		if(pos.yPos >= 600){
			died = true;
			done = false;
		}
		render = new Rectangle(	(int)(pos.xPos - pos.getWorldLocation().xPos + pos.xPos - renderDistanceWidth*16 + width / 2),
				(int)(pos.yPos - pos.getWorldLocation().yPos + pos.yPos - renderDistanceHeight*16 + height / 2),
				renderDistanceWidth*32,renderDistanceHeight*32);
		if(KeyEventListener.space && !died){
			if(speed >= 0 && KeyEventListener.up){
				move();
				animState = anim.UP;
				velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));
				
				Stats.height += speed;
			} else if(speed == 0){
				velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));
			} else if(speed >= 0 ){
				move();
				movePlayerX();
				animState = anim.UP;
				velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));

				Stats.height += speed;

				if(velocity.xPos >= 0){
					rot +=2;
				} else if(velocity.xPos < 0){
					rot -=2;
				}
				

				if(KeyEventListener.right){
						rot+= 2.5;
				} else if(KeyEventListener.left){
						rot-= 2.5;
				}
				
			} else {
				velocity.yPos = -speed;
					world.moveY(velocity, speed/15);
					pos.yPos-=(velocity.yPos * speed/6);
					
					if(diffY >= 49146){
						done = true;
						died = true;
						world.resetWorld();
						pos.yPos = 405;
					}
				
			}
			
			
			setBounds((int)pos.xPos, (int)pos.yPos, width, height);
			//world.move(velocity, speed);
			
			
			if(KeyEventListener.up && BunnyStats.hasFuel){
				move();
				
				velocity.setAngle((float) ((rot+90) * (Math.PI/180)*-1));
				animState = anim.UP;
				speed += 0.02;
				
				if(speed >= 0){
					movePlayerX();
				} else {
					pos.yPos-=velocity.yPos * speed;
				}
				
				if(velocity.xPos >= 0){
					rot +=2;
				} else if(velocity.xPos < 0){
					rot -=2;
				}
				

				if(KeyEventListener.right){
						rot+= 2.5;
				} else if(KeyEventListener.left){
						rot-= 2.5;
				}
			}

			//System.out.println(velocity.xPos);
			if(!KeyEventListener.up || !BunnyStats.hasFuel){
				done = false;
				 if(speed > 0){
					 move();
					//System.out.println(speed);
					speed -= 0.01f;
				} else if( speed < -3){
					speed = -3;
					animState = anim.DOWN;
				} else if( speed < 0){
					speed -= 0.02f;

					animState = anim.DOWN;
					
					if(velocity.xPos > 0){
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
		} else if(died) {
			world.resetWorldPos();
			if(!done){
				if(pos.yPos <= -550){

				} else {
					pos.yPos -= 15;
				}
			} else {
				if(diffY >= 49146){
					bloodCount++;
					if(bloodCount == 1){
						particles.add(new ParticleSystem(new Vector2D(pos.xPos, pos.yPos - 8), new Vector2D(1,1), width, height, 10000, Animations.getExtremly_bunny_dead(), true, false, false, 32));
						particles.add(new ParticleSystem(new Vector2D(pos.xPos, pos.yPos - 8), new Vector2D(1,1), width, height, 50, 100, 10000, Color.RED, true, false, false));
					}
					if(Stats.height > Stats.highScore){
						Stats.newHighScore();
					}
				} else {
					pos.yPos += 8;
				}
			}
			
			
			
		}
	}
	private void move(){
		if(!done){
			if(pos.yPos > 250){
				movePlayerY();
			} else {
				world.moveY(velocity, speed);
			}
		}
	}
	
	private void movePlayerX() {
		pos.xPos-=velocity.xPos * speed;
	}
	
	private void movePlayerY() {
		pos.yPos+=velocity.yPos * speed;
	}
	
	public void render(Graphics2D g){
		//g.rotate(0.001, pos.xPos, pos.yPos);
		
		AffineTransform originalTrans = g.getTransform();
		if(bloodCount <= 1){
			g.rotate(Math.toRadians(rot),pos.xPos - width/2, pos.yPos - height/2);
			switch (animState) {
			case IDLE:
				g.drawImage(animIdle.sprite,(int)(pos.xPos - width*1.5f),(int)(pos.yPos - height*1.5f),(int)(width*scale),(int)(height*scale),null);
					animIdle.update(System.currentTimeMillis());
				break;
			case UP:
				g.drawImage(animUp.sprite,(int)(pos.xPos - width*1.5f),(int)(pos.yPos - height*1.5f),(int)(width*scale),(int)(height*scale),null);
					animUp.update(System.currentTimeMillis());
				break;
			case DOWN:
				g.drawImage(animDown.sprite,(int)(pos.xPos - width*1.5f),(int)(pos.yPos - height*1.5f),(int)(width*scale),(int)(height*scale),null);
					animDown.update(System.currentTimeMillis());
				break;

			default:
				break;
			}
		}
		g.setTransform(originalTrans);
		
		for (ParticleSystem ps : particles) {
			ps.render(g);
		}
	}
	
	public Vector2D getPos() {
		return pos;
	}
	
	public void done(){
		this.done = true;
	}
	
	public static boolean getUp(){
		return KeyEventListener.up;
	}
	
	public float getMaxSpeed() {
		return maxSpeed;
	}
	public float getCanonSpeed() {
		return canonSpeed;
	}
	public float getSpeed() {
		return speed;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public void setAnimState(anim animState) {
		this.animState = animState;
	}
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getRot() {
		return rot;
	}
	public void setCanonSpeed(float canonSpeed) {
		this.canonSpeed = canonSpeed;
	}
	public boolean hasDied(){
		return died;
	}
	

}
