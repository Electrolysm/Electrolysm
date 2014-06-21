package electro.research;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.research.common.SavePlayerScanData;
import electro.research.pointsSystem.ResearchPoint;
import electro.research.system.PlayerResearchEvent;
import electro.research.system.ResearchRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 18/06/2014.
 */
public class scanner extends Item
{
    public scanner()
    {
        super();
        this.setUnlocalizedName("scanner");
        this.setMaxStackSize(1);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
    }

    int timer = 0;
    Block blockCheck = null;

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y,
                             int z, int par7, float par8, float par9, float par10)
    {
       // System.out.println(timer);
        //System.out.println(SavePlayerScanData.ResearchData.decryptString("g0tjvpunx4my_r4r3_0z91fzjfj"));

        //Debug
        //new SavePlayerScanData.ResearchData(player.getDisplayName(), "fractional_distillation");

        return this.doThings(stack, player, world, x, y, z);
    }

    public static boolean hasBlockBeenScanned(String username, String newData)
    {
        if (SavePlayerScanData.ScanData.dataAlreadyExists(newData + ",", SavePlayerScanData.ScanData.getUserData(username)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity)
    {
        //System.out.println("interaction");
        if(entity instanceof EntityLiving)
        {
            //System.out.println("living");
            EntityLiving entityLiving = (EntityLiving)entity;
            return this.doThingsEntity(stack, player, entityLiving);
        }
        return false;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        timer = 0;
        blockCheck = null;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 10;
    }


    public boolean doThings(ItemStack stack, EntityPlayer player, World world, int x, int y, int z)
    {
        if(this.hasBlockBeenScanned(player.getDisplayName(), world.getBlock(x, y, z).getUnlocalizedName()))
        {
            return false;
        }

        if(blockCheck == world.getBlock(x, y, z))
        {
            if (timer == 10)
            {
                timer = 0;
                blockCheck = null;
                //new ResearchRegistry(true);

                new SavePlayerScanData.ScanData(player.getDisplayName(), (new ItemStack(world.getBlock(x, y, z))).getUnlocalizedName());
                PlayerResearchEvent.callScanEvent(player, player.getDisplayName());
                return true;
            } else {
                timer = timer + 1;
                return true;
            }
        }
        else
        {
            timer = 0;
            blockCheck = world.getBlock(x, y, z);
            return true;
        }
    }

    EntityLiving entityCheck = null;

    public boolean doThingsEntity(ItemStack stack, EntityPlayer player, EntityLiving entity)
    {
        //System.out.println(entity.getCommandSenderName());
        if(this.hasBlockBeenScanned(player.getDisplayName(), entity.getCommandSenderName()))
        {
            return false;
        }

        if(true)//entityCheck == entity)
        {
            if (timer != 10)
            {
                timer = 0;
                entityCheck = null;
                //new ResearchRegistry(true);

                new SavePlayerScanData.ScanData(player.getDisplayName(), entity.getCommandSenderName());
                PlayerResearchEvent.callScanEvent(player, player.getDisplayName());
                return true;
            } else {
                timer = timer + 1;
                return true;
            }
        }
        else
        {
            timer = 0;
            entityCheck = entity;
            return true;
        }
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("electrolysm:" + "scannerAnimation");
    }

}
