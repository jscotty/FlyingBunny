package my.flying.bunny.assets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.javagame.main.Animator;

public class Animations {
	
	private ArrayList<BufferedImage> listCanon_idle = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> listCanon_shoot = new ArrayList<BufferedImage>();
	
	private ArrayList<BufferedImage> listBunny_idle = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> listBunny_up = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> listBunny_down = new ArrayList<BufferedImage>();
	
	private ArrayList<BufferedImage> list_jetPack_upgrade = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> list_fuel_upgrade = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> list_rocket_upgrade = new ArrayList<BufferedImage>();
	
	private static Animator animCanon_Idle;
	private static Animator animCanon_Shoot;

	private static Animator animBunny_idle;
	private static Animator animBunny_up;
	private static Animator animBunny_down;

	private static Animator animJetpack_upgrade;
	private static Animator animFuel_upgrade;
	private static Animator animRocket_upgrade;
	
	
	public Animations() {

	}
	public void init(){

		for (int i = 0; i < 3; i++) {
			listCanon_idle.add(Assets.canonSheet.getTile((32*i), 48, 32, 48));
		}
		for (int i = 0; i < 7; i++) {
			listCanon_shoot.add(Assets.canonSheet.getTile((32*i), 0, 32, 48));
		}
		for (int i = 0; i < 2; i++) {
			listBunny_idle.add(Assets.playerSheet.getTile((32*i), 0, 32, 32));
		}
		for (int i = 0; i < 2; i++) {
			listBunny_down.add(Assets.playerSheet.getTile((32*i), 32, 32, 32));
		}
		for (int i = 0; i < 2; i++) {
			listBunny_up.add(Assets.playerSheet.getTile((32*i), 64, 32, 32));
		}
		for (int i = 0; i < 3; i++) {
			list_jetPack_upgrade.add(Assets.itemSheet.getTile((32*i), 32, 32, 32));
		}
		for (int i = 0; i < 9; i++) {
			list_fuel_upgrade.add(Assets.itemSheet.getTile((32*i), 32*2, 32, 32));
		}
		for (int i = 0; i < 3; i++) {
			list_rocket_upgrade.add(Assets.itemSheet.getTile((32*i), 32*3, 32, 32));
		}
		
		animCanon_Shoot = new Animator(listCanon_shoot);
		animCanon_Shoot.setSpeed(50);
		animCanon_Shoot.play();
	
		animCanon_Idle = new Animator(listCanon_idle);
		animCanon_Idle.setSpeed(500);
		animCanon_Idle.play();
	
		animBunny_idle = new Animator(listBunny_idle);
		animBunny_idle.setSpeed(150);
		animBunny_idle.play();
	
		animBunny_up = new Animator(listBunny_up);
		animBunny_up.setSpeed(50);
		animBunny_up.play();
	
		animBunny_down = new Animator(listBunny_down);
		animBunny_down.setSpeed(50);
		animBunny_down.play();
		
		animJetpack_upgrade  = new Animator(list_jetPack_upgrade);
		animFuel_upgrade  = new Animator(list_fuel_upgrade);
		animRocket_upgrade  = new Animator(list_rocket_upgrade);
		
	}
	
	public static Animator getAnimRocket_upgrade() {
		return animRocket_upgrade;
	}
	public static Animator getAnimFuel_upgrade() {
		return animFuel_upgrade;
	}
	public static Animator getAnimJetpack_upgrade() {
		return animJetpack_upgrade;
	}
	public static Animator getAnimCanon_Shoot() {
		return animCanon_Shoot;
	}
	
	public static Animator getAnimCanon_Idle() {
		return animCanon_Idle;
	}
	
	public static Animator getAnimBunny_down() {
		return animBunny_down;
	}
	public static Animator getAnimBunny_idle() {
		return animBunny_idle;
	}
	public static Animator getAnimBunny_up() {
		return animBunny_up;
	}

}
