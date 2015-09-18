package my.flying.bunny.upgrade;

import my.flying.bunny.assets.Animations;
import my.javagame.main.Animator;

public enum UpgradeType {
	
	JET_PACK("jet", 6, Animations.getAnimJetpack_upgrade(),5,1.5f, 10),
	ROCKET("jet", 9, Animations.getAnimRocket_upgrade(),8,2f, 30),
	FUEL("fuel", 10, Animations.getAnimFuel_upgrade(),10,0.7f, 5),
	CANON("canon", 12, Animations.getAnimCanon_Idle(),10,1.5f, 10);
	
	private int power;
	private String tag;
	private Animator image;
	private int maxUpgrade;
	private float upgradeScale;
	private int cost;
	
	private UpgradeType(String tag, int power, Animator image, int maxUpgrade, float upgradeScale, int cost){
		this.tag = tag;
		this.power = power;
		this.image = image;
		this.maxUpgrade = maxUpgrade;
		this.upgradeScale = upgradeScale;
		this.cost = cost;
		
		System.out.println(image.sprite);
	}
	
	public String getTag() {
		return tag;
	}
	
	public int getPower() {
		return power;
	}
	
	public Animator getImage() {
		return image;
	}
	
	public int getMaxUpgrade() {
		return maxUpgrade;
	}
	
	public int getCost() {
		return cost;
	}
	public float getUpgradeScale() {
		return upgradeScale;
	}
}
