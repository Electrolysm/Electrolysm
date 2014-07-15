package electro.research.machines.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import electro.research.ItemReel;
import electro.research.researchDevice;
import electro.research.system.ResearchRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import electro.research.system.Research;

public class TileEntityResearchDesk extends TileEntity implements IInventory
{
    private ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityResearchDesk()
    {
        this.inventory = new ItemStack[3 + 6];
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            if (stack.stackSize <= amount)
            {
                setInventorySlotContents(slot, null);
            }
            else
            {
                stack = stack.splitStack(amount);

                if (stack.stackSize == 0)
                {
                    setInventorySlotContents(slot, null);
                }
            }
        }

        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        ItemStack stack = getStackInSlot(slot);

        if (stack != null)
        {
            setInventorySlotContents(slot, null);
        }

        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack)
    {
        // TODO Auto-generated method stub
        inventory[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit()
    {
        // TODO Auto-generated method stub
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        return true;
    }

    public boolean renderActiveScreen = false;
    public static boolean errorRequirement = false;
    public static boolean requirements = false;

    public void actionPerformed(GuiButton button, Minecraft mc)
    {

    }

    public List<String> requiredList = new ArrayList<String>();
    public Research selected = null;
    int errorTimer = 0;
    int maxErrorTimer = 100;
    int researchTimer = 0;
    int maxResearchTimer = 60;
    public boolean canSet = false;

    @Override
    public void updateEntity()
    {
        selected = null;
        //selected = ResearchRegistry.getResearch("basic_storage");
        ItemStack reels = getStackInSlot(0);
        ItemStack card = getStackInSlot(2);
        ItemStack note = getStackInSlot(1);
        //ItemStack result = Research.research().getResearch(inStack, card);
        Random rand = new Random();
        boolean active = (card != null && card.getItem() instanceof researchDevice);

        renderActiveScreen = active;

        if(errorRequirement) {
            if(errorTimer >= maxErrorTimer) {
                errorTimer = 0;
                errorRequirement = false;
            } else {
                errorTimer++;
            }
        }

        if(note != null /*&& note.stackTagCompound != null*/ && requiredList.isEmpty() && canSet)
        {
            this.setInventorySlotContents(1, null);
            //note.stackTagCompound.setBoolean("active", true);
            canSet = false;
        }
        else if(!requiredList.isEmpty() && canSet)
        {
            canSet = false;
        }

        //System.out.println(canSet);

        if(active)
        {

            if(note != null && note.stackTagCompound != null && !note.stackTagCompound.getBoolean("active"))
            {
                String researchString = note.stackTagCompound.getString("researchData");
                selected = ResearchRegistry.getResearchFromString(researchString);

                if(reels != null && reels.getItem() instanceof ItemReel && reels.stackTagCompound != null) {
                    int eng = selected.getPointValue().getEngPoint().getValue();
                    int sci = selected.getPointValue().getSciPoint().getValue();

                    int localEng = reels.stackTagCompound.getInteger("engValue");
                    int localSci = reels.stackTagCompound.getInteger("sciValue");

                    if (localEng >= eng && localSci >= sci) {
                        //Air Hostess, I like the way dress!!!!!!! Air Hostess, Na Na Na Na
                        //Triple breasted women swim around town totally naked

                        requirements = true;
                    }
                }
            }
            else
            {
                requirements = false;
            }
        }
        else
        {
            requirements = false;
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        // Read in the ItemStacks in the inventory from NBT
        NBTTagList tagList = nbtTagCompound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = tagList.getCompoundTagAt(i);
            byte slotIndex = tagCompound.getByte("Slot");
            if (slotIndex >= 0 && slotIndex < inventory.length)
            {
                inventory[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        // Write the ItemStacks in the inventory to NBT
        NBTTagList tagList = new NBTTagList();
        for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex)
        {
            if (inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                inventory[currentIndex].writeToNBT(tagCompound);
                tagList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", tagList);
    }

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Research Desk"; }

    @Override
    public void openInventory() { }
}
