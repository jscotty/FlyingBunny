package my.flying.bunny.generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.assets.Assets;
import my.flying.bunny.backpack.BackPack;
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
import my.flying.bunny.saveload.SaveLoad;
import my.flying.bunny.sprites.Sprites;
import my.flying.bunny.state.LevelLoader;
import my.javagame.main.Vector2D;
import my.javagame.main.loadImageFrom;
import my.flying.bunny.object.Object;
import my.flying.bunny.object.ObjectType;
import my.flying.bunny.particle.ParticleSystem;


public class World {

	public Vector2D worldPos = new Vector2D(0, 0);
	public Vector2D launchePos = new Vector2D(0, -30);
	private static Bunny player;
	
	private CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<Object>();
	private CopyOnWriteArrayList<ParticleSystem> particles = new CopyOnWriteArrayList<ParticleSystem>();
	
	public Canon canon;
	private HUDManager hud;
	private BufferedImage map;
	private int worldWidth, worldHeight, blockSize = 63;
	private TileManager tiles;
	
	private BackPack backPack;
	
	private MouseManager mm;
	
	private Block spawn;
	
	private float resetYPos = 48739.0f;
	
	private boolean hasSize, generated;
	
	public World(String name, LevelLoader levelLoader, GameStateManager gsm, int level) {
		
	}
	
