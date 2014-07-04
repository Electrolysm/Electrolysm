package electro.block.machines.tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import electro.Electrolysm;
import electro.block.machines.container.ContainerResearchDesk;
import electro.handlers.helpers.BlockResource;
import electro.handlers.helpers.Utilities;
import electro.research.ItemReel;
import electro.research.common.SavePlayerScanData;
import electro.research.researchDevice;
import electro.research.system.PlayerResearchEvent;
import electro.research.system.ResearchRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
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
        //requiredList.clear();
        int id = button.id;
        String name = button.displayString;
        Random rand = new Random();
        if(name.toLowerCase() == "research" || id == 0)
        {
            if(requirements && selected != null)
            {
                //Research.advString(), requirement
                LinkedHashMap<String, String> hashMap = ResearchRegistry.getRequireMap();

                String research = selected.toAdvString();
                String requirementString = hashMap.get(research);
                String[] requireArray = ResearchRegistry.getRequirementsFromStringAsArray(requirementString);

                if(requireArray != null) {
                    List<String> notUnlocked = new ArrayList<String>();

                    for (int i = 0; i < requireArray.length; i++) {
                        if (!(SavePlayerScanData.ScanData.hasPlayerScanned(mc.getMinecraft().thePlayer.getDisplayName(),
                                requireArray[i])) &&
                                !notUnlocked.contains(requireArray[i]) &&
                                !requiredList.contains(requireArray[i]))
                        {
                            notUnlocked.add(requireArray[i]);
                            requiredList.add(requireArray[i]);

                            PlayerResearchEvent.callScanEvent(mc.getMinecraft().thePlayer,
                                    mc.getMinecraft().thePlayer.getDisplayName());
                        }
                    }
                }
                //this.setInventorySlotContents(1, new ItemStack(Electrolysm.researchPaper));
            }
            else
            {
                errorRequirement = true;
            }
            //unlock research
        }
    }

    public List<String> requiredList = new ArrayList<String>();
    Research selected = null;
    int errorTimer = 0;
    int maxErrorTimer = 100;
    int researchTimer = 0;
    int maxResearchTimer = 60;

    @Override
    public void updateEntity()
    {
        selected = ResearchRegistry.getResearch("basic_storage");
        ItemStack reels = getStackInSlot(0);
        ItemStack card = getStackInSlot(2);
        ItemStack output = getStackInSlot(1);
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

        if(active)
        {
            if(reels != null && reels.getItem() instanceof ItemReel)
            {
                ItemReel reel = (ItemReel)reels.getItem();

                int eng = selected.getPointValue().getEngPoint().getValue();
                int sci = selected.getPointValue().getSciPoint().getValue();

                int localEng = reel.getEngPoints();
                int localSci = reel.getSciPoints();

                if(localEng >= eng && localSci >= sci || true == true)
                {
                    //Air Hostess, I like the way dress!!!!!!! Air Hostess, Na Na Na Na
                    //Triple breasted women swim around town totally naked

                    requirements = true;
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
