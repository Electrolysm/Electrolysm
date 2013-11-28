package assets.electrolysm.electro.powerSystem.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;

public class ContainerTeslaTower extends Container
{
	private TileEntityTeslaTower entity;

	public ContainerTeslaTower(TileEntityTeslaTower entity, InventoryPlayer inventory)
	{
		this.entity = entity;

		this.addSlotToContainer(new Slot(entity, 0, 152, 6)); //top right

	    int var3;

        /*for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
            	//full inventory
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }*/

        for (var3 = 0; var3 < 9; ++var3)
        {
        	//hotbar
            this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return entity.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
        return null;
	}
	
	 public void onContainerClosed(EntityPlayer par1EntityPlayer)
	    {
	        InventoryPlayer inventoryplayer = par1EntityPlayer.inventory;

	        if (inventoryplayer.getItemStack() != null)
	        {
	            par1EntityPlayer.dropPlayerItem(inventoryplayer.getItemStack());
	            inventoryplayer.setItemStack((ItemStack)null);
	        }
	        
	        this.entity.isOpen = false;
	    }
}