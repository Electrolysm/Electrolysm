package electro.sciences.alloyFurnace;

import electro.research.machines.container.SlotFuel;
import electro.research.machines.container.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 15/07/2014.
 */
public class ContainerAlloyFurnace extends Container
{

    private TileEntityAlloyFurnace furnace;

    public ContainerAlloyFurnace(InventoryPlayer inventoryPlayer, TileEntityAlloyFurnace tileFurnace)
    {
        this.furnace = tileFurnace;
        //																				ACROSS, UP

        this.addSlotToContainer(new Slot(furnace, 0, 62, 44));
        this.addSlotToContainer(new Slot(furnace, 1, 62, 26));
        this.addSlotToContainer(new SlotFuel(furnace, 2, 28, 44));
        this.addSlotToContainer(new SlotOutput(furnace, 3, 132, 35));

        for (int invRow = 0; invRow < 3; ++invRow)
        {
            for (int invCol = 0; invCol < 9; ++invCol)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int actionBar = 0; actionBar < 9; ++actionBar)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, actionBar, 8 + actionBar * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return furnace.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return null;
    }
}
