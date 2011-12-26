import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeDropsProps {
	private static String INIFILE = "plugins/config/TreeDrops/TreeDropsConfig.ini";
	static Logger log = Logger.getLogger("Minecraft");
	static String AppleDropsChance = "0.05";
	static String GoldenAppleDropsChance = "0.02";
	static String CocobeanDropsChance = "0.01";
	static String DropOnLeafDecay = "false";
	static String DropOnLeafDestroy = "true";
	
	public static double getAppleDrops(){
		double AppleDrops = 0.05;
		try{
			AppleDrops = Double.parseDouble(AppleDropsChance);
		}catch (NumberFormatException n){
			log.log(Level.SEVERE, "[TreeDrops] Unable to parse Apple-Drops-Chance, using defaults");
		}
		return AppleDrops;
	}
	
	public static double getGoldenAppleDrops(){
		double GoldenAppleDrops = 0.02;
		try{
			GoldenAppleDrops = Double.parseDouble(GoldenAppleDropsChance);
		}catch (NumberFormatException n){
			log.log(Level.SEVERE, "[TreeDrops] Unable to parse Apple-Drops-Chance, using defaults");
		}
		return GoldenAppleDrops;
	}
	
	public static double getCocobeanDrops(){
		double CocobeanDrops = 0.01;
		try{
			CocobeanDrops = Double.parseDouble(CocobeanDropsChance);
		}catch (NumberFormatException n){
			log.log(Level.SEVERE, "[TreeDrops] Unable to parse Apple-Drops-Chance, using defaults");
		}
		return CocobeanDrops;
	}
	
	public static boolean getUseOnLeafDecay(){
		boolean decay = Boolean.parseBoolean(DropOnLeafDecay);
		return decay;
	}
	
	public static boolean getUseOnLeafDestory(){
		boolean destroy = Boolean.parseBoolean(DropOnLeafDestroy);
		return destroy;
	}
	
	public static void loadIni() {
		File inifile = new File(INIFILE);
		if (inifile.exists()) {
			try {				
				Properties iniSettings = new Properties();
				iniSettings.load(new FileInputStream(inifile));
				AppleDropsChance = iniSettings.getProperty("Apple-Drops-Chance", AppleDropsChance);
				GoldenAppleDropsChance = iniSettings.getProperty("GoldenApple-Drops-Chance", GoldenAppleDropsChance);
				CocobeanDropsChance = iniSettings.getProperty("Cocobean-Drops-Chance", CocobeanDropsChance);
				DropOnLeafDecay = iniSettings.getProperty("DropOnLeafDecay", DropOnLeafDecay);
				DropOnLeafDestroy = iniSettings.getProperty("DropOnLeafDestroy", DropOnLeafDestroy);
			}catch (Exception e) {
				log.log(Level.SEVERE, "[TreeDrops] file load failed, using defaults.");
			}
			createIni();
		}else {
			createIni();
		}
	}
	public static void createIni() {
		File inifile = new File(INIFILE);
		try {
			inifile.getParentFile().mkdirs();
			BufferedWriter outChannel = new BufferedWriter(new FileWriter(inifile));
			outChannel.write("Apple-Drops-Chance = " + AppleDropsChance); outChannel.newLine();
			outChannel.write("GoldenApple-Drops-Chance = " + GoldenAppleDropsChance); outChannel.newLine();
			outChannel.write("Cocobean-Drops-Chance = " + CocobeanDropsChance); outChannel.newLine();
			outChannel.write("DropOnLeafDecay = " + DropOnLeafDecay); outChannel.newLine();
			outChannel.write("DropOnLeafDestroy = " + DropOnLeafDestroy); outChannel.newLine();
			outChannel.close();
		} catch (Exception e) {
			log.log(Level.SEVERE, "[TreeDrops] file creation failed, using defaults.");
		}
	}

}
