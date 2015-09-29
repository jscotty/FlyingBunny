package my.flying.bunny.main;

import java.awt.Point;

import my.flying.bunny.generator.Block;
import my.flying.bunny.managers.TileManager;
import my.flying.bunny.state.LevelLoader;


public class Check {

	public static boolean collisionPlayer(Point p1, Point p2){
		for(Block block: TileManager.blocks){
			if(block.isSolid()){
				
				if(block.y - p1.y <= 170){
					return true;
				}
				//System.out.println(block.getY() + " py:" +p1.y);
				if(block.contains(p1) || block.contains(p2)){
					return true;
				}
			}
			
		}
		
		return false;
	}
	public static boolean collisionPlayer(Point p1){
		for(Block block: TileManager.blocks){
			
			if(block.isSolid()){
				if(block.contains(p1)){
					return true;
				}
			}
			
		}
		
		return false;
	}

}
