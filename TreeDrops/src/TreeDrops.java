import java.util.logging.Logger;

public class TreeDrops extends Plugin{
	String name = "TreeDrops";
	String version = "1.6";
	String author = "Darkdiplomat";
	static Logger log = Logger.getLogger("Minecraft");

  public void initialize(){
    TreeDropsListener listener = new TreeDropsListener();
    etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, listener, this, PluginListener.Priority.MEDIUM);
    etc.getLoader().addListener(PluginLoader.Hook.LEAF_DECAY, listener, this, PluginListener.Priority.MEDIUM);
  }

  public void enable(){
	  TreeDropsProps.loadIni();
	  log.info(name + " version " + version + " by " + author + " is enabled!" );
  }

  public void disable(){
	  log.info(name + " version " + version + " is disabled!");
  }
}