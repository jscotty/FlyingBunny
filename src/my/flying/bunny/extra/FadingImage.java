package my.flying.bunny.extra;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.javagame.main.Vector2D;

public class FadingImage {

	private Vector2D pos = new Vector2D(0,0);
	private BufferedImage image;
	private float lifeFade = 1f, fadeSpeed;
	private boolean fadeUp = false, fullSize = false;

	private float width, height;
	private float maxWidth, maxHeight;
	private boolean scaling = false;
	private String message;
	
	private float fontSize;
	private Font font = new Font("Small Pixel", Font.BOLD, 1);
	private Color color;
	
	public FadingImage(BufferedImage image, float xPos, float yPos, float fadeSpeed) {
		this.image = image;
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.fadeSpeed = fadeSpeed;
		scaling = false;
	}
	
	public FadingImage(BufferedImage image, float xPos, float yPos, float fadeSpeed, int maxWidth, int maxHeight) {
		this.image = image;
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.fadeSpeed = fadeSpeed;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		scaling = true;
	}
	public FadingImage(BufferedImage image, float xPos, float yPos, float fadeSpeed, int maxWidth, int maxHeight, String message, Color color) {
		this.image = image;
		pos.xPos = xPos;
		pos.yPos = yPos;
		this.fadeSpeed = fadeSpeed;
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
		this.message = message;
		this.color = color;
		scaling = true;
	}
	
	public void tick(double deltaTime){
		if(scaling){
			
			if(width >= maxWidth){
				fullSize = true;
			} else if(width != maxWidth){
				width += fadeSpeed*10;
				fontSize += fadeSpeed*10;
				font = new Font("Small Pixel", Font.BOLD, (int)fontSize);
			}
			if(height >= maxHeight){
				
			} else if(height != maxHeight){
				height+= fadeSpeed*10;
			}
			if(width >= maxWidth && height >= maxHeight){
				fullSize = true;
			}
			if(fadeUp){
				if(lifeFade != 1f){
					lifeFade += fadeSpeed;
				}
				if(lifeFade >= 1f){
					fadeUp = false;
				}
			} else {
				if(lifeFade != 0.000010000){
					lifeFade -= fadeSpeed;
				}
				if(lifeFade <= 0.000010000){
					fadeUp = true;
				}
			}
		} else {
			if(fadeUp){
				if(lifeFade != 1f){
					lifeFade += fadeSpeed;
				}
				if(lifeFade >= 1f){
					fadeUp = false;
				}
			} else {
				if(lifeFade != 0.000010000){
					lifeFade -= fadeSpeed;
				}
				if(lifeFade <= 0.000010000){
					fadeUp = true;
				}
			}
		}
	}
	
	public void render(Graphics2D g){
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, lifeFade));
		
		if(scaling){
			g.setColor(Color.black);
			g.setFont(font);
			g.drawString(message, (int)(pos.xPos - width*4),(int)(pos.yPos - height*2));
			g.setColor(color);
			g.drawString(message, (int)(pos.xPos - width*4)+3,(int)(pos.yPos - height*2)+2);
			g.drawImage(image, (int)(pos.xPos - width/2), (int)(pos.yPos - height/2), (int)width, (int)height, null);
		} else {
			g.drawImage(image, (int)pos.xPos, (int)pos.yPos, null);
		}
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
	}
	
	public boolean isFullSize(){
		return fullSize;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
