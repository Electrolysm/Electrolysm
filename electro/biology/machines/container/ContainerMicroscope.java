package mods.Electrolysm.electro.biology.machines.container;

import mods.Electrolysm.electro.basic.machines.container.SlotOutput;
import mods.Electrolysm.electro.basic.machines.entities.tile.TileEntityForge;
import mods.Electrolysm.electro.basic.recipes.ForgeRecipes;
import mods.Electrolysm.electro.biology.entity.TileEntityMicroscope;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMicroscope extends Container
{
	private TileEntityMicroscope entity;
	
	public ContainerMicroscope(TileEntityMicroscope entity, InventoryPlayer inventory)
	{
		this.entity = entity;
		
		this.addSlotToContainer(new Slot(entity, 0, 152, 6));
		this.addSlotToContainer(new Slot(entity, 2, 9, 6));
		this.addSlotToContainer(new SlotOutput(entity, 1, 152, 116));
		
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
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 2)
			{
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}

			else if (par2 != 1 && par2 != 0)
			{
				if (ForgeRecipes.smelting().getDoubleSmeltingResult(itemstack1, itemstack1) != null)
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}

				else if (TileEntityForge.isItemFuel(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}

				else if (par2 >= 3 && par2 < 30)
				{
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}

				else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}

			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}

			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(entityPlayer, itemstack1);
		}

		return itemstack;
	}

}
