package my.flying.bunny.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.javagame.main.Vector2D;

public class Block extends Rectangle {
	
	Vector2D pos = new Vector2D();
	private int blockSize = 32;
	private BlockType blockType;
	private BufferedImage block;
	private boolean isSolid;
	private boolean isLoading = false;
	private boolean dropped = false;
	private String tag;

	public Block(Vector2D pos) {
		setBounds((int)pos.xPos, (int)pos.yPos, blockSize, blockSize);
		this.pos = pos;
	}
	
	public Block(Vector2D pos, BlockType blockType) {
		setBounds((int)pos.xPos, (int)pos.yPos, blockSize, blockSize);
		this.pos = pos;
		this.blockType = blockType;
		
		init();
	}
	
	private void init() {
		switch (blockType) {
		case GROUND_DIRT_01:
			block = Assets.getDirt_01();
			break;
		case GROUND_DIRT_02:
			block = Assets.getDirt_02();
				break;
		case GROUND_GRASS_01:
			block = Assets.getGrass_01();
			break;
		case AIR_01:
			block = Assets.getAir_01();
			break;
		case AIR_02:
			block = Assets.getAir_02();
			break;
		case AIR_03:
			block = Assets.getAir_03();
			break;
		default:
			break;
		}
	}
	
	public Block isSolid(boolean isSolid){
		this.isSolid = isSolid;
		return this;
	}
	
	public Block tag(String tag){
		this.tag = tag;
		return this;
	}

	public void tick(double deltaTime){
		if(isLoading)
			setBounds((int)pos.xPos, (int)pos.yPos, blockSize, blockSize);
	}
	
	public void render(Graphics2D g){
		if(block != null){
			if(isLoading)
				g.drawImage(block,(int)pos.getWorldLocation().xPos, (int)pos.getWorldLocation().yPos, blockSize, blockSize,null);
			
		}
	}
	
	public Vector2D getBlockLocation() {
		return pos;
	}
	
	public enum BlockType{
		GROUND_DIRT_01,GROUND_DIRT_02,GROUND_DIRT_03,
		GROUND_GRASS_01,GROUND_GRASS_02,GROUND_GRASS_03,
		AIR_01, AIR_02, AIR_03, AIR_04, AIR_05,
		SPACE_01, SPACE_02, SPACE_03, SPACE_04
	}
	
	public void setLoading(boolean isLoading) {
		this.isLoading = isLoading;
	}

}
