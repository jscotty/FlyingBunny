package my.flying.bunny.upgrade;

import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.backpack.BackPackType;
import my.flying.bunny.saveload.SaveLoad;

public class Upgrade {
	
	private static CopyOnWriteArrayList<UpgradeSlot> slots = new CopyOnWriteArrayList<UpgradeSlot>();
	private UpgradeHUD hud = new UpgradeHUD();
	
	public Upgrade(){
		
	}
	
	public void init(){
		resetUpgrade();
		slots.add(new UpgradeSlot(100, 110, UpgradeType.JET_PACK));
		slots.add(new UpgradeSlot(300, 110, UpgradeType.ROCKET));
		slots.add(new UpgradeSlot(100, 210, UpgradeType.FUEL));
		slots.add(new UpgradeSlot(100, 310, UpgradeType.CANON));
		hud.init();
		
		
		
		if(SaveLoad.bpType == BackPackType.NOTNING){
			SaveLoad.saveJetPack(slots.get(0).getUpgradeType(), slots.get(0));
			slots.get(1).setUpgradeLevel(0);
			slots.get(0).setActive(true);
			SaveLoad.slots = slots;
			SaveLoad.saveSlot();
		} else {

			SaveLoad.slots = slots;
		}
		
		SaveLoad.loadSlot();
		SaveLoad.loadBP();
	}
	
	public void tick(double deltaTime){
		for (UpgradeSlot upgradeSlot : slots) {
			upgradeSlot.tick(deltaTime);
			
			if(upgradeSlot.isClicked() && upgradeSlot.getUpgradeType().getTag() == "jet" && upgradeSlot.getUpgradeLevel() != 0){
				for (UpgradeSlot uSlot : slots) {
					if(uSlot.isActive() && uSlot.getUpgradeType().getTag() == "jet"){
						uSlot.setActive(false);
					}
						
				}
				upgradeSlot.setActive(true);
				SaveLoad.saveJetPack(upgradeSlot.getUpgradeType(), upgradeSlot);
			}
			if(upgradeSlot.isClicked() && upgradeSlot.getUpgradeType().getTag() == "fuel"){
				
			}
			
			if(SaveLoad.bpType == BackPackType.JET_PACK_LVL01 || SaveLoad.bpType == BackPackType.JET_PACK_LVL02 || SaveLoad.bpType == BackPackType.JET_PACK_LVL03){
				if(upgradeSlot.getUpgradeType() == UpgradeType.JET_PACK){
					upgradeSlot.setActive(true);
				}
			} else if(SaveLoad.bpType == BackPackType.ROCKET_PACK_LVL01 || SaveLoad.bpType == BackPackType.ROCKET_PACK_LVL02 || SaveLoad.bpType == BackPackType.ROCKET_PACK_LVL03){
				if(upgradeSlot.getUpgradeType() == UpgradeType.ROCKET){
					upgradeSlot.setActive(true);
				}
			}
		}
		hud.tick(deltaTime);
	}

	public void render(Graphics2D g){
		for (UpgradeSlot upgradeSlot : slots) {
			upgradeSlot.render(g);
		}
		hud.render(g);
	}
	
	public void resetUpgrade(){
		if(slots.size() >= 1){
			slots.clear();
		}
	}
	
	public static CopyOnWriteArrayList<UpgradeSlot> getSlots() {
		return slots;
	}
	
}
