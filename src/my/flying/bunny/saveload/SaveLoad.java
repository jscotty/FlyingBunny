package my.flying.bunny.saveload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CopyOnWriteArrayList;

import my.flying.bunny.backpack.BackPackType;
import my.flying.bunny.referance.Stats;
import my.flying.bunny.referance.Strings;
import my.flying.bunny.upgrade.UpgradeSlot;
import my.flying.bunny.upgrade.UpgradeType;

public class SaveLoad {

	public static CopyOnWriteArrayList<UpgradeSlot> slots = new CopyOnWriteArrayList<UpgradeSlot>();
	public static BackPackType bpType = BackPackType.NOTNING;
	
	
	public SaveLoad() {
		
	}
	public static void save(){
		
		int coins = Stats.coins;
		int highScore = Stats.highScore;
		float fuel_sub = Stats.fuel_sub;
		
		
		try {
			FileOutputStream saveFile = new FileOutputStream(Strings.savePath);
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			//save.writeObject(variable); saveing variable
			save.writeObject(coins);
			save.writeObject(highScore);
			save.writeObject(fuel_sub);

			save.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveSlot(){
		
		int[] upgradeLevel = new int[slots.size()];
		for (int i = 0; i < slots.size(); i++) {
			upgradeLevel[i] = slots.get(i).getUpgradeLevel();
			System.out.println("uLvl"+i+" "+slots.get(i).getUpgradeLevel());
		}
		
		try {
			FileOutputStream saveFile = new FileOutputStream(Strings.savePath_slot);
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			//save.writeObject(variable); saveing variable
			System.out.println("save ule "+upgradeLevel);
			save.writeObject(upgradeLevel);
			
			save.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void saveJetPack(UpgradeType type, UpgradeSlot slot){
		
		BackPackType bp = BackPackType.NOTNING;
		switch (type) {
		case JET_PACK:
			if(slot.getUpgradeLevel() == 1){
				bp = BackPackType.JET_PACK_LVL01;
			} else if(slot.getUpgradeLevel() == 2){
				bp = BackPackType.JET_PACK_LVL02;
			} else if(slot.getUpgradeLevel() == 3){
				bp = BackPackType.JET_PACK_LVL03;
			}
			break;
		case ROCKET:
			if(slot.getUpgradeLevel() == 1){
				bp = BackPackType.ROCKET_PACK_LVL01;
			} else if(slot.getUpgradeLevel() == 2){
				bp = BackPackType.ROCKET_PACK_LVL02;
			} else if(slot.getUpgradeLevel() == 3){
				bp = BackPackType.ROCKET_PACK_LVL03;
			}
			break;

		default:
			break;
		}
		bpType = bp;
		
		try {
			FileOutputStream saveFile = new FileOutputStream(Strings.savePath_jet);
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			//save.writeObject(variable); saveing variable
			save.writeObject(bp);
			save.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load(){
		
		int coins = 0;
		int highScore = 0;
		try {
			FileInputStream saveFile = new FileInputStream(Strings.savePath);
			
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			//variable = (var) save.readObject(); inputStream will vind the variable and change it.
			coins = (int) save.readObject();
			highScore = (int) save.readObject();

			Stats.coins = coins;
			Stats.highScore = highScore;
			
			
			save.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void loadSlot(){
		int[] upgradeLevel = null;
		System.out.println("load ule "+upgradeLevel);
		try {
			FileInputStream saveFile = new FileInputStream(Strings.savePath_slot);
			
			ObjectInputStream save = new ObjectInputStream(saveFile);

				upgradeLevel = (int[]) save.readObject();
			for (int i = 0; i < upgradeLevel.length; i++) {
				slots.get(i).setUpgradeLevel(upgradeLevel[i]);
				System.out.println("uLvl"+i+" "+slots.get(i).getUpgradeLevel() + "  load");
			}
			
			save.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void loadBP(){
		BackPackType bp = BackPackType.NOTNING;
		try {
			FileInputStream saveFile = new FileInputStream(Strings.savePath_jet);
			
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			//variable = (var) save.readObject(); inputStream will vind the variable and change it.
			bp = (BackPackType) save.readObject();
			
			save.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		bpType = bp;
		System.out.println("e");
		
	}

}
