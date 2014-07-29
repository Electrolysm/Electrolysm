package electro.research.gui;

import electro.research.machines.container.SlotFuel;
import electro.research.machines.container.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Clarky158 on 29/07/2014.
 * <p/>
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class ContainerCollector extends Container {

    TileEntityCollector entityCollector;

    public ContainerCollector(TileEntityCollector te, InventoryPlayer inventory) {
        entityCollector = te;

        this.addSlotToContainer(new Slot(entityCollector, 0, 64 + 16, 10));

        for (int invRow = 0; invRow < 3; ++invRow)
        {
            for (int invCol = 0; invCol < 9; ++invCol)
            {
                this.addSlotToContainer(new Slot(inventory, invCol + invRow * 9 + 9, 8 + invCol * 18, 84 + invRow * 18));
            }
        }

        for (int actionBar = 0; actionBar < 9; ++actionBar)
        {
            this.addSlotToContainer(new Slot(inventory, actionBar, 8 + actionBar * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return entityCollector.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return null;
    }
}
