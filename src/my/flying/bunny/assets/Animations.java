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
	private ArrayList<BufferedImage> list_canon_upgrade = new ArrayList<BufferedImage>();
	
	private ArrayList<BufferedImage> list_bp_01 = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> list_bp_02 = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> list_bp_03 = new ArrayList<BufferedImage>();
	
	private ArrayList<BufferedImage> list_pigeon_alive = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> list_pigeon_death = new ArrayList<BufferedImage>();
	

	private ArrayList<BufferedImage> list_bunny_died = new ArrayList<BufferedImage>();
	
	private static Animator animCanon_Idle;
	private static Animator animCanon_Shoot;

	private static Animator animBunny_idle;
	private static Animator animBunny_up;
	private static Animator animBunny_down;
	

	private static Animator animPigeon_alive;
	private static Animator animPigeon_death;

	private static Animator animJetpack_upgrade;
	private static Animator animFuel_upgrade;
	private static Animator animRocket_upgrade;
	private static Animator animCanon_upgrade;

	private static Animator backPack_fire_01;
	private static Animator backPack_fire_02;
	private static Animator backPack_fire_03;

	private static Animator extremly_bunny_dead;
	
	
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
		for (int i = 0; i < 4; i++) {
			list_rocket_upgrade.add(Assets.itemSheet.getTile((48*i), 32*3, 48, 48));
		}
		for (int i = 0; i < 4; i++) {
			list_canon_upgrade.add(Assets.itemSheet.getTile((64*(i)), 144, 64, 64));
		}
		for (int i = 0; i < 4; i++) {
			list_bp_01.add(Assets.playerSheet.getTile((16*i), 16*11, 16, 16));
		}
		for (int i = 0; i < 4; i++) {
			list_bp_02.add(Assets.playerSheet.getTile((16*i), 16*12, 16, 16));
		}
		for (int i = 0; i < 4; i++) {
			list_bp_03.add(Assets.playerSheet.getTile((16*i), 16*13, 16, 16));
		}
		for (int i = 0; i < 4; i++) {
			list_bunny_died.add(Assets.playerSheet.getTile((32*(i+3)), 0, 32, 32));
		}
		for (int i = 0; i < 2; i++) {
			list_pigeon_alive.add(Assets.props.getTile((16*(i)), 208, 16, 16));
		}
		for (int i = 0; i < 3; i++) {
			list_pigeon_death.add(Assets.props.getTile((16*(i)), 224, 16, 16));
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
		
		animPigeon_alive = new Animator(list_pigeon_alive);
		animPigeon_alive.setSpeed(50);
		animPigeon_alive.play();
		
		animPigeon_death = new Animator(list_pigeon_death);
		
		animJetpack_upgrade  = new Animator(list_jetPack_upgrade);
		animFuel_upgrade  = new Animator(list_fuel_upgrade);
		animRocket_upgrade  = new Animator(list_rocket_upgrade);
		animCanon_upgrade = new Animator(list_canon_upgrade);
		
		backPack_fire_01 = new Animator(list_bp_01);
		backPack_fire_01.setSpeed(30);
		backPack_fire_01.play();
		
		backPack_fire_02 = new Animator(list_bp_02);
		backPack_fire_02.setSpeed(30);
		backPack_fire_02.play();
		
		backPack_fire_03 = new Animator(list_bp_03);
		backPack_fire_03.setSpeed(30);
		backPack_fire_03.play();
		
		extremly_bunny_dead = new Animator(list_bunny_died);
		
		
	}
	
	public static Animator getAnimPigeon_alive() {
		return animPigeon_alive;
	}
	public static Animator getAnimPigeon_death() {
		return animPigeon_death;
	}
	public static Animator getAnimCanon_upgrade() {
		return animCanon_upgrade;
	}
	public static Animator getExtremly_bunny_dead() {
		return extremly_bunny_dead;
	}
	public static Animator getBackPack_fire_01() {
		return backPack_fire_01;
	}
	public static Animator getBackPack_fire_02() {
		return backPack_fire_02;
	}
	public static Animator getBackPack_fire_03() {
		return backPack_fire_03;
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
