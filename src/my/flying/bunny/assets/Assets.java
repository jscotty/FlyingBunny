package my.flying.bunny.assets;

import java.awt.image.BufferedImage;

import my.flying.bunny.sprites.Sprites;
import my.javagame.main.SpriteSheet;
import my.javagame.main.loadImageFrom;

public class Assets {
	
	public static SpriteSheet props = new SpriteSheet();
	public static SpriteSheet tiles = new SpriteSheet();
	SpriteSheet menu = new SpriteSheet();
	SpriteSheet hudsheet = new SpriteSheet();
	SpriteSheet launchesheet = new SpriteSheet();
	public static SpriteSheet itemSheet = new SpriteSheet();
	public static SpriteSheet playerSheet = new SpriteSheet();
	SpriteSheet loadingSheet = new SpriteSheet();
	public static SpriteSheet canonSheet = new SpriteSheet();

	private static BufferedImage dirt_01;
	private static BufferedImage dirt_02;
	
	private static BufferedImage air_01_01;
	private static BufferedImage air_01_02;
	private static BufferedImage air_01_03;
	
	private static BufferedImage air_02_01;
	private static BufferedImage air_02_02;
	private static BufferedImage air_02_03;
	
	private static BufferedImage air_03_01;
	private static BufferedImage air_03_02;
	private static BufferedImage air_03_03;

	private static BufferedImage air_04_01;
	private static BufferedImage air_04_02;
	private static BufferedImage air_04_03;

	private static BufferedImage air_05_01;
	private static BufferedImage air_05_02;
	private static BufferedImage air_05_03;

	private static BufferedImage air_06_01;
	private static BufferedImage air_06_02;
	private static BufferedImage air_06_03;

	private static BufferedImage air_07_01;
	private static BufferedImage air_07_02;
	private static BufferedImage air_07_03;

	private static BufferedImage air_08_01;
	private static BufferedImage air_08_02;
	private static BufferedImage air_08_03;

	private static BufferedImage air_09_01;
	private static BufferedImage air_09_02;
	private static BufferedImage air_09_03;

	private static BufferedImage air_10_01;
	private static BufferedImage air_10_02;
	private static BufferedImage air_10_03;

	private static BufferedImage air_11_01;
	private static BufferedImage air_11_02;
	private static BufferedImage air_11_03;

	private static BufferedImage air_12_01;
	private static BufferedImage air_12_02;
	private static BufferedImage air_12_03;

	private static BufferedImage air_13_01;
	private static BufferedImage air_13_02;
	private static BufferedImage air_13_03;

	private static BufferedImage air_14_01;
	private static BufferedImage air_14_02;
	private static BufferedImage air_14_03;

	private static BufferedImage air_15_01;
	private static BufferedImage air_15_02;
	private static BufferedImage air_15_03;

	private static BufferedImage air_16_01;
	private static BufferedImage air_16_02;
	private static BufferedImage air_16_03;

	private static BufferedImage air_17_01;
	private static BufferedImage air_17_02;
	private static BufferedImage air_17_03;

	private static BufferedImage air_18_01;
	private static BufferedImage air_18_02;
	private static BufferedImage air_18_03;

	private static BufferedImage air_19_01;
	private static BufferedImage air_19_02;
	private static BufferedImage air_19_03;
	
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
	private static BufferedImage menuBG;

	private static BufferedImage boostBar_bar;
	private static BufferedImage boostBar_pin;

	private static BufferedImage pressToBoost;
	private static BufferedImage boostMessageBG;
	
	private static BufferedImage fuelBar;

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
		
		air_01_01 = tiles.getTile(0, 64, 64, 64);
		air_01_02 = tiles.getTile(64, 64, 64, 64);
		air_01_03 = tiles.getTile(64*2, 64, 64, 64);
		
		air_02_01 = tiles.getTile(0, 64*2, 64, 64);
		air_02_02 = tiles.getTile(64, 64*2, 64, 64);
		air_02_03 = tiles.getTile(64*2, 64*2, 64, 64);
		
		air_03_01 = tiles.getTile(0, 64*3, 64, 64);
		air_03_02 = tiles.getTile(64, 64*3, 64, 64);
		air_03_03 = tiles.getTile(64*2, 64*3, 64, 64);
		
		air_04_01 = tiles.getTile(0, 64*4, 64, 64);
		air_04_02 = tiles.getTile(64, 64*4, 64, 64);
		air_04_03 = tiles.getTile(64*2, 64*4, 64, 64);
		
		air_05_01 = tiles.getTile(0, 64*5, 64, 64);
		air_05_02 = tiles.getTile(64, 64*5, 64, 64);
		air_05_03 = tiles.getTile(64*2, 64*5, 64, 64);
		
		air_06_01 = tiles.getTile(0, 64*6, 64, 64);
		air_06_02 = tiles.getTile(64, 64*6, 64, 64);
		air_06_03 = tiles.getTile(64*2, 64*6, 64, 64);
		
