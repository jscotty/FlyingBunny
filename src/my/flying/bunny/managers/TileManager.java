package my.flying.bunny.managers;

import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.generator.Block;
import my.flying.bunny.generator.World;


public class TileManager {
	public static CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<Block>();
	public static CopyOnWriteArrayList<Block> loadedBlocks = new CopyOnWriteArrayList<Block>();
	
	int count;
	

	public TileManager() {
		
	}

	public void tick(double deltaTime){
		for(Block block:blocks){
			block.tick(deltaTime);
			
		}
		if(!loadedBlocks.isEmpty()){
			//loadedBlocks.clear();
		}
	}
	
	public void render(Graphics2D g){
		for(Block block:blocks){
			block.render(g);
		}
	}
	
	public CopyOnWriteArrayList<Block> getBlocks() {
		return blocks;
	}
	
	public CopyOnWriteArrayList<Block> getLoadedBlocks() {
		return loadedBlocks;
	}

}
