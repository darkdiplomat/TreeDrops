import java.util.Random;

public class TreeDropsListener extends PluginListener {
	public boolean onBlockBreak(Player player, Block block){
		if (TreeDropsProps.getUseOnLeafDestory()){
			if ((block.getType() == 18) && (player.canUseCommand("/drops"))) {
				boolean rperm = false, c2perm = false, cperm = false;
				Plugin Realms = null, C2 = null, Cuboid = null;
				if (etc.getLoader().getPlugin("Realms")!=null){
					if (etc.getLoader().getPlugin("Realms").isEnabled()) {
						rperm = (Boolean)etc.getLoader().callCustomHook("Realms-PermissionCheck", new Object[] {"destroy", player, block});
						Realms = etc.getLoader().getPlugin("Realms");
					}
				}
				if (etc.getLoader().getPlugin("Cuboids2") != null){
					if (etc.getLoader().getPlugin("Cuboids2").isEnabled()){
						c2perm = (Boolean)etc.getLoader().callCustomHook("CuboidAPI", new Object[] {player, block, "CAN_MODIFY"});
						C2 = etc.getLoader().getPlugin("Cuboids2");
					}
				}
				if (etc.getLoader().getPlugin("CuboidPlugin") != null){
					if (etc.getLoader().getPlugin("CuboidPlugin").isEnabled()){
						cperm = (Boolean)etc.getLoader().callCustomHook("CuboidPlugin-PermissionCheck", new Object[] {player, block});
						Cuboid = etc.getLoader().getPlugin("CuboidPlugin");
					}
				}
				if ((rperm) || (c2perm) || (cperm)){
						Drop(block);
				}else if(Realms == null && C2 == null && Cuboid == null){
					Drop(block);
				}
			}
		}
		return false;
	}
	
	public boolean onLeafDecay(Block block){
		if (TreeDropsProps.getUseOnLeafDecay()){
			Drop(block);
		}
		return false;
	}
	
	public void Drop(Block block){
		double drops = Math.random();
		Random rand = new Random();
		double dropAppleChance = TreeDropsProps.getAppleDrops();
		double dropGoldenAppleChance = TreeDropsProps.getGoldenAppleDrops();
		double dropCocobeanChance = TreeDropsProps.getCocobeanDrops();
		int randitem = rand.nextInt(100);
		int randitem2 = rand.nextInt(100);
		if ((drops <= dropAppleChance) && (drops <= dropGoldenAppleChance) && (drops <= dropCocobeanChance)){
			if (randitem <= 10){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 351, 1, 3);
				return;
			}else if (randitem < 20 && randitem > 10){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 322);
				return;
			}else if (randitem >=20){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 260);
				return;
			}
		}else if ((drops <= dropAppleChance) && (drops <= dropGoldenAppleChance) && drops > dropCocobeanChance){
			if (randitem2 < 10){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 322);
				return;
			}else{
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 260);
				return;
			}	
		}else if ((drops <= dropAppleChance && (drops <= dropCocobeanChance) && (drops > dropGoldenAppleChance))){
			if(randitem2 < 10){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 351, 1, 3);
				return;
			}else{
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 260);
				return;
			}
		}else if ((drops <= dropGoldenAppleChance) && (drops <= dropCocobeanChance) && (drops > dropAppleChance)){
			if (randitem2 > 10){
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 322);
				return;
			}else{
				etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 351, 1, 3);
				return;
			}
		}else if ((drops <= dropAppleChance) && (drops > dropGoldenAppleChance) && (drops > dropCocobeanChance)){
			etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 260);
			return;
		}else if ((drops <= dropGoldenAppleChance) && (drops > dropAppleChance) && (drops > dropCocobeanChance)){
			etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 322);
			return;
		}else if ((drops <= dropCocobeanChance) && (drops > dropAppleChance) && (drops > dropGoldenAppleChance)){
			etc.getServer().getWorld(0).dropItem(block.getX(), block.getY(), block.getZ(), 351, 1, 3);
			return;
		}
	}
}