package assets.electrolysm.electro.block.machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.crafting.etchingRecipes;

public class etching extends Block {

	public etching(int id, Material mat) {
		super(id, Material.iron);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("etchingMachine");
		this.setHardness(5F);
	}
	
	
    public boolean onBlockActivated(World world, int x, int y, int z, 
    		EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int slotID = player.inventory.currentItem;
		ItemStack heldItem = player.inventory.getCurrentItem();
			
		if(heldItem != null)
		{
			int StackSize = heldItem.stackSize;
			ItemStack result = etchingRecipes.etching().getEtchedResult(heldItem, StackSize);
			System.out.println(result + ":" + heldItem + ":" + slotID);
		
			if(result != null)
			{
				player.inventory.setInventorySlotContents(slotID, result);
				return true;
			}
		}
			return false;
	}

}
