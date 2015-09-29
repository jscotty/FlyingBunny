package my.flying.bunny.backpack;

import my.flying.bunny.assets.Animations;
import my.javagame.main.Animator;

public enum BackPackType {
	NOTNING(Animations.getAnimJetpack_upgrade(),Animations.getBackPack_fire_01(),1,1, "nothing"),
	JET_PACK_LVL01(Animations.getAnimJetpack_upgrade(),Animations.getBackPack_fire_01(),2,1, "jet"),
	JET_PACK_LVL02(Animations.getAnimJetpack_upgrade(),Animations.getBackPack_fire_02(),5,2, "jet"),
	JET_PACK_LVL03(Animations.getAnimJetpack_upgrade(),Animations.getBackPack_fire_03(),8,3, "jet"),
	ROCKET_PACK_LVL01(Animations.getAnimRocket_upgrade(),Animations.getBackPack_fire_01(),4,1, "rocket"),
	ROCKET_PACK_LVL02(Animations.getAnimRocket_upgrade(),Animations.getBackPack_fire_02(),7,2, "rocket"),
	ROCKET_PACK_LVL03(Animations.getAnimRocket_upgrade(),Animations.getBackPack_fire_03(),12,3, "rocket");
	
	private Animator anim;
	private Animator flameAnim;
	private float power;
	private int level;
	private String tag;
	
	private BackPackType(Animator anim, Animator flameAnim, float power, int level, String tag){
		this.anim = anim;
		this.flameAnim = flameAnim;
		this.power = power;
		this.level = level;
		this.tag = tag;
	}
	
	public Animator getAnim() {
		return anim;
	}
	public Animator getFlameAnim() {
		return flameAnim;
	}
	public float getPower() {
		return power;
	}
	public int getLevel() {
		return level;
	}
	public String getTag() {
		return tag;
	}
}
