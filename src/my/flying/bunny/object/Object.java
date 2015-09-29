package my.flying.bunny.object;

import java.awt.Graphics2D;

import my.flying.bunny.moveable.Bunny;
import my.javagame.main.Vector2D;

public class Object {

	private Vector2D pos = new Vector2D(0,0);
	private ObjectType type;
	private float speed = 1f;
	private int scale = 1;
	private boolean alive = true;
	private Bunny player;
	
	public Object(float xPos,float yPos,float speed, ObjectType type, Bunny player) {
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.speed = speed;
		this.type = type;
		this.player = player;
		
		if(speed > 0){
			scale = 1;
		} else {
			scale = -1;
		}
	}
	
	public void init(){
		
	}
	
	public void tick(double deltaTime){
		if(pos.xPos<= 0 || pos.xPos>= 700){
			speed = -speed;
			scale = -scale;
		}
		
		if(collisionWithPlayer()){
			alive = false;
			player.speed -= type.getPower();
		}
		
		pos.xPos += speed;
	}
	
	public void render(Graphics2D g){
		if(alive){
			g.drawImage(type.getAnim().sprite, (int)(pos.xPos - type.getSize()/2), (int)(pos.yPos - type.getSize()/2), (int)(type.getSize()*scale), type.getSize(), null);
			type.getAnim().update(System.currentTimeMillis());
		}
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public Vector2D getPos() {
		return pos;
	}
	
	public boolean collisionWithPlayer(){
		float difx = this.pos.xPos - player.getPos().xPos;
		float dify = this.pos.yPos - player.getPos().yPos;
		float dxdy = difx + dify;
		
		return (difx<type.getSize() && difx>-type.getSize() && dify<type.getSize() && dify>-type.getSize());
	}
	
	public ObjectType getType() {
		return type;
	}
	
	public boolean isOutRange(){
		return (pos.yPos > 1000);
	}

}
