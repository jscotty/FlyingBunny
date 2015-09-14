package my.flying.bunny.canon;

import java.awt.Graphics2D;

import my.flying.bunny.main.Loading;
import my.javagame.main.Animator;
import my.javagame.main.Vector2D;

public class Canon {
	
	private Vector2D pos = new Vector2D(0,0);
	private CanonType canonType;
	
	private Animator animIdle;
	private Animator animShoot;
	
	private int width = 32, height = 48;
	
	private float scale = 2f;
	
	private boolean idle = true,shoot = false;
	
	public Canon(float xPos, float yPos, CanonType canonType) {
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.canonType = canonType;
	}
	
	public void init(){
		animIdle = canonType.getAnimIdle();
		
		animShoot = canonType.getAnimShoot();
		
		width = (int)(width*scale);
		height = (int)(height*scale);

		Loading.stopLoading();
	}
	
	public void tick(double deltaTime){
		
	}
	
	public void render(Graphics2D g){
		if(idle){
			g.drawImage(animIdle.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
				animIdle.update(System.currentTimeMillis());
		} else if(shoot){
			g.drawImage(animShoot.sprite, (int)pos.xPos, (int)pos.yPos, width, height, null);
				animShoot.update(System.currentTimeMillis());
		}
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Vector2D getPos() {
		return pos;
	}

}