	public void init(){
		SaveLoad.load();
		SaveLoad.loadBP();
		mm = new MouseManager();
		player.init(this);
		tiles = new TileManager();
		hud = new HUDManager(player);
		backPack = new BackPack(player, SaveLoad.bpType);
		backPack.init();
		
		for (int i = 0; i < 25; i++) {
			objects.add(new Object((float) (Math.random()*650),(float) (Math.random()*1500 - 1550),(float)(Math.random()*2.5f - 1.5f),ObjectType.PIGEON_01,player));
		}
		
		for (Object object : objects) {
			object.init();
		}
		
		hud.init();

		worldPos.xPos = spawn.getBlockLocation().xPos - player.getPos().xPos;
		worldPos.yPos = spawn.getBlockLocation().yPos - player.getPos().yPos;
		
		resetYPos = worldPos.yPos;

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
		backPack.tick(deltaTime);
		for (Object object : objects) {
			object.tick(deltaTime);
			
			if(!object.isAlive()){
				particles.add(new ParticleSystem(new Vector2D(object.getPos().xPos, object.getPos().yPos - 8), new Vector2D(1,1), 5, 5, 5000, object.getType().getAnimDeath(), true, false, false, 16));
				particles.add(new ParticleSystem(new Vector2D(object.getPos().xPos, object.getPos().yPos - 8), new Vector2D(1,1), 5, 5, 20, 30, 5000, Color.RED, true, false, false));
				objects.add(new Object((float) (Math.random()*650),(float) (Math.random()*900 - 1050),(float)(Math.random()*2.5f - 1.5f),ObjectType.PIGEON_01,player));
				objects.remove(object);
			}
			
			if(object.isOutRange()){
				objects.add(new Object((float) (Math.random()*650),(float) (Math.random()*900 - 1200),(float)(Math.random()*2.5f - 1.5f),ObjectType.PIGEON_01,player));
				objects.remove(object);
				System.out.println("ja");
			}
		}
		
		for (ParticleSystem particle : particles) {
			particle.tick(deltaTime);
		}
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
					int randNum = (int) (Math.random()*20);
					switch (col & 0xFFFFFF) {
					
					case 0x71A298: //1
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_01_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_01_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_01_03).isSolid(false));
					case 0x6D9A93: //2
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_02_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_02_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_02_03).isSolid(false));
						break;
					case 0x69928E: //3
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_03_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_03_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_03_03).isSolid(false));
						break;
					case 0x658988: //4
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_04_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_04_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_04_03).isSolid(false));
						break;
					case 0x618183: //5
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_05_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_05_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_05_03).isSolid(false));
						break;
					case 0x5C797E: //6
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_06_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_06_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_06_03).isSolid(false));
						break;
					case 0x587179: //7
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_07_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_07_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_07_03).isSolid(false));
						break;
					case 0x546873: //8
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_08_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_08_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_08_03).isSolid(false));
						break;
					case 0x50606E: //9
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_09_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_09_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_09_03).isSolid(false));
						break;
					case 0x475160: //10
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_10_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_10_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_10_03).isSolid(false));
						break;
					case 0x3D434F: //11
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_11_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_11_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_11_03).isSolid(false));
						break;
					case 0x383C46: //12
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_12_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_12_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_12_03).isSolid(false));
						break;
					case 0x33353D: //13
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_13_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_13_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_13_03).isSolid(false));
						break;
					case 0x2F2F35: //14
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_14_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_14_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_14_03).isSolid(false));
						break;
					case 0x2A282C: //15
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_15_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_15_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_15_03).isSolid(false));
						break;
					case 0x252123: //16
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_16_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_16_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_16_03).isSolid(false));
						break;
					case 0x201A1B: //17
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_17_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_17_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_17_03).isSolid(false));
						break;
					case 0x1B1312: //18
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_18_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_18_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_18_03).isSolid(false));
						break;
					case 0x1B1307: //19
						if(randNum >= 12)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_19_01).isSolid(false));
						else if(randNum >= 6)
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_19_02).isSolid(false));
						else
							TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.AIR_19_03).isSolid(false));
						break;
						
					case 0x5BB54D:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.GROUND_GRASS_01).isSolid(false));
						break;
					case 0x211308:
						TileManager.blocks.add(new Block(new Vector2D(x*blockSize,y*blockSize),BlockType.GROUND_DIRT_01).isSolid(true));
						break;
					default:
						break;
					
					}
				}
			}
			
			generated = true;
		}
	}
	public void render(Graphics2D g){
		tiles.render(g);
		g.drawImage(Assets.getLauncheBG(), (int)launchePos.xPos ,(int)launchePos.yPos,null);
		backPack.render(g);
		player.render(g);
		canon.render(g);
		for (Object object : objects) {
			object.render(g);
		}
		for (ParticleSystem particle : particles) {
			particle.render(g);
		}
		hud.render(g);
		
	}
	
	public void resetWorld(){
		KeyEventListener.space = false;
		if(tiles.getBlocks() != null)
			tiles.getBlocks().clear();
			
		spawn = null;
		
	}
	public void resetWorldPos(){
		worldPos.yPos += 15;
		launchePos.yPos -= 15;
		for (Object object : objects) {
			object.getPos().yPos -= 15;
		}
		if(worldPos.yPos >= resetYPos+2){
			worldPos.yPos = resetYPos+2;
			launchePos.yPos = -20;
			player.done();
			
			for (Object object : objects) {
				objects.remove(object);
			}
		}
		if(launchePos.yPos <= -20){
		}
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
	
	
	public void moveY(Vector2D velocity, float speed){

		if(worldPos.yPos >= resetYPos+2  && !BunnyStats.hasFuel){
			player.done();
			canon.getPos().yPos = 550;
		} else {
			if(speed >= 0){
				worldPos.yPos+=velocity.yPos * speed;
				launchePos.yPos-=velocity.yPos * speed;
				canon.getPos().yPos-=velocity.yPos * speed;
				
				for (Object object : objects) {
					object.getPos().yPos-=velocity.yPos * speed;
				}
			} else {
				worldPos.yPos+=velocity.yPos;
				launchePos.yPos-=velocity.yPos;
				//canon.getPos().yPos-=velocity.yPos;
				for (Object object : objects) {
					object.getPos().yPos-=velocity.yPos;
				}
			}
		}
		if(launchePos.yPos <= -20){
			launchePos.yPos = -20;
		}
	}
	
	public static Bunny getPlayer() {
		return player;
	}
	

}
