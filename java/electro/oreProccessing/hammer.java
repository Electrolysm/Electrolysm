package electro.oreProccessing;

import java.util.*;

import electro.Electrolysm;
import electro.handlers.analytics.AnalyticsHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class hammer extends ItemTool
{
    public static final Block[] block = new Block[] {Electrolysm.nettedBlock};
    private static Set<Block> blocksEffectiveAgainst = new HashSet<Block>(Arrays.asList(block));

    public hammer()
    {
        super(10F, ToolMaterial.IRON, blocksEffectiveAgainst);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setUnlocalizedName("Hammer");
        this.maxStackSize = 1;
        this.efficiencyOnProperMaterial = 10;
        this.toolMaterial = ToolMaterial.IRON;
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
   		if(block instanceof nettedBlock)
   		{
   			return 10F;
   		}
   		else
   		{
   			return 1F;
   		}
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "Hammer");
    }

    public static String unlocalName()
    {
        return null;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x,
                             int y, int z, int par7, float par8, float par9, float par10)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            //world.createExplosion(player, x, y, z, 1000000, true);
            return false;
        }
    }
    
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
    	list.add("For smashing all the things! - Nearly");
    	
		String sectionSign = "\u00a7";
		
    	if(this.isShiftKeyDown())
    	{
    		String hammer = ("This hammer breaks:");
    		list.add(sectionSign + "l" + sectionSign + "a" + hammer);
    		list.add("Iron");
    		list.add("Gold");
    		list.add("Tin");
    		list.add("Lead");
    		list.add("Silver");
    	}
    	else
    	{
    		String shift = "<Shift>";
    		list.add("Press " + sectionSign + "e" + shift + sectionSign + "7" + " for more info");
    	}
    }
    
    public static boolean isShiftKeyDown()
    {
      return (Keyboard.isKeyDown(42)) || (Keyboard.isKeyDown(54));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z,
                                    EntityLivingBase livingBase)
    {
    	stack.setItemDamage(stack.getItemDamage() + 1);
    	
    	Block block1 = world.getBlock(x, y, z);
    	int meta = world.getBlockMetadata(x, y, z);
    	
    	if(block1 instanceof nettedBlock)
    	{
    		ItemStack drop = new ItemStack(Electrolysm.impureDusts, this.getDustRandomAmount(1, 2), meta);
    	    livingBase.entityDropItem(drop, 0);
    	}

    	return true;
    }

	private int getDustRandomAmount(int i, int j)
	{
		Random rand = new Random();
		
		if(rand.nextInt(10) >= 5)
		{
			return i;
		}
		else
		{
			return j;
		}
	}
	
	@Override
    public boolean getIsRepairable(ItemStack hammer, ItemStack repairStuff)
	{
		if(repairStuff == (new ItemStack(Items.iron_ingot)) || repairStuff == (new ItemStack(Items.gold_ingot)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    
    
}