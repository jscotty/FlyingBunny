package my.flying.bunny.referance;

import java.awt.Graphics2D;

import my.flying.bunny.saveload.SaveLoad;

public class Stats {

	public static int coins = 0;
	public static float fuel_sub = 0.1f;
	
	public static int height;
	public static int highScore;
	
	public Stats(){
		
	}
	
	public static void newHighScore(){
		highScore = height;
		SaveLoad.save();
	}
}
