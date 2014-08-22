package electrolysm.electro.sciences.alloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electrolysm.electro.handlers.util.SlotFuel;
import electrolysm.electro.handlers.util.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
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


    //GUI Progress Bar Stuff
    private int lastTime;
    private int lastBurnTime;


    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.timer);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.furnace.burnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastTime != this.furnace.timer)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.timer);
            }

            if (this.lastBurnTime != this.furnace.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, (this.furnace.burnTime));
            }

        }

        this.lastTime = this.furnace.timer;
        this.lastBurnTime = this.furnace.burnTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int value)
    {
        if (id == 0)
        {
            this.furnace.timer = value;
        }

        if(id == 3)
        {
            this.furnace.burnTime = value;
        }
    }
}
