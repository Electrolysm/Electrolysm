package assets.electrolysm.electro.oreProccessing.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import assets.electrolysm.electro.block.machines.container.SlotOutput;
import assets.electrolysm.electro.oreProccessing.te.TileEntitySmeltory;

public class ContainerSmeltory extends Container
{
    private TileEntitySmeltory furnace;

    public ContainerSmeltory(InventoryPlayer inventoryPlayer, TileEntitySmeltory tileFurnace)
    {
        this.furnace = tileFurnace;
        //																				ACROSS, UP
        this.addSlotToContainer(new Slot(tileFurnace, 0, 44, 17 + 18));
        this.addSlotToContainer(new SlotOutput(tileFurnace, 1, 132 + 2 - 18, 35));

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