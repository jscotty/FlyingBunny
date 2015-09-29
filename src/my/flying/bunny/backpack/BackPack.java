package my.flying.bunny.backpack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.generator.World;
import my.flying.bunny.listener.KeyEventListener;
import my.flying.bunny.moveable.Bunny;
import my.flying.bunny.moveable.BunnyStats;
import my.flying.bunny.particle.ParticleSystem;
import my.javagame.main.Vector2D;

public class BackPack {

	private Bunny player;
	private BackPackType type;
	private Vector2D pos = new Vector2D();
	private int width, height;
	private float divide = 0f;
	
	private enum BPType{ROCKET, JET_PACK, NOTHING}
	private BPType bpType = BPType.NOTHING;
	
	private CopyOnWriteArrayList<ParticleSystem> particles = new CopyOnWriteArrayList<ParticleSystem>();
	
	public BackPack(Bunny player,BackPackType type) {
		this.player = player;
		this.type = type;
	}
	
	public void init(){
		player.setMaxSpeed(type.getPower());
		type.getAnim().setCurrentFrame(type.getLevel()-1);
		width = type.getAnim().sprite.getWidth();
		height = type.getAnim().sprite.getHeight();
		
		if(type.getTag() == "jet"){
			bpType = BPType.JET_PACK;
			divide = 1.35f;

			particles.add(new ParticleSystem(new Vector2D(pos.xPos - width/1.4f, pos.yPos), new Vector2D(0, 1), 5, 5, 1, 10, 10, Color.gray, false, true, true, 2));
			particles.add(new ParticleSystem(new Vector2D(pos.xPos - width/5f, pos.yPos), new Vector2D(0, 1), 5, 5, 1, 10, 10, Color.gray, false, true, true, 2));
			
			//particles.add(new ParticleSystem(new Vector2D(pos.xPos - width/1.4f, pos.yPos), new Vector2D(1, 0), 10, 10, 1, 100, 100, Color.orange, true, true, true));
		} else if(type.getTag() == "rocket"){

			particles.add(new ParticleSystem(new Vector2D(pos.xPos - width/1.4f, pos.yPos), new Vector2D(0, 1), 15, 5, 1, 100, 40, Color.gray, false, true, true, 3));
			
			bpType = BPType.ROCKET;
			divide = 1.45f;
		} else if(type.getTag() == "nothing"){
			bpType = BPType.NOTHING;
		}
		
	}
	
	public void tick(double deltaTime){
		pos = player.getPos();
		

		if(particles.size() == 2){
			particles.get(0).setEmitLocation(new Vector2D(pos.xPos - width/1.7f, pos.yPos+10));
			particles.get(1).setEmitLocation(new Vector2D(pos.xPos , pos.yPos+10));
		} else {
			particles.get(0).setEmitLocation(new Vector2D(pos.xPos - 10 , pos.yPos+15));
		}
		for (ParticleSystem particle : particles) {
			particle.tick(deltaTime);
		}
		
	}
	
	public void render(Graphics2D g){

		AffineTransform originalTrans = g.getTransform();
		
		g.rotate(Math.toRadians(player.getRot()),pos.xPos-8,pos.yPos-8);
		
		if(KeyEventListener.up && BunnyStats.hasFuel){
			for (ParticleSystem particle : particles) {
				particle.render(g);
			}
			switch (bpType) {
			case JET_PACK:
				g.drawImage(type.getFlameAnim().sprite, (int)(pos.xPos - width/1.40f), (int)pos.yPos, null);
				g.drawImage(type.getFlameAnim().sprite, (int)(pos.xPos - width/5), (int)pos.yPos, null);
				break;
			case ROCKET:
				g.drawImage(type.getFlameAnim().sprite, (int)(pos.xPos - width/1.43f), (int)(pos.yPos - 8), width, height, null);
				break;
			case NOTHING:
				g.drawImage(type.getFlameAnim().sprite, (int)(pos.xPos - width/2f), (int)(pos.yPos - 2), null);
				break;

			}
			type.getFlameAnim().update(System.currentTimeMillis());
		}
		
		if(type.getTag() != "nothing")
			g.drawImage(type.getAnim().sprite, (int)(pos.xPos - width/divide), (int)pos.yPos - height/2, null);

		g.setTransform(originalTrans);
		
	}

}
