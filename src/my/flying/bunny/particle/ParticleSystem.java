package my.flying.bunny.particle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import my.javagame.main.Animator;
import my.javagame.main.Vector2D;

public class ParticleSystem {

	private Vector2D emitLocation = new Vector2D();
	private Vector2D velocity = new Vector2D();
	private Random random = new Random();
	int rangeW = 1800;
	int rangeH = 400;
	int total = 1;
	int size = 4;
	int maxParticles = 200;
	int lifeTime = (int)(Math.random()*180)+220;
	private Color color = Color.white;
	private boolean gravity = false, loop = true, fading = true;
	private Animator anim;
	private boolean sprite;
	
	private CopyOnWriteArrayList<Particle> particles = new CopyOnWriteArrayList<Particle>();
	
	public ParticleSystem(Vector2D location, int rangeW, int rangeH,int total, int maxParticles, boolean gravity) {
		this.emitLocation = location;
		this.rangeW = rangeW;
		this.rangeH = rangeH;
		this.total = total;
		this.maxParticles = maxParticles;
		this.gravity = gravity;
	}
	public ParticleSystem(Vector2D location,Vector2D velocity, int rangeW, int rangeH,int total, int maxParticles, int lifeTime, Color color, boolean gravity, boolean loop, boolean fading) {
		this.emitLocation = location;
		this.velocity = velocity;
		this.rangeW = rangeW;
		this.rangeH = rangeH;
		this.total = total;
		this.maxParticles = maxParticles;
		this.lifeTime = lifeTime;
		this.color = color;
		this.gravity = gravity;
		this.loop = loop;
		this.fading = fading;
	}

	public ParticleSystem(Vector2D location,Vector2D velocity, int rangeW, int rangeH,int total, int maxParticles, int lifeTime, Color color, boolean gravity, boolean loop, boolean fading, int size) {
		this.emitLocation = location;
		this.velocity = velocity;
		this.rangeW = rangeW;
		this.rangeH = rangeH;
		this.total = total;
		this.maxParticles = maxParticles;
		this.lifeTime = lifeTime;
		this.color = color;
		this.gravity = gravity;
		this.loop = loop;
		this.fading = fading;
		this.size = size;
	}
	
	public ParticleSystem(Vector2D location,Vector2D velocity, int rangeW, int rangeH, int lifeTime, Animator anim, boolean gravity, boolean loop, boolean fading, int size) {
		this.emitLocation = location;
		this.velocity = velocity;
		this.rangeW = rangeW;
		this.rangeH = rangeH;
		this.lifeTime = lifeTime;
		this.anim = anim;
		this.gravity = gravity;
		this.loop = loop;
		this.fading = fading;
		this.size = size;
		
		this.maxParticles = anim.getSize();
		sprite = true;
	}
	
	public void init(){
		System.out.println(sprite);
		if(sprite){
			for (int i = 0; i < anim.getSize(); i++) {
				System.out.println(i);
				anim.setCurrentFrame(i);
				particles.add(generateNewParticleImg(anim.sprite, size));
			}
		} else {
			for (int i = 0; i < total; i++) {
				 particles.add(generateNewParticle(size, color,velocity, gravity, fading));
			}
		}
	}
	
	public void tick(double deltaTime){
		if(sprite){
			for (int i = 0; i < anim.getSize(); i++) {
				if(particles.size() >= maxParticles){
					
				} else {
					System.out.println(i);
					anim.setCurrentFrame(i);
					particles.add(generateNewParticleImg(anim.sprite, size));
				}
			}
		} else {
			for (int i = 0; i < total; i++) {
				if(particles.size() >= maxParticles){
					
				} else {
					 particles.add(generateNewParticle(size, color,velocity, gravity,fading));
				}
			 }
		}
		 for (Particle particle : particles) {
			particle.tick(deltaTime);
			if(loop){
				if(particle.getLifeTime() <= 0){
					particles.remove(particle);
				}
			}
		}
	}
	
	public void render(Graphics2D g){
		for (Particle particle : particles) {
			particle.render(g);
		}
	}
	
	public Particle generateNewParticle(int size, Color color, Vector2D velocity, boolean gravity, boolean fading){
		    float xPos = (float) (emitLocation.xPos + ((Math.random()*rangeW))-(rangeW/2));
		    float yPos = (float) (emitLocation.yPos + ((Math.random()*rangeH))-(rangeH/2));
		    float angle = 0;
		    float angularVelocity = 0.1f * (float)(random.nextDouble() * 2 - 1);
		    
		    if(gravity){
			    angle = (float) (Math.random()*0.9f)-90;
		    	velocity = new Vector2D(0,(float) (Math.random()*3));
		    	velocity.setAngle(angle);
		    }
		    return new Particle(xPos, yPos, velocity, angle, angularVelocity, color, size, lifeTime, gravity, fading);
	}
	
	public Particle generateNewParticleImg(BufferedImage img, int size){
		float xPos = (float) (emitLocation.xPos + ((Math.random()*rangeW))-(rangeW/2));
	    float yPos = (float) (emitLocation.yPos + ((Math.random()*rangeH))-(rangeH/2));
	    float angle = 0;
	    float angularVelocity = 0.1f * (float)(random.nextDouble() * 2 - 1);
	    
	    if(gravity){
		    angle = (float) (Math.random()*0.9f)-90;
	    	velocity = new Vector2D(0,(float) (Math.random()*3));
	    	velocity.setAngle(angle);
	    }
	    return new Particle(xPos, yPos, velocity, angle, angularVelocity, img, size, lifeTime, gravity, fading);
	}
	
	public void setEmitLocation(Vector2D emitLocation) {
		this.emitLocation = emitLocation;
	}

}
