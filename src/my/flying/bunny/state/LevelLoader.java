package my.flying.bunny.state;

import java.awt.Graphics2D;

import my.flying.bunny.generator.World;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.moveable.Bunny;

public class LevelLoader extends GameState{
	
	public static World world;
	private String worldName;
	private String mapName;
	
	private int level;
	
	
	public static int wSpawnX, wSpawnY;
	
	public LevelLoader(GameStateManager gsm) {
		super(gsm);
	}
	public LevelLoader(GameStateManager gsm, String worldName, String mapName, int level) {
		super(gsm);
		this.worldName = worldName;
		this.mapName = mapName;
		this.level = level;
	}
	
	@Override
	public void init() {
		if(worldName == null){
			worldName = "World";
			mapName = "gamefield";
			
			wSpawnX = 14; wSpawnY = 15;
		}
		
		world = new World(worldName, this, gsm, level);
		world.setSize(50, 800);
		world.setWorldSpawn();
		world.addPlayer(new Bunny());
		world.init();
		world.generate(mapName);
		
	}
	
	@Override
	public void tick(double deltaTime) {
		world.tick(deltaTime);
	}
	
	@Override
	public void render(Graphics2D g) {
		world.render(g);
	}

}
