package assets.electrolysm.electro.block.machines.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;

public class ContainerWorkBench extends Container
{
	private TileEntityWorkBench entity;

	public ContainerWorkBench(TileEntityWorkBench entity, InventoryPlayer inventory)
	{
		this.entity = entity;

        for (int l = 0; l < 3; ++l)
        {
            for (int i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.entity, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }

        //Research Paper Slot
        this.addSlotToContainer(new SlotResearchNote(this.entity, 10, 124, 60));
        this.addSlotToContainer(new Slot(this.entity, 9, 124, 35));
        
	    int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
            	//full inventory
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

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
	
	 public void onContainerClosed(EntityPlayer player)
	    {
	        InventoryPlayer inventoryplayer = player.inventory;

	        if (inventoryplayer.getItemStack() != null)
	        {
	            player.dropPlayerItem(inventoryplayer.getItemStack());
	            inventoryplayer.setItemStack((ItemStack)null);
	        }
	        if(this.entity.getStackInSlot(9) != null)
	        {
                player.dropPlayerItem(this.entity.getStackInSlot(9));
	        }
	        
	    }
}