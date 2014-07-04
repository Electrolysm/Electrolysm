package electro.block.machines.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import electro.block.machines.tile.TileEntityResearchDesk;

public class ContainerResearchDesk extends Container
{
    private TileEntityResearchDesk entity;

    public ContainerResearchDesk(TileEntityResearchDesk entity, InventoryPlayer inventory)
    {
        this.entity = entity;
        this.addSlotToContainer(new Slot(entity, 0, 152, 6)); //top right
        this.addSlotToContainer(new Slot(entity, 1, 152, 116)); //bottom right
        this.addSlotToContainer(new Slot(entity, 2, 9, 6)); //top left (CARD)

        //Hexagon
        int[] xCoord = new int[] {66, 87, 87, 66, 46, 46};
        int[] yCoord = new int[] {35, 47, 72, 84, 72, 47};
/*
        for(int i = 0; i < 6; i++) {
            this.addSlotToContainer(new Slot(entity, i + 3, xCoord[i], yCoord[i]));
        }
*/
        int var3;

        /*for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
            	//full inventory
                this.addSlotToContainer(new Slot(inventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }*/

        for (var3 = 0; var3 < 9; ++var3)
        {
            //hotbar
            this.addSlotToContainer(new Slot(inventory, var3, 8 + var3 * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return entity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        return null;
    }

    public void onContainerClosed(EntityPlayer par1EntityPlayer)
    {
        InventoryPlayer inventoryplayer = par1EntityPlayer.inventory;

        if (inventoryplayer.getItemStack() != null)
        {
            par1EntityPlayer.entityDropItem(inventoryplayer.getItemStack(), 0);
            inventoryplayer.setItemStack((ItemStack)null);
        }

        this.entity.isOpen = false;
    }
}