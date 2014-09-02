package electro.powerSystem.tesla.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.powerSystem.tesla.te.TileEntityTeslaCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;

/**
 * Created by Clarky158 on 02/09/2014.
 */
public class ContainerTeslaTower extends Container{

    public TileEntityTeslaCore entity;
    public ContainerTeslaTower(TileEntityTeslaCore te, InventoryPlayer player){
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

}

