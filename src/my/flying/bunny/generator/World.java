package my.flying.bunny.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.flying.bunny.generator.Block.BlockType;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.HUDManager;
import my.flying.bunny.managers.TileManager;
import my.flying.bunny.moveable.Bunny;
import my.flying.bunny.referance.WorldData;
import my.flying.bunny.sprites.Sprites;
import my.flying.bunny.state.LevelLoader;
import my.javagame.main.Vector2D;
import my.javagame.main.loadImageFrom;


public class World {

	public Vector2D worldPos = new Vector2D(0, 0);
	private static Bunny player;
	private HUDManager hud;
	private BufferedImage map;
	private int worldWidth, worldHeight, blockSize = 32;
	private TileManager tiles;
	
	private Block spawn;
	
	private boolean hasSize, generated;
	
	public World(String name, LevelLoader levelLoader, GameStateManager gsm, int level) {
		
	}
	
	public void init(){
		tiles = new TileManager();
		hud = new HUDManager();
		
		player.init(this);
		hud.init();

		worldPos.xPos = spawn.getBlockLocation().xPos - player.getPos().xPos;
		worldPos.yPos = spawn.getBlockLocation().yPos - player.getPos().yPos;

		Vector2D.setWorldVaribles(worldPos.xPos, worldPos.yPos);
	}
	
	public void tick(double deltaTime){
		tiles.tick(deltaTime);
		player.tick(deltaTime);
		hud.tick(deltaTime);


		Vector2D.setWorldVaribles(worldPos.xPos, worldPos.yPos);
	}
	
	public void generate(String worldMapImg){
		map = null;
		if(hasSize){
			try {
				map = loadImageFrom.LoadImageFrom(Sprites.class, worldMapImg);
			} catch (Exception e) {

			}
			
			for (int x = 0; x < worldWidth; x++) {
				for (int y = 0; y < worldHeight; y++) {
					int col = map.getRGB(x, y);
					//int randNum = (int)Math.floor(Math.random()*20);
					switch (col & 0xFFFFFF) {
					case 0x4BA7B7:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_01).isSolid(true));
						break;
					case 0x306C75:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_02).isSolid(true));
						break;
					case 0x5BB54D:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.GROUND_DIRT_01).isSolid(true));
						break;
					
					}
				}
			}
			
			generated = true;
		}
	}
	public void render(Graphics2D g){
		tiles.render(g);
		player.render(g);
		hud.render(g);
	}
	
	public void setSize(int width, int height){
		worldWidth = width; worldHeight = height;
		hasSize = true;
	}
	
	public void addPlayer(Bunny player) {
		World.player = player;
	}
	
	public void setWorldSpawn(){
		int xPos = WorldData.xPos; int yPos = WorldData.yPos;
		if(xPos < worldWidth){
			if(yPos < worldHeight){
				Block spawn = new Block(new Vector2D(xPos*blockSize, yPos*blockSize));
				this.spawn = spawn;
			}
		}
	}
	
	
	public static Bunny getPlayer() {
		return player;
	}
	

}