		air_07_01 = tiles.getTile(0, 64*7, 64, 64);
		air_07_02 = tiles.getTile(64, 64*7, 64, 64);
		air_07_03 = tiles.getTile(64*2, 64*7, 64, 64);
		
		air_08_01 = tiles.getTile(0, 64*8, 64, 64);
		air_08_02 = tiles.getTile(64, 64*8, 64, 64);
		air_08_03 = tiles.getTile(64*2, 64*8, 64, 64);
		
		air_09_01 = tiles.getTile(0, 64*9, 64, 64);
		air_09_02 = tiles.getTile(64, 64*9, 64, 64);
		air_09_03 = tiles.getTile(64*2, 64*9, 64, 64);
		
		air_10_01 = tiles.getTile(0, 64*10, 64, 64);
		air_10_02 = tiles.getTile(64, 64*10, 64, 64);
		air_10_03 = tiles.getTile(64*2, 64*10, 64, 64);
		
		air_11_01 = tiles.getTile(0, 64*11, 64, 64);
		air_11_02 = tiles.getTile(64, 64*11, 64, 64);
		air_11_03 = tiles.getTile(64*2, 64*11, 64, 64);
		
		air_12_01 = tiles.getTile(0, 64*12, 64, 64);
		air_12_02 = tiles.getTile(64, 64*12, 64, 64);
		air_12_03 = tiles.getTile(64*2, 64*12, 64, 64);
		
		air_13_01 = tiles.getTile(0, 64*13, 64, 64);
		air_13_02 = tiles.getTile(64, 64*13, 64, 64);
		air_13_03 = tiles.getTile(64*2, 64*13, 64, 64);
		
		air_14_01 = tiles.getTile(0, 64*14, 64, 64);
		air_14_02 = tiles.getTile(64, 64*14, 64, 64);
		air_14_03 = tiles.getTile(64*2, 64*14, 64, 64);
		
		air_15_01 = tiles.getTile(0, 64*15, 64, 64);
		air_15_02 = tiles.getTile(64, 64*15, 64, 64);
		air_15_03 = tiles.getTile(64*2, 64*15, 64, 64);
		
		air_16_01 = tiles.getTile(0, 64*16, 64, 64);
		air_16_02 = tiles.getTile(64, 64*16, 64, 64);
		air_16_03 = tiles.getTile(64*2, 64*16, 64, 64);
		
		air_17_01 = tiles.getTile(0, 64*17, 64, 64);
		air_17_02 = tiles.getTile(64, 64*17, 64, 64);
		air_17_03 = tiles.getTile(64*2, 64*17, 64, 64);
		
		air_18_01 = tiles.getTile(0, 64*18, 64, 64);
		air_18_02 = tiles.getTile(64, 64*18, 64, 64);
		air_18_03 = tiles.getTile(64*2, 64*18, 64, 64);
		
		air_19_01 = tiles.getTile(0, 64*19, 64, 64);
		air_19_02 = tiles.getTile(64, 64*19, 64, 64);
		air_19_03 = tiles.getTile(64*2, 64*19, 64, 64);
		
		dirt_01 = tiles.getTile(16*2, 0, 16, 16);
		dirt_02 = tiles.getTile(16*3, 0, 16, 16);
		grass_01 = tiles.getTile(16, 0, 16, 16);

		boostBar_bar = props.getTile(0, 16, 16*2, 16*12);
		boostBar_pin = props.getTile(16*2, 16*3, 16*2, 16);
		pressToBoost = props.getTile(16*2, 16*4, 16*13, 16*2);
		boostMessageBG = props.getTile(16*2, 16*6, 16, 16);
		fuelBar = props.getTile(112, 96, 128, 128);
		
		startButton_normal = menu.getTile(0, 16*4, 16*4, 16*2);
		startButton_active = menu.getTile(16*4, 16*4, 16*4, 16*2);
		menuButton_normal = menu.getTile(0, 16*6, 16*4, 16*2);
		menuButton_active = menu.getTile(16*4, 16*6, 16*4, 16*2);
		button_normal = menu.getTile(0, 16*8, 16*4, 16*2);
		button_active = menu.getTile(16*4, 16*8, 16*4, 16*2);

		bunny = playerSheet.getTile(0, 0, 16*2, 16*2);
		hud = hudsheet.getTile(0, 0, 800, 600);
		hud = hudsheet.getTile(0, 0, 800, 600);

		dynamite = itemSheet.getTile(0, 0, 16*2, 16*2);
		coin = itemSheet.getTile(32, 0, 16*2, 16*2);

		
		loading = loadingSheet.getTile(0, 0, 800, 600);
		hud = hudsheet.getTile(0, 0, 800, 600);

