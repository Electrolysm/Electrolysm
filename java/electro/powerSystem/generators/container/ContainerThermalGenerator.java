package electro.powerSystem.generators.container;

import api.powerSystem.SlotBattery;
import electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import electro.powerSystem.generators.te.TileEntityThermalGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 19/07/2014.
 */
public class ContainerThermalGenerator extends Container {

    private TileEntityThermalGenerator entity;

    public ContainerThermalGenerator(InventoryPlayer inventory, TileEntityThermalGenerator entity) {
        this.entity = entity;

        this.addSlotToContainer(new Slot(entity, 0, 134, 60));


        int var3;

        for (var3 = 0; var3 < 3; ++var3) {
            for (int var4 = 0; var4 < 9; ++var4) {
                //full inventory
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3) {
            //hotbar
            this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
        return null;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
    }
}
