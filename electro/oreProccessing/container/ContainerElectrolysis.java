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
		
		this.addSlotToContainer(new Slot(entity2, 0, 9, 27));
		this.addSlotToContainer(new Slot(entity2, 1, 147, 27));
		this.addSlotToContainer(new SlotOutput(entity2, 2, 78, 18));
		
		this.addSlotToContainer(new Slot(entity2, 3, 61, 55));
		this.addSlotToContainer(new Slot(entity2, 4, 95, 55));
		
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
       return null;
    }

}
