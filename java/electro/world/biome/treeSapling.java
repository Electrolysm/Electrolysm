package electro.world.biome;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class treeSapling extends BlockSapling {

	public treeSapling() {
		super();

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setTickRandomly(true);
	}
	
    public void updateTick(World world, int x, int y, int z, Random random)
	{
		new WorldGenDiseasedTree(true, 6).generate(world, random, x, y, z);
	}
	
	@Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }

}
