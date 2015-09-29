package my.flying.bunny.moveable;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.generator.World;
import my.flying.bunny.listener.KeyEventListener;
import my.flying.bunny.moveable.Bunny.anim;
import my.javagame.main.Vector2D;

public class BoostBar implements KeyListener{

	
	private Bunny player;
	
	private BufferedImage bar;
	private BufferedImage pin;
	
	private Vector2D pos = new Vector2D(0, 0);
	private Vector2D pinPos = new Vector2D(0,0);
	
	private static float speed = 2f , moveSpeed = speed;
	private static boolean boosted;
	
	private float percent;
	private float boostMultiplier = 0;
	private float minY;
	
	public BoostBar(Bunny player, float xPos, float yPos) {
		this.player = player;
		pos.xPos = xPos; pinPos.xPos = xPos;
		pos.yPos = yPos; pinPos.yPos = yPos;
		
		minY = yPos;
	}
	
	public void init(){
		bar = Assets.getBoostBar_bar();
		pin = Assets.getBoostBar_pin();
		reset();
	}
	
	public void tick(double deltaTime){
		if(pinPos.yPos-minY >= 145){
			speed = -moveSpeed;
		} else if(pinPos.yPos-minY <= 0){
			speed = moveSpeed;
		}
		pinPos.yPos+=speed;
		
		if(pinPos.yPos-minY >= 75){
			percent = (((pinPos.yPos - (minY+75)) / 75) * -100)+100 ;
		} else {
			percent = ((pinPos.yPos - minY) / 75) * 100;
		}
		if(speed == 0 && boostMultiplier == 0){
			boostMultiplier = (percent / 100 )*2;
			player.setSpeed(player.getCanonSpeed()*boostMultiplier);
		}
	//	System.out.println(percent + " ypos" + (pinPos.yPos-200));
	}
	
	public void render(Graphics2D g){
		g.drawImage(bar, (int)pos.xPos, (int)pos.yPos-32, 32, 192, null);
		g.drawImage(pin, (int)pinPos.xPos, (int)pinPos.yPos, 32, 16, null);
	}
	
	public boolean isBoosted(){
		return this.boosted;
	}
	public float getPercent() {
		return percent;
	}
	public void reset() {
		boostMultiplier = 0;
		speed = 2f;
		boosted = false;
		moveSpeed = 2;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(!boosted){
				speed = 0; moveSpeed = 0;
				World.getPlayer().setAnimState(anim.UP);
				boosted = true;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}


}
