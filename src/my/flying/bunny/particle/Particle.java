package my.flying.bunny.particle;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import my.flying.bunny.main.Check;
import my.flying.bunny.state.LevelLoader;
import my.javagame.main.Animator;
import my.javagame.main.Vector2D;

public class Particle {

	private Vector2D pos = new Vector2D();
	private Vector2D vel = new Vector2D();
	private float angle;
	private float angularVelocity;
	private Color color;
	private BufferedImage image = null;
	private int size;
	private int lifeTime;
	private float lifeFade = 1;
	private boolean gravity, fading;
	
	
	
	public Particle(float xPos, float yPos, Vector2D velocity, float angle, float angularVelocity, Color color, int size, int lifeTime, boolean gravity, boolean fading) {
		this.pos.xPos = xPos;
		this.pos.yPos = yPos;
		this.vel = velocity;
		this.angle = angle;
		this.angularVelocity = angularVelocity;
		this.color = color;
		this.size = size;
		this.lifeTime = lifeTime;
		this.gravity = gravity;
		this.fading = fading;
	}

	public Particle(float xPos, float yPos, Vector2D velocity, float angle, float angularVelocity, BufferedImage image, int size, int lifeTime) {
		this.pos.xPos = xPos;
		this.pos.yPos = yPos;
		this.vel = velocity;
		this.angle = angle;
		this.angularVelocity = angularVelocity;
		this.image = image;
		this.size = size;
		this.lifeTime = lifeTime;
	}

	public Particle(float xPos, float yPos, Vector2D velocity, float angle, float angularVelocity, BufferedImage image, int size, int lifeTime, boolean gravity, boolean fading) {
		this.pos.xPos = xPos;
		this.pos.yPos = yPos;
		this.vel = velocity;
		this.angle = angle;
		this.angularVelocity = angularVelocity;
		this.image = image;
		this.size = size;
		this.lifeTime = lifeTime;
		this.gravity = gravity;
		this.fading = fading;
	}
	
	public void tick(double deltaTime){
		lifeTime--;
		angle += angularVelocity;

		if(gravity){
			float yPos = pos.yPos + LevelLoader.world.getWorldYPos();
			if(yPos >= 49151){
				
			} else {
				vel.yPos += 0.03f;
				pos.xPos += vel.xPos; pos.yPos += vel.yPos;
			}
		} else {
			pos.yPos += vel.yPos;
		}
		if(fading){
			if(lifeFade >= 0.001000){
				lifeFade -= 0.005;
			}
		}
	}
	
	public void render(Graphics2D g){
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, lifeFade));
		if(image != null){
			g.drawImage(image, (int)pos.xPos, (int)pos.yPos - size, size,size,null);
		} else {
			g.setColor(color);
			g.fillRect((int)pos.xPos, (int)pos.yPos - size, size, size);
		}
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
	}
	
	public Vector2D getPos() {
		return pos;
	}
	public Vector2D getVel() {
		return vel;
	}
	public float getAngle() {
		return angle;
	}
	public Color getColor() {
		return color;
	}
	public BufferedImage getImage() {
		return image;
	}
	public int getSize() {
		return size;
	}
	public int getLifeTime() {
		return lifeTime;
	}

}
