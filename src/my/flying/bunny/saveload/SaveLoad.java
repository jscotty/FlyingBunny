package my.flying.bunny.saveload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import my.flying.bunny.referance.Strings;

public class SaveLoad {

	public SaveLoad() {
		
	}
	
	public static void save(){
		try {
			FileOutputStream saveFile = new FileOutputStream(Strings.savePath);
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			//save.writeObject(variable); saveing variable
			
			save.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void load(){
		try {
			FileInputStream saveFile = new FileInputStream("Save.sav");
			
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			//variable = (var) save.readObject(); inputStream will vind the variable and change it.
			
			save.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
