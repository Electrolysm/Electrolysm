package electrolysm.electro.machines.assemblySystem.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

/**
 * Created by Ben on 10/07/2014.
 */
public class ContainerCrafting extends Container {

    private TileEntityCrafting entityCrafting;

    int chestInventoryRows = 9;
    int chestInventoryColumns = 3;
    InventoryCrafting craftingMatrix = new InventoryCrafting(this, 3, 3);


    public ContainerCrafting(InventoryPlayer inventoryPlayer, TileEntityCrafting entityCrafting1)
    {
        this.entityCrafting = entityCrafting1;

        //Crafting area
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
            {
                this.addSlotToContainer(new Slot(craftingMatrix, r + c * 3, 30 + c * 18, 17 + r * 18));
            }
        }
        //Result
        this.addSlotToContainer(new Slot(entityCrafting, 10, 124, 60));
        //Resources

        //Player Inventory
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

        this.onCraftMatrixChanged(this.craftingMatrix);

    }

    @Override
    public void onCraftMatrixChanged (IInventory par1IInventory)
    {
        this.entityCrafting.setInventorySlotContents(0, CraftingManager.getInstance()
                .findMatchingRecipe(craftingMatrix, entityCrafting.getWorldObj()));
    }

    @Override
    public void addCraftingToCrafters(ICrafting icrafting) {
        super.addCraftingToCrafters(icrafting);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < crafters.size(); i++) {
            ICrafting icrafting = (ICrafting) crafters.get(i);
        }
    }

    @Override
    public void updateProgressBar(int id, int data) {
    }

    @Override
    public ItemStack slotClick(int i, int j, int modifier, EntityPlayer entityplayer) {
        ItemStack stack = super.slotClick(i, j, modifier, entityplayer);
        onCraftMatrixChanged(craftingMatrix);
        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return entityCrafting.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack newItemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack = slot.getStack();
            newItemStack = itemStack.copy();

            if (slotIndex < chestInventoryRows * chestInventoryColumns)
            {
                if (!this.mergeItemStack(itemStack, chestInventoryRows * chestInventoryColumns, inventorySlots.size(), false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemStack, 0, chestInventoryRows * chestInventoryColumns, false))
            {
                return null;
            }

            if (itemStack.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return newItemStack;
    }
}
