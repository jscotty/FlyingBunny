package my.flying.bunny.main;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;

public class Loading {

	private static boolean loading = false;
	
	public Loading() {
		
	}
	
	public void render(Graphics2D g){
		if(loading){

			g.setColor(Color.red);
			g.fillRect(0, 0, 800, 600);
			g.drawImage(Assets.getLoading(), 0, 0, 800,600,null);
		}
	}
	
	public static void isLoading(){
		loading = true;
	}
	public static void stopLoading(){
		loading = false;
	}

}
