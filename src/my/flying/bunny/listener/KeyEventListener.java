package my.flying.bunny.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener {
	
	public static boolean up = false, down = false, space = false, right = false, left = false;
	public KeyEventListener() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = true;
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = true;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true;
		} if(e.getKeyCode() == KeyEvent.VK_SPACE){
			space = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = false;
		} if(e.getKeyCode() == KeyEvent.VK_DOWN){
			down = false;
		} if(e.getKeyCode() == KeyEvent.VK_LEFT){
			left = false;
		} if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false;
		} if(e.getKeyCode() == KeyEvent.VK_SPACE){
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
