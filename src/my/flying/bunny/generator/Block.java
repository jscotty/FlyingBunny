package my.flying.bunny.generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.flying.bunny.assets.Assets;
import my.javagame.main.Vector2D;

public class Block extends Rectangle {
	
	Vector2D pos = new Vector2D();
	private int blockSize = 64;
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
		case AIR_01_01:
			block = Assets.getAir_01_01();
			break;
		case AIR_01_02:
			block = Assets.getAir_01_02();
			break;
		case AIR_01_03:
			block = Assets.getAir_01_03();
			break;
		case AIR_02_01:
			block = Assets.getAir_02_01();
			break;
		case AIR_02_02:
			block = Assets.getAir_02_02();
			break;
		case AIR_02_03:
			block = Assets.getAir_02_03();
			break;
		case AIR_03_01:
			block = Assets.getAir_03_01();
			break;
		case AIR_03_02:
			block = Assets.getAir_03_02();
			break;
		case AIR_03_03:
			block = Assets.getAir_03_03();
			break;
		case AIR_04_01:
			block = Assets.getAir_04_01();
			break;
		case AIR_04_02:
			block = Assets.getAir_04_02();
			break;
		case AIR_04_03:
			block = Assets.getAir_04_03();
			break;
		case AIR_05_01:
			block = Assets.getAir_05_01();
			break;
		case AIR_05_02:
			block = Assets.getAir_05_02();
			break;
		case AIR_05_03:
			block = Assets.getAir_05_03();
			break;
		case AIR_06_01:
			block = Assets.getAir_06_01();
			break;
		case AIR_06_02:
			block = Assets.getAir_06_02();
			break;
		case AIR_06_03:
			block = Assets.getAir_06_03();
			break;
		case AIR_07_01:
			block = Assets.getAir_07_01();
			break;
		case AIR_07_02:
			block = Assets.getAir_07_02();
			break;
		case AIR_07_03:
			block = Assets.getAir_07_03();
			break;
		case AIR_08_01:
			block = Assets.getAir_08_01();
			break;
		case AIR_08_02:
			block = Assets.getAir_08_02();
			break;
		case AIR_08_03:
			block = Assets.getAir_08_03();
			break;
		case AIR_09_01:
			block = Assets.getAir_09_01();
			break;
		case AIR_09_02:
			block = Assets.getAir_09_02();
			break;
		case AIR_09_03:
			block = Assets.getAir_09_03();
			break;
		case AIR_10_01:
			block = Assets.getAir_10_01();
			break;
		case AIR_10_02:
			block = Assets.getAir_10_02();
			break;
		case AIR_10_03:
			block = Assets.getAir_10_03();
			break;
		case AIR_11_01:
			block = Assets.getAir_11_01();
			break;
		case AIR_11_02:
			block = Assets.getAir_11_02();
			break;
		case AIR_11_03:
			block = Assets.getAir_11_03();
			break;
		case AIR_12_01:
			block = Assets.getAir_12_01();
			break;
		case AIR_12_02:
			block = Assets.getAir_12_02();
			break;
		case AIR_12_03:
			block = Assets.getAir_12_03();
			break;
		case AIR_13_01:
			block = Assets.getAir_13_01();
			break;
		case AIR_13_02:
			block = Assets.getAir_13_02();
			break;
		case AIR_13_03:
			block = Assets.getAir_13_03();
			break;
		case AIR_14_01:
			block = Assets.getAir_14_01();
			break;
		case AIR_14_02:
			block = Assets.getAir_14_02();
			break;
		case AIR_14_03:
			block = Assets.getAir_14_03();
			break;
		case AIR_15_01:
			block = Assets.getAir_15_01();
			break;
		case AIR_15_02:
			block = Assets.getAir_15_02();
			break;
		case AIR_15_03:
			block = Assets.getAir_15_03();
			break;
		case AIR_16_01:
			block = Assets.getAir_16_01();
			break;
		case AIR_16_02:
			block = Assets.getAir_16_02();
			break;
		case AIR_16_03:
			block = Assets.getAir_16_03();
			break;
		case AIR_17_01:
			block = Assets.getAir_17_01();
			break;
		case AIR_17_02:
			block = Assets.getAir_17_02();
			break;
		case AIR_17_03:
			block = Assets.getAir_17_03();
			break;
		case AIR_18_01:
			block = Assets.getAir_18_01();
			break;
		case AIR_18_02:
			block = Assets.getAir_18_02();
			break;
		case AIR_18_03:
			block = Assets.getAir_18_03();
			break;
		case AIR_19_01:
			block = Assets.getAir_19_01();
			break;
		case AIR_19_02:
			block = Assets.getAir_19_02();
			break;
		case AIR_19_03:
			block = Assets.getAir_19_03();
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
		AIR_01_01,AIR_01_02,AIR_01_03,
		AIR_02_01,AIR_02_02,AIR_02_03,
		AIR_03_01,AIR_03_02,AIR_03_03,
		AIR_04_01,AIR_04_02,AIR_04_03,
		AIR_05_01,AIR_05_02,AIR_05_03,
		AIR_06_01,AIR_06_02,AIR_06_03,
		AIR_07_01,AIR_07_02,AIR_07_03,
		AIR_08_01,AIR_08_02,AIR_08_03,
		AIR_09_01,AIR_09_02,AIR_09_03,
		AIR_10_01,AIR_10_02,AIR_10_03,
		AIR_11_01,AIR_11_02,AIR_11_03,
		AIR_12_01,AIR_12_02,AIR_12_03,
		AIR_13_01,AIR_13_02,AIR_13_03,
		AIR_14_01,AIR_14_02,AIR_14_03,
		AIR_15_01,AIR_15_02,AIR_15_03,
		AIR_16_01,AIR_16_02,AIR_16_03,
		AIR_17_01,AIR_17_02,AIR_17_03,
		AIR_18_01,AIR_18_02,AIR_18_03,
		AIR_19_01,AIR_19_02,AIR_19_03,
		SPACE_01, SPACE_02, SPACE_03, SPACE_04
	}
	
	public void setLoading(boolean isLoading) {
		this.isLoading = isLoading;
	}
	
	public boolean isSolid(){
		return isSolid;
	}
	
	public Vector2D getPos() {
		return pos;
	}

}
