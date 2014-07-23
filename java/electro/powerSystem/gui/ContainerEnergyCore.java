package electro.powerSystem.gui;

import api.powerSystem.SlotBattery;
import api.powerSystem.prefab.TEPowerCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 23/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class ContainerEnergyCore extends Container {

    private TEPowerCore entity;

    public ContainerEnergyCore(TEPowerCore entity, InventoryPlayer inventory)
    {
        this.entity = entity;

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
    private int lastMax;
    private int lastStore;


    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.entity.maxTeU);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.entity.teuData);
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

            if (this.lastMax != this.entity.maxTeU)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.entity.maxTeU);
            }

            if (this.lastStore != this.entity.teuData)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.entity.teuData);
            }
        }

        this.lastMax = this.entity.maxTeU;
        this.lastStore = this.entity.teuData;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.entity.maxTeU = par2;
        }

        if (par1 == 1)
        {
            this.entity.teuData = par2;
        }
    }
}