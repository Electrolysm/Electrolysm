package electro.oreProccessing.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electro.research.machines.container.SlotOutput;
import electro.oreProccessing.te.TileEntityLiquidiser;

public class ContainerLiquidiser extends Container
{
    private TileEntityLiquidiser furnace;

    public ContainerLiquidiser(InventoryPlayer inventoryPlayer, TileEntityLiquidiser tileFurnace)
    {
        this.furnace = tileFurnace;
        //																				ACROSS, UP
        this.addSlotToContainer(new Slot(tileFurnace, 0, 80, 13));
        this.addSlotToContainer(new SlotOutput(tileFurnace, 1, 80, 60));

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
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        return null;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        
    }
}