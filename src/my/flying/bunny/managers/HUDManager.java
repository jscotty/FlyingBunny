package my.flying.bunny.managers;

import java.awt.Color;
import java.awt.Graphics2D;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.extra.FadingImage;
import my.flying.bunny.moveable.BoostBar;
import my.flying.bunny.moveable.Bunny;
import my.flying.bunny.moveable.BunnyStats;
import my.flying.bunny.state.GameStateButton;
import my.flying.bunny.state.LevelLoader;
import my.flying.bunny.state.UpgradeState;

public class HUDManager {
	
	private Bunny player;
	private BunnyStats bunnyStats;
	private BoostBar boostBar;
	private FadingImage pressToBoost;
	private FadingImage boostMessage;
	private GameStateButton menuButton;
	
	public HUDManager(Bunny player) {
		this.player = player;
	}
	
	public void init(){
		boostBar = new BoostBar(player, 740, 300);
		boostBar.init();
		menuButton = new GameStateButton(10, 10, new UpgradeState(LevelLoader.gsm), LevelLoader.gsm, Assets.getButton_normal(), Assets.getButton_active(),"Menu", 20);
		
		bunnyStats = new BunnyStats(player);
		
		pressToBoost = new FadingImage(Assets.getPressToBoost(),500,365,0.02f);
		boostMessage = new FadingImage(Assets.getBoostMessageBG(),600,400,0.02f, 42,42,"Awesome!",Color.WHITE);
	}
	
	public void tick(double deltaTime){
		boostBar.tick(deltaTime);
		
		bunnyStats.tick(deltaTime);
		
		menuButton.tick();
		
		if(!boostBar.isBoosted())
			pressToBoost.tick(deltaTime);
		if(boostBar.isBoosted() && !boostMessage.isFullSize())
			boostMessage.tick(deltaTime);
		
		if(boostBar.getPercent() >= 95f){
			boostMessage.setMessage("PERFECT!");
			boostMessage.setColor(Color.pink);
		} else if(boostBar.getPercent() >= 85f){
			boostMessage.setMessage("AWESOME!");
			boostMessage.setColor(Color.orange);
		} else if(boostBar.getPercent() >= 70f){
			boostMessage.setMessage("GOOD!");
			boostMessage.setColor(Color.YELLOW);
		} else {
			boostMessage.setMessage("Better next time!");
			boostMessage.setColor(Color.red);
		}
	}
	
	public void render(Graphics2D g){
		g.drawImage(Assets.getHud(),0,0,800,600,null);
		boostBar.render(g);
		bunnyStats.render(g);
		
		if(!boostBar.isBoosted())
			pressToBoost.render(g);
		if(boostBar.isBoosted() && !boostMessage.isFullSize())
			boostMessage.render(g);
		
		menuButton.render(g);
		
	}
	
	public BoostBar getBoostBar() {
		return boostBar;
	}

}
