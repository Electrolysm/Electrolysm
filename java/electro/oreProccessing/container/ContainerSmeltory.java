package electro.oreProccessing.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electro.research.machines.container.SlotOutput;
import electro.oreProccessing.te.TileEntitySmeltory;

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
    
    //GUI Progress Bar Stuff
    private int lastTime;
    private int lastSmeltTime;
    
    
    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.time);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.smeltTime);
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

            if (this.lastTime != this.furnace.time)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.time);
            }

            if (this.lastSmeltTime != this.furnace.smeltTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.smeltTime);
            }
        }

        this.lastTime = this.furnace.time;
        this.lastSmeltTime = this.furnace.smeltTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.time = par2;
        }

        if (par1 == 1)
        {
            this.furnace.smeltTime = par2;
        }
    }
}