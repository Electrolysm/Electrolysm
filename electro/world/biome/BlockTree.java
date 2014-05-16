package assets.electrolysm.electro.world.biome;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockTree extends Block {

	public BlockTree(int par1, int thingy, String unlocalName) {
		super(par1, getMaterialFromData(thingy));
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
		GameRegistry.registerBlock(this);
	}

	private static Material getMaterialFromData(int thingy) 
	{
		if(thingy == 0)
		{
			return Material.wood;
		}
		else if(thingy == 1)
		{
			return Material.leaves;
		}
		else
		{
			return null;
		}
	}

}
