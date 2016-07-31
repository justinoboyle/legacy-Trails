package com.arrayprolc.trails.trails;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import com.arrayprolc.trails.main.Trail;
import com.arrayprolc.trails.util.UtilBlock;

public class TestTrail extends Trail {
	
	public TestTrail(){
		super("Test");
		setIcon(new ItemStack(Material.DIRT));
		setDescription(new String[] { "This is a test trail!", "Nothing to see here." } );
		
	}

	@Override
	public void activate(Location loc) {
		UtilBlock.sendGhostBlock(loc.getBlock().getRelative(BlockFace.DOWN).getLocation(), Material.REDSTONE_ORE, (byte)2);
	}

}
