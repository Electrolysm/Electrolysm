package electro.powerSystem.tesla.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.powerSystem.tesla.te.TileEntityTeslaCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Clarky158 on 02/09/2014.
 */
public class ContainerTeslaTower extends Container{

    public TileEntity entity;
    public ContainerTeslaTower(TileEntity te, InventoryPlayer player){
        super();
        entity = te;
        this.addPlayerInventory(player);
    }

    private void addPlayerInventory(InventoryPlayer player) {
        int var3;
        for (var3 = 0; var3 < 3; ++var3) {
            for (int var4 = 0; var4 < 9; ++var4) {
                this.addSlotToContainer(new Slot(player, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }
        for (var3 = 0; var3 < 9; ++var3) {
            this.addSlotToContainer(new Slot(player, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    @Override
    protected void retrySlotClick(int p_75133_1_, int p_75133_2_, boolean p_75133_3_, EntityPlayer p_75133_4_)
    {
        //this.slotClick(p_75133_1_, p_75133_2_, 1, p_75133_4_);
    }

}

