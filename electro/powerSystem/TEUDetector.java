package assets.electrolysm.electro.powerSystem;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.api.power.PowerConductor;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.powerSystem.te.TileEntityWire;

public class TEUDetector extends Item {

	public TEUDetector(int id) {
		super(id);

	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.maxStackSize = 1;
	this.setUnlocalizedName("TEUDetector");
	}

	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		PowerConductor wireTE;
		
		if(te instanceof PowerConductor && !player.isSneaking())
		{
			wireTE = (PowerConductor)te;
			FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(wireTE.getHeldTEU(wireTE) + "");
			return true;
		}
		if(te instanceof PowerConductor && player.isSneaking())
		{
			wireTE = (PowerConductor)te;
			wireTE.setTEU(wireTE.getHeldTEU(wireTE) + 10);
		}
		return false;
    }
}
