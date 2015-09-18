package my.flying.bunny.upgrade;

import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

public class Upgrade {
	
	private CopyOnWriteArrayList<UpgradeSlot> slots = new CopyOnWriteArrayList<UpgradeSlot>();
	private UpgradeHUD hud = new UpgradeHUD();
	
	public Upgrade(){
		
	}
	
	public void init(){
		slots.add(new UpgradeSlot(100, 110, UpgradeType.JET_PACK));
		slots.add(new UpgradeSlot(300, 110, UpgradeType.ROCKET));
		slots.add(new UpgradeSlot(100, 210, UpgradeType.FUEL));
		hud.init();
	}
	
	public void tick(double deltaTime){
		for (UpgradeSlot upgradeSlot : slots) {
			upgradeSlot.tick(deltaTime);
		}
		hud.tick(deltaTime);
	}

	public void render(Graphics2D g){
		for (UpgradeSlot upgradeSlot : slots) {
			upgradeSlot.render(g);
		}
		hud.render(g);
	}
	
}
