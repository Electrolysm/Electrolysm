package electrolysm.electro.powerSystem.generators.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electrolysm.electro.powerSystem.SlotBattery;
import electrolysm.electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGeneratorAntimatter extends Container
{
    private TileEntityGeneratorAntimatter entity;

    public ContainerGeneratorAntimatter(TileEntityGeneratorAntimatter entity, InventoryPlayer inventory)
    {
        this.entity = entity;

        this.addSlotToContainer(new Slot(entity, 0, 26, 60));
        this.addSlotToContainer(new Slot(entity, 1, 134, 60));
        
        this.addSlotToContainer(new SlotBattery(entity, 2, 15, 15));
        
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                //full inventory
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            //hotbar
            this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        return null;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
    }
    
    //GUI Progress Bar Stuff
    private int lastTime;
    private int lastBurnTime;
    
    
    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.entity.burnTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.entity.time);
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

            if (this.lastTime != this.entity.time)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.entity.time);
            }

            if (this.lastBurnTime != this.entity.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.entity.burnTime);
            }
        }

        this.lastTime = this.entity.time;
        this.lastBurnTime = this.entity.burnTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.entity.time = par2;
        }

        if (par1 == 1)
        {
            this.entity.burnTime = par2;
        }
    }
}