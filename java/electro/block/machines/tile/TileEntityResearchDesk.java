package electro.block.machines.tile;

import java.awt.*;
import java.util.List;
import java.util.Random;

import electro.Electrolysm;
import electro.block.machines.container.ContainerResearchDesk;
import electro.handlers.helpers.BlockResource;
import electro.research.ItemReel;
import electro.research.researchDevice;
import electro.research.system.ResearchRegistry;
import net.minecraft.block.Block;
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

    public void actionPerformed(GuiButton button)
    {
        int id = button.id;
        String name = button.displayString;
        Random rand = new Random();
        if(name.toLowerCase() == "research" || id == 0)
        {
            if(requirements)
            {
                this.setInventorySlotContents(1, new ItemStack(Electrolysm.researchPaper));

                for(int c = 0; c < 6; c++) {
                    if (rand.nextInt(10) == 5) {
                        decrStackSize(c + 3, 1);
                    }
                }

            }
            else
            {
                errorRequirement = true;
            }
            //unlock research
        }
    }

    Research selected = null;
    ItemStack[] resources = null;
    int errorTimer = 0;
    int maxErrorTimer = 20;
    int researchTimer = 0;
    int maxResearchTimer = 60;

    @Override
    public void updateEntity()
    {
        selected = ResearchRegistry.getResearch("basic_storage");
        maxErrorTimer = 100;
        Block desk = Electrolysm.desk;
        int desksClose = 0;
        ItemStack reels = getStackInSlot(0);
        ItemStack card = getStackInSlot(2);
        ItemStack output = getStackInSlot(1);
        ItemStack[] codeStacks = null;
        //ItemStack result = Research.research().getResearch(inStack, card);
        Random rand = new Random();
        boolean active = (card != null && card.getItem() instanceof researchDevice);

        renderActiveScreen = active;

        if(resources == null) { resources = this.pickResources(rand); }
        if(codeStacks == null) { codeStacks = new ItemStack[6]; }
        for(int i = 0; i < 6; i++) { codeStacks[i] = this.getStackInSlot(i + 3); }

        if(errorRequirement) {
            if(errorTimer >= maxErrorTimer) {
                errorTimer = 0;
                errorRequirement = false;
            } else {
                errorTimer++;
            }
        }

        if(active) {
            if(reels != null && reels.getItem() instanceof ItemReel) {
                /*if(output == null && selected != null)
                {
                    ItemReel reel = (ItemReel)reels.getItem();
                    int sci = 100;//reel.getSciPoints();
                    int eng = 100;//reel.getEngPoints();

                    int selEng = selected.getPointValue().getEngPoint().getValue();
                    int selSci = selected.getPointValue().getSciPoint().getValue();

                    if(sci >= selSci && eng >= selEng)
                    {
                        if(researchTimer >= maxResearchTimer){
                            researchTimer = 0;

                            if(resources != null && codeStacks != null)
                            /   for(int i = 0; i < resources.length; i++)
                                {
                                    if(resources[i].isItemEqual(codeStacks[i]) || true)
                                    {*/
                                        requirements = true;
                                        resources = null;

                                    //}
                               // }
                        /*} else {
                            researchTimer = researchTimer + 1;
                        }
                    }
                    else
                    {
                        requirements = false;
                    }*/
                /*}
                else
                {
                    requirements = false;
                }*/
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

    public ItemStack[] pickResources(Random random)
    {
        int max = BlockResource.getResourceList().size() - 1;
        List<ItemStack> list = BlockResource.getResourceList();

        ItemStack stack = list.get(random.nextInt(max));
        ItemStack stack1 = list.get(random.nextInt(max));
        ItemStack stack2 = list.get(random.nextInt(max));
        ItemStack stack3 = list.get(random.nextInt(max));
        ItemStack stack4 = list.get(random.nextInt(max));

        return new ItemStack[] { stack, stack1, stack2, stack3, stack4};
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        NBTTagList tagList = nbtTagCompound.getTagList("Items", 0);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < tagList.tagCount(); ++i)
        {
            NBTTagCompound tagCompound = (NBTTagCompound) tagList.getCompoundTagAt(i);
            byte slot = tagCompound.getByte("Slot");

            if (slot >= 0 && slot < inventory.length)
            {
                this.inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        NBTTagList tagList = new NBTTagList();

        for (int currentIndex = 0; currentIndex < this.inventory.length; ++currentIndex)
        {
            if (this.inventory[currentIndex] != null)
            {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                this.inventory[currentIndex].writeToNBT(tagCompound);
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
