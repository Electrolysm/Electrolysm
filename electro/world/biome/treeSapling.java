package assets.electrolysm.electro.world.biome;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class treeSapling extends BlockSapling {

	public treeSapling(int id) {
		super(id);

		this.setUnlocalizedName("treeSapling");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setTickRandomly(true);
		
		GameRegistry.registerBlock(this);
	}
	
    public void updateTick(World world, int x, int y, int z, Random random)
	{
		new WorldGenDiseasedTree(true, 6).generate(world, random, x, y, z);
	}
	
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

}
