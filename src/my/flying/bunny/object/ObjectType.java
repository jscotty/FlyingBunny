package my.flying.bunny.object;

import my.flying.bunny.assets.Animations;
import my.javagame.main.Animator;

public enum ObjectType {
	
	PIGEON_01(1f, 16, Animations.getAnimPigeon_alive(), Animations.getAnimPigeon_death()),
	PIGEON_02(2f, 32, Animations.getAnimPigeon_alive(), Animations.getAnimPigeon_death());
	
	float power;
	int size;
	Animator anim;
	Animator animDeath;
	
	private ObjectType(float power, int size, Animator anim, Animator animDeath){
		this.power = power;
		this.size = size;
		this.anim = anim;
		this.animDeath = animDeath;
	}
	
	public float getPower() {
		return power;
	}
	public int getSize() {
		return size;
	}
	public Animator getAnim() {
		return anim;
	}
	public Animator getAnimDeath() {
		return animDeath;
	}
}
