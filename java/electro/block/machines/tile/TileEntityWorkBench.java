package electro.block.machines.tile;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.electrolysmCore;
import electro.research.Research;
import electro.research.ResearchRecipes;

public class TileEntityWorkBench extends TileEntity implements IInventory
{
    public ItemStack[] inventory;
    public boolean isOpen;

    public TileEntityWorkBench()
    {
        this.inventory = new ItemStack[11];
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

    public static ItemStack[] recipe = new ItemStack[9];

    @Override
    public void updateEntity()
    {
        for (int i = 0; i < 9; i++)
        {
            recipe[i] = this.getStackInSlot(i);
        }

        this.checkSetResearchRecipes();
    }

    public ItemStack[] recipe()
    {
        for (int i = 0; i < 9; i++)
        {
            recipe[i] = getStackInSlot(i);
        }

        return recipe;
    }

    public void clearInventory()
    {
        for (int i = 0; i < 9; i++)
        {
            ItemStack stack = this.getStackInSlot(i);

            if (stack != null)
            {
                if ((stack.stackSize - 1) > 1)
                {
                    ItemStack replace = new ItemStack(stack.getItem(), stack.stackSize, stack.getItemDamage());
                    this.setInventorySlotContents(i, null);
                }
            }
        }
    }

    public void checkSetResearchRecipes()
    {
        if (this.getStackInSlot(10) != null)
        {
            int dmg = (this.getStackInSlot(10).getItemDamage());
            boolean[] all = new boolean[9];

            if (ResearchRecipes.getRecipeBasedOnDamage(dmg) != null)
            {
                for (int i = 0; i < (this.inventory.length - 2); i++)
                {
                    //System.out.println("InventoryCheck");
                    //System.out.println(this.getStackInSlot(i));
                    //System.out.println(ResearchRecipes.getRecipeBasedOnDamage(dmg)[i]);
                    String teStack;
                    String recipeStack;
                    ItemStack InStack;

                    if (this.getStackInSlot(i) != null)
                    {
                        InStack = new ItemStack(this.getStackInSlot(i).getItem(), this.getStackInSlot(i).stackSize - 1,
                                                this.getStackInSlot(i).getItemDamage());
                    }
                    else
                    {
                        InStack = null;
                    }

                    if (InStack == null)
                    {
                        teStack = "null";
                    }
                    else
                    {
                        teStack = InStack.toString();
                    }

                    if (ResearchRecipes.getRecipeBasedOnDamage(dmg)[i] == null)
                    {
                        recipeStack = "null";
                    }
                    else
                    {
                        recipeStack = ResearchRecipes.getRecipeBasedOnDamage(dmg)[i].toString();
                    }

                    if (teStack.contains(recipeStack))
                    {
                        //System.out.println("true");
                        all[i] = true;
                    }
                    else
                    {
                        //System.out.println("false");
                        all[i] = false;
                    }
                }

                //System.out.println("BooleanCheck");
                if (all[0] && all[1] && all[2] && all[3] && all[4] && all[5] && all[6] && all[7] && all[8])
                {
                    //System.out.println("SettingInventory");
                    this.setInventorySlotContents(9, ResearchRecipes.getResultBasedOnDamage(dmg));
                    this.markDirty();
                    this.clearInventory();
                }
            }
        }
    }

    @Override
    public void closeInventory() { }

    @Override
    public boolean hasCustomInventoryName() { return true; }

    @Override
    public String getInventoryName() { return "Injector"; }

    @Override
    public void openInventory() { }
}
