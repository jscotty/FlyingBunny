package my.flying.bunny.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.canon.Canon;
import my.flying.bunny.canon.CanonType;
import my.flying.bunny.generator.Block.BlockType;
import my.flying.bunny.listener.KeyEventListener;
import my.flying.bunny.managers.GameStateManager;
import my.flying.bunny.managers.HUDManager;
import my.flying.bunny.managers.MouseManager;
import my.flying.bunny.managers.TileManager;
import my.flying.bunny.moveable.Bunny;
import my.flying.bunny.moveable.BunnyStats;
import my.flying.bunny.referance.WorldData;
import my.flying.bunny.sprites.Sprites;
import my.flying.bunny.state.LevelLoader;
import my.javagame.main.Vector2D;
import my.javagame.main.loadImageFrom;


public class World {

	public Vector2D worldPos = new Vector2D(0, 0);
	public Vector2D launchePos = new Vector2D(0, -30);
	private static Bunny player;
	public Canon canon;
	private HUDManager hud;
	private BufferedImage map;
	private int worldWidth, worldHeight, blockSize = 64;
	private TileManager tiles;
	
	private MouseManager mm;
	
	private Block spawn;
	
	private boolean hasSize, generated;
	
	public World(String name, LevelLoader levelLoader, GameStateManager gsm, int level) {
		
	}
	
	public void init(){
		mm = new MouseManager();
		player.init(this);
		tiles = new TileManager();
		hud = new HUDManager(player);
		
		hud.init();

		worldPos.xPos = spawn.getBlockLocation().xPos - player.getPos().xPos;
		worldPos.yPos = spawn.getBlockLocation().yPos - player.getPos().yPos;
		

		canon = new Canon(player.getPos().xPos - 24, player.getPos().yPos - 45, CanonType.STANDARD);
		canon.init();

		resetWorld();
		Vector2D.setWorldVaribles(worldPos.xPos, worldPos.yPos);
		
	}
	
	public void tick(double deltaTime){
		mm.tick(deltaTime);
		player.tick(deltaTime);
		tiles.tick(deltaTime);
		hud.tick(deltaTime);
		canon.tick(deltaTime);

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
					
					int randNum = (int)Math.floor(Math.random()*20);
					switch (col & 0xFFFFFF) {
					case 0x4BA7B7:
						if(randNum >= 15)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_01).isSolid(true));
						else if(randNum >= 8)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_02).isSolid(true));
						else 
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_03).isSolid(true));
						break;
					case 0x306C75:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_03).isSolid(true));
						break;
					case 0x5BB54D:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.GROUND_GRASS_01).isSolid(true));
						break;
					case 0x211308:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.GROUND_DIRT_02).isSolid(true));
						break;
					case 0x72441E:
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
		g.drawImage(Assets.getLauncheBG(), (int)launchePos.xPos,(int)launchePos.yPos,null);
		player.render(g);
		canon.render(g);
		hud.render(g);
	}
	
	public void resetWorld(){
		KeyEventListener.space = false;
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
	public Vector2D getWorldPos() {
		return worldPos;
	}
	public float getWorldXPos(){
		return worldPos.xPos;
	}
	public float getWorldYPos(){
		return worldPos.yPos;
	}
	public boolean isGenerated(){
		return generated;
	}
	
	public void move(Vector2D velocity, float speed){
		if(speed >= 0){
			
			worldPos.xPos-=velocity.xPos * speed;
			canon.getPos().xPos+=velocity.xPos * speed;
			launchePos.xPos-=velocity.xPos * speed;
			
			worldPos.yPos+=velocity.yPos * speed;
			launchePos.yPos-=velocity.yPos * speed;
			canon.getPos().yPos-=velocity.yPos * speed;
		} else {
			worldPos.yPos+=velocity.yPos;
			launchePos.yPos-=velocity.yPos; 
			canon.getPos().yPos-=velocity.yPos;
		}
	}
	
	public void moveY(Vector2D velocity, float speed){

		if(worldPos.yPos >= 49400 || !KeyEventListener.up && !BunnyStats.hasFuel){
			
		} else {
			if(speed >= 0){
				worldPos.yPos+=velocity.yPos * speed;
				launchePos.yPos-=velocity.yPos * speed;
				canon.getPos().yPos-=velocity.yPos * speed;
			} else {
				worldPos.yPos+=velocity.yPos;
				launchePos.yPos-=velocity.yPos;
				canon.getPos().yPos-=velocity.yPos;
			}
		}
	}
	
	public static Bunny getPlayer() {
		return player;
	}
	

}
