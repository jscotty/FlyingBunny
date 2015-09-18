package my.flying.bunny.assets;

import java.awt.image.BufferedImage;

import my.flying.bunny.sprites.Sprites;
import my.javagame.main.SpriteSheet;
import my.javagame.main.loadImageFrom;

public class Assets {
	
	SpriteSheet props = new SpriteSheet();
	SpriteSheet tiles = new SpriteSheet();
	SpriteSheet menu = new SpriteSheet();
	SpriteSheet hudsheet = new SpriteSheet();
	SpriteSheet launchesheet = new SpriteSheet();
	public static SpriteSheet itemSheet = new SpriteSheet();
	public static SpriteSheet playerSheet = new SpriteSheet();
	SpriteSheet loadingSheet = new SpriteSheet();
	public static SpriteSheet canonSheet = new SpriteSheet();

	private static BufferedImage dirt_01;
	private static BufferedImage dirt_02;
	private static BufferedImage air_01;
	private static BufferedImage air_02;
	private static BufferedImage air_03;
	private static BufferedImage grass_01;
	
	private static BufferedImage startButton_normal;
	private static BufferedImage startButton_active;
	private static BufferedImage menuButton_normal;
	private static BufferedImage menuButton_active;
	private static BufferedImage button_normal;
	private static BufferedImage button_active;

	private static BufferedImage bunny;

	private static BufferedImage dynamite;
	private static BufferedImage coin;
	
	private static BufferedImage logo;
	private static BufferedImage loading;
	
	private static BufferedImage launcheBG;

	private static BufferedImage boostBar_bar;
	private static BufferedImage boostBar_pin;

	private static BufferedImage pressToBoost;
	private static BufferedImage boostMessageBG;

	private static BufferedImage hud;

	public Assets() {

	}

	public void init() {
		props.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "propsheet"));
		tiles.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "tilesheet"));
		menu.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "menusprites"));
		launchesheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "launche"));
		itemSheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "itemsheet"));
		playerSheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "bunnysheet"));
		loadingSheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "loading"));
		canonSheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "canonsheet"));
		hudsheet.setSpriteSheet(loadImageFrom.LoadImageFrom(Sprites.class, "hud"));
		
		air_01 = tiles.getTile(0, 0, 64, 64);
		air_02 = tiles.getTile(64, 0, 64, 64);
		air_03 = tiles.getTile(64*2, 0, 64, 64);
		dirt_01 = tiles.getTile(16*2, 0, 16, 16);
		dirt_02 = tiles.getTile(16*3, 0, 16, 16);
		grass_01 = tiles.getTile(16, 0, 16, 16);

		boostBar_bar = props.getTile(0, 16*3, 16*2, 16*10);
		boostBar_pin = props.getTile(16*2, 16*3, 16*2, 16);
		pressToBoost = props.getTile(16*2, 16*4, 16*13, 16*2);
		boostMessageBG = props.getTile(16*2, 16*6, 16, 16);
		
		startButton_normal = menu.getTile(0, 16*4, 16*4, 16*2);
		startButton_active = menu.getTile(16*4, 16*4, 16*4, 16*2);
		menuButton_normal = menu.getTile(0, 16*6, 16*4, 16*2);
		menuButton_active = menu.getTile(16*4, 16*6, 16*4, 16*2);
		button_normal = menu.getTile(0, 16*8, 16*4, 16*2);
		button_active = menu.getTile(16*4, 16*8, 16*4, 16*2);

		bunny = playerSheet.getTile(0, 0, 16*2, 16*2);

		dynamite = itemSheet.getTile(0, 0, 16*2, 16*2);
		coin = itemSheet.getTile(32, 0, 16*2, 16*2);

		logo = menu.getTile(0, 0, 16*9, 16*4);
		
		loading = loadingSheet.getTile(0, 0, 800, 600);
		hud = hudsheet.getTile(0, 0, 800, 600);
		
		launcheBG = loadImageFrom.LoadImageFrom(Sprites.class, "launche");
		
		
	}
	
	public void tick(double deltaTime){
		
	}
	
	public static BufferedImage getLauncheBG() {
		return launcheBG;
	}
	public static BufferedImage getCoin() {
		return coin;
	}
	public static BufferedImage getDynamite() {
		return dynamite;
	}
	public static BufferedImage getMenuButton_active() {
		return menuButton_active;
	}
	public static BufferedImage getMenuButton_normal() {
		return menuButton_normal;
	}
	public static BufferedImage getButton_active() {
		return button_active;
	}
	public static BufferedImage getButton_normal() {
		return button_normal;
	}
	public static BufferedImage getBoostMessageBG() {
		return boostMessageBG;
	}
	public static BufferedImage getPressToBoost() {
		return pressToBoost;
	}
	public static BufferedImage getHud() {
		return hud;
	}
	public static BufferedImage getBoostBar_bar() {
		return boostBar_bar;
	}
	public static BufferedImage getBoostBar_pin() {
		return boostBar_pin;
	}
	public static BufferedImage getLoading() {
		return loading;
	}
	
	public static BufferedImage getBunny() {
		return bunny;
	}
	public static BufferedImage getAir_01() {
		return air_01;
	}
	public static BufferedImage getAir_02() {
		return air_02;
	}
	public static BufferedImage getAir_03() {
		return air_03;
	}
	public static BufferedImage getDirt_01() {
		return dirt_01;
	}
	public static BufferedImage getDirt_02() {
		return dirt_02;
	}
	public static BufferedImage getGrass_01() {
		return grass_01;
	}
	public static BufferedImage getLogo() {
		return logo;
	}
	public static BufferedImage getStartButton_normal() {
		return startButton_normal;
	}
	public static BufferedImage getStartButton_active() {
		return startButton_active;
	}
}
