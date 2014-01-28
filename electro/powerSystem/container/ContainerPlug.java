package assets.electrolysm.electro.powerSystem.container;

import assets.electrolysm.api.powerSystem.TileEntityPlug;
import assets.electrolysm.electro.block.machines.container.SlotOutput;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Ben on 27/01/14.
 */
public class ContainerPlug extends Container
{
        private TileEntityPlug plug;
        private GuiTextField textKey;

        public ContainerPlug(InventoryPlayer inventoryPlayer, TileEntityPlug tileEntityPlug)
        {
            this.plug = tileEntityPlug;
            //																				ACROSS, UP
            this.textKey = new GuiTextField(this.frontRenderer, 50, 50, 65, 12);

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
        {/*
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
		*/
        }

        @Override
        public void detectAndSendChanges()
        {
            super.detectAndSendChanges();

            for (int i = 0; i < this.crafters.size(); ++i)
            {
/*			ICrafting icrafting = (ICrafting)this.crafters.get(i);

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
			*/
            }
/*
		this.lastCookTime = this.furnace.furnaceCookTime;
		this.lastBurnTime = this.furnace.furnaceBurnTime;
		this.lastItemBurnTime = this.furnace.currentItemBurnTime;
	*/
        }

        @SideOnly(Side.CLIENT)
        public void updateProgressBar(int par1, int par2)
        {
            if (par1 == 0)
            {
                //this.furnace.furnaceCookTime = par2;
            }

            if (par1 == 1)
            {
                //this.furnace.furnaceBurnTime = par2;
            }

            if (par1 == 2)
            {
                //this.furnace.currentItemBurnTime = par2;
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
}
