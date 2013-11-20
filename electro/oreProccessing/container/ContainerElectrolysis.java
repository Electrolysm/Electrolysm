package assets.electrolysm.electro.oreProccessing.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.block.machines.container.SlotOutput;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;

public class ContainerElectrolysis extends Container
{
	private TileEntityElectrolisisCore entity;
	
	public ContainerElectrolysis(TileEntityElectrolisisCore entity2, InventoryPlayer inventory)
	{
		this.entity = entity2;
		
		this.addSlotToContainer(new Slot(entity2, 0, 11, 17));
		this.addSlotToContainer(new Slot(entity2, 1, 149, 17));
		this.addSlotToContainer(new SlotOutput(entity2, 2, 63, 45));
		this.addSlotToContainer(new SlotOutput(entity2, 3, 97, 45));
		
	    int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return entity.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
		ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack())
		{
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			
			if(index <= 1)
			{
				if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true))
				{
					return null;
				}
				
				slot.onSlotChange(stackInSlot, stack);
			}
			else if(index != 1 && !getSlot(0).getHasStack())
			{
				ItemStack copy = slot.decrStackSize(slot.getStack().stackSize);
				getSlot(0).putStack(copy);
				
				return null;
			}
			else
			{
				return null;
			}
			
			if(stackInSlot.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			return stack;
		}
		
       return stack;
    }

}
