package assets.electrolysm.electro.world.biome;

import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class treeSapling extends BlockSapling {

	public treeSapling(int id) {
		super(id);

		this.setUnlocalizedName("treeSapling");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		
		GameRegistry.registerBlock(this);
	}
	
	public int onBlockPlaced(World world, int x, int y, int z, int par5, float par6, float par7, float par8, int par9)
	{
		new WorldGenDiseasedTree(true, 6).generate(world, new Random(), x, y, z);
		return 0;
	}

}