		logo = loadImageFrom.LoadImageFrom(Sprites.class, "logo");
		launcheBG = loadImageFrom.LoadImageFrom(Sprites.class, "launche");
		menuBG = loadImageFrom.LoadImageFrom(Sprites.class, "menuBG");
		
		
	}
	
	public void tick(double deltaTime){
		
	}
	
	public static BufferedImage getFuelBar() {
		return fuelBar;
	}
	public static BufferedImage getMenuBG() {
		return menuBG;
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
	public static BufferedImage getAir_01_01() {
		return air_01_01;
	}
	public static BufferedImage getAir_01_02() {
		return air_01_02;
	}
	public static BufferedImage getAir_01_03() {
		return air_01_03;
	}
	public static BufferedImage getAir_02_01() {
		return air_02_01;
	}
	public static BufferedImage getAir_02_02() {
		return air_02_02;
	}
	public static BufferedImage getAir_02_03() {
		return air_02_03;
	}
	public static BufferedImage getAir_03_01() {
		return air_03_01;
	}
	public static BufferedImage getAir_03_02() {
		return air_03_02;
	}
	public static BufferedImage getAir_03_03() {
		return air_03_03;
	}
	public static BufferedImage getAir_04_01() {
		return air_04_01;
	}
	public static BufferedImage getAir_04_02() {
		return air_04_02;
	}
	public static BufferedImage getAir_04_03() {
		return air_04_03;
	}
	public static BufferedImage getAir_05_01() {
		return air_05_01;
	}
	public static BufferedImage getAir_05_02() {
		return air_05_02;
	}
	public static BufferedImage getAir_05_03() {
		return air_05_03;
	}
	public static BufferedImage getAir_06_01() {
		return air_06_01;
	}
	public static BufferedImage getAir_06_02() {
		return air_06_02;
	}
	public static BufferedImage getAir_06_03() {
		return air_06_03;
	}
	public static BufferedImage getAir_07_01() {
		return air_07_01;
	}
	public static BufferedImage getAir_07_02() {
		return air_07_02;
	}
	public static BufferedImage getAir_07_03() {
		return air_07_03;
	}
	public static BufferedImage getAir_08_01() {
		return air_08_01;
	}
	public static BufferedImage getAir_08_02() {
		return air_08_02;
	}
	public static BufferedImage getAir_08_03() {
		return air_08_03;
	}
	public static BufferedImage getAir_09_01() {
		return air_09_01;
	}
	public static BufferedImage getAir_09_02() {
		return air_09_02;
	}
	public static BufferedImage getAir_09_03() {
		return air_09_03;
	}
	public static BufferedImage getAir_10_01() {
		return air_10_01;
	}
	public static BufferedImage getAir_10_02() {
		return air_10_02;
	}
	public static BufferedImage getAir_10_03() {
		return air_10_03;
	}
	public static BufferedImage getAir_11_01() {
		return air_11_01;
	}
	public static BufferedImage getAir_11_02() {
		return air_11_02;
	}
	public static BufferedImage getAir_11_03() {
		return air_11_03;
	}
	public static BufferedImage getAir_12_01() {
		return air_12_01;
	}
	public static BufferedImage getAir_12_02() {
		return air_12_02;
	}
	public static BufferedImage getAir_12_03() {
		return air_12_03;
	}
	public static BufferedImage getAir_13_01() {
		return air_13_01;
	}
	public static BufferedImage getAir_13_02() {
		return air_13_02;
	}
	public static BufferedImage getAir_13_03() {
		return air_13_03;
	}
	public static BufferedImage getAir_14_01() {
		return air_14_01;
	}
	public static BufferedImage getAir_14_02() {
		return air_14_02;
	}
	public static BufferedImage getAir_14_03() {
		return air_14_03;
	}
	public static BufferedImage getAir_15_01() {
		return air_15_01;
	}
	public static BufferedImage getAir_15_02() {
		return air_15_02;
	}
	public static BufferedImage getAir_15_03() {
		return air_15_03;
	}
	public static BufferedImage getAir_16_01() {
		return air_16_01;
	}
	public static BufferedImage getAir_16_02() {
		return air_16_02;
	}
	public static BufferedImage getAir_16_03() {
		return air_16_03;
	}
	public static BufferedImage getAir_17_01() {
		return air_17_01;
	}
	public static BufferedImage getAir_17_02() {
		return air_17_02;
	}
	public static BufferedImage getAir_17_03() {
		return air_17_03;
	}
	public static BufferedImage getAir_18_01() {
		return air_18_01;
	}
	public static BufferedImage getAir_18_02() {
		return air_18_02;
	}
	public static BufferedImage getAir_18_03() {
		return air_18_03;
	}
	public static BufferedImage getAir_19_01() {
		return air_19_01;
	}
	public static BufferedImage getAir_19_02() {
		return air_19_02;
	}
	public static BufferedImage getAir_19_03() {
		return air_19_03;
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
