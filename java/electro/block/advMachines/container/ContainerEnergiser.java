package electro.block.advMachines.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electro.block.advMachines.te.TileEntityEnergiser;
import electro.block.machines.container.SlotFluidStorage;
import electro.block.machines.container.SlotOutput;
import electro.block.machines.container.Slot_Adv_Machine_Fuel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerEnergiser extends Container
{
    private TileEntityEnergiser furnace;
    private int lastCookTime = 0;
    public int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerEnergiser(InventoryPlayer inventoryPlayer, TileEntityEnergiser tileFurnace)
    {
        this.furnace = tileFurnace;
        //																				ACROSS, UP
        this.addSlotToContainer(new SlotFluidStorage(tileFurnace, TileEntityEnergiser.INGOT_SLOT_2_INDEX, 66, 17));
        this.addSlotToContainer(new Slot(tileFurnace, TileEntityEnergiser.INGOT_SLOT_1_INDEX, 66, 52));
        this.addSlotToContainer(new Slot_Adv_Machine_Fuel(tileFurnace, TileEntityEnergiser.FUEL_INVENTORY_INDEX, 24, 52));
        this.addSlotToContainer(new SlotOutput(tileFurnace, TileEntityEnergiser.OUTPUT_INVENTORY_INDEX, 132, 35));

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
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.furnace.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
            }

            if (this.lastBurnTime != this.furnace.furnaceBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.furnace.furnaceCookTime;
        this.lastBurnTime = this.furnace.furnaceBurnTime;
        this.lastItemBurnTime = this.furnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.furnace.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.furnace.furnaceBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.furnace.currentItemBurnTime = par2;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int par2)
    {
        return null;
    }
}