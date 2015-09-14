package my.flying.bunny.canon;

import my.flying.bunny.assets.Animations;
import my.javagame.main.Animator;

public enum CanonType {
	STANDARD(Animations.getAnimCanon_Idle(), Animations.getAnimCanon_Shoot()),
	MASSIVE(Animations.getAnimCanon_Idle(), Animations.getAnimCanon_Shoot());
	
	private Animator animIdle;
	private Animator animShoot;
	
	private CanonType(Animator animIdle, Animator animShoot){
		this.animIdle = animIdle;
		this.animShoot = animShoot;
	}
	
	public Animator getAnimIdle() {
		return animIdle;
	}
	public Animator getAnimShoot() {
		return animShoot;
	}
}
