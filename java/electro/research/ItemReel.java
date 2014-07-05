package electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.common.CommonProxy;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Clarky158 on 02/07/2014.
 */
public class ItemReel extends Item
{
    public ItemReel(){
        super();

        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("ItemReel");
    }

    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:itemReel");
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player){

        stack.stackTagCompound = new NBTTagCompound();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        int meta = stack.getItemDamage();
        if(stack.stackTagCompound != null) {
            String message = "Science Value: " + stack.stackTagCompound.getInteger("sciValue");
            String message1 = "Engineering Value: " + stack.stackTagCompound.getInteger("engValue");

            list.add(message); list.add(message1); list.add("Maximum Storage Capacity: " +
                    CommonProxy.REEL_MAX_VALUE[meta] + "Mb");
        }
        else
        {
            String message = "Right click to initialize...";
            list.add(message);
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y,
                            int z, int par7, float par8, float par9, float par10)
    {
        if(stack.stackTagCompound == null)
        {
            stack.stackTagCompound = new NBTTagCompound();
            stack.stackTagCompound.setInteger("engValue", 0);
            stack.stackTagCompound.setInteger("sciValue", 0);
            this.printInitializationMessage(player);
            return true;
        }
        else
        {
            stack.stackTagCompound.setInteger("engValue", stack.stackTagCompound.getInteger("engValue") + 1);
            stack.stackTagCompound.setInteger("sciValue", stack.stackTagCompound.getInteger("sciValue") + 1);
            return true;
        }
    }

    public void printInitializationMessage(EntityPlayer player)
    {
        player.addChatMessage(new ChatComponentTranslation("Data reel initialized."));
    }

}
