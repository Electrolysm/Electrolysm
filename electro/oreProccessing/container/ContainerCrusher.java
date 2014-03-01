package assets.electrolysm.electro.oreProccessing.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.block.machines.container.SlotOutput;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerCrusher extends Container
{
    private TileEntityCrusher furnace;
    private int lastCookTime = 0;
    public int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileFurnace)
    {
        this.furnace = tileFurnace;
        //																				ACROSS, UP
        this.addSlotToContainer(new Slot(tileFurnace, 0, 44, 17 + 18));
        this.addSlotToContainer(new SlotGrinder(tileFurnace, 2, 79, 17 + 18));
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
    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        return null;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        
    }
}