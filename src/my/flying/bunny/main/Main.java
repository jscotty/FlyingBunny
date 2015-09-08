package my.flying.bunny.main;

import my.flying.bunny.gameloop.GameLoop;
import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.moveable.Bunny;
import my.javagame.main.GameWindow;

public class Main {

	private static int width = 800;
	private static int height = 600;
	
	public static void main(String[] args) {
		GameWindow window = new GameWindow("Flying Bunny! :)", width, height);
		
		window.addMouseListener(new MouseManager());
		window.addMouseMotionListener(new MouseManager());
		window.addKeyListener(new Bunny());
		window.add(new GameLoop(width, height));
		window.setVisible(true);
	}

	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}

}
