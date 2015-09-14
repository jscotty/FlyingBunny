package my.flying.bunny.assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.javagame.main.Animator;

public class Animations {
	
	private ArrayList<BufferedImage> listCanon_idle = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> listCanon_shoot = new ArrayList<BufferedImage>();;
	
	private static Animator animCanon_Idle;
	private static Animator animCanon_Shoot;
	
	
	public Animations() {

	}
	public void init(){

		for (int i = 0; i < 3; i++) {
			listCanon_idle.add(Assets.canonSheet.getTile((32*i), 48, 32, 48));
		}
		for (int i = 0; i < 7; i++) {
			listCanon_shoot.add(Assets.canonSheet.getTile((32*i), 0, 32, 48));
		}
		
		animCanon_Shoot = new Animator(listCanon_shoot);
		animCanon_Shoot.setSpeed(50);
		animCanon_Shoot.play();
	
		animCanon_Idle = new Animator(listCanon_idle);
		animCanon_Idle.setSpeed(500);
		animCanon_Idle.play();
		
	}
	
	public static Animator getAnimCanon_Shoot() {
		return animCanon_Shoot;
	}
	
	public static Animator getAnimCanon_Idle() {
		return animCanon_Idle;
	}

}
