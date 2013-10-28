package assets.electrolysm.electro.powerSystem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.api.power.PowerConductor;

public class TEUDetector extends Item {

	public TEUDetector(int id) {
		super(id);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.maxStackSize = 1;
	this.setUnlocalizedName("TEUDetector");
	}

	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
		PowerConductor te = (PowerConductor)world.getBlockTileEntity(x, y, z);
		
		if(world.getBlockId(x, y,z ) == electrolysmCore.wireGold.blockID)
		{
			te.getHeldTEU();
			System.out.print(te.getHeldTEU());
			return true;
		}
		
		return false;
    }
}
