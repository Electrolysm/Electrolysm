package assets.electrolysm.electro.block.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import org.lwjgl.input.Keyboard;

import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class hammer extends ItemTool
{
    public static final Block[] blocksEffectiveAgainst = new Block[] {electrolysmCore.nettedBlock};
	
    public hammer(int id)
    {
        super(id, 10F, EnumToolMaterial.IRON, blocksEffectiveAgainst);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("Hammer");
        this.damageVsEntity = 2.5F;
        this.maxStackSize = 1;
        this.efficiencyOnProperMaterial = 10;
        this.toolMaterial = EnumToolMaterial.IRON;
    }
    
    @Override
    public float getStrVsBlock(ItemStack stack, Block block)
    {
   		if(block == electrolysmCore.nettedBlock)
   		{
   			return 10F;
   		}
   		else if(block.blockMaterial == Material.rock)
   		{
   			if(block.blockHardness < Block.blockDiamond.blockHardness)
   			{
   				return 3.5F;
   			}
   			else
   			{
   				return 1F;
   			}
   		}
   		else
   		{
   			return 1F;
   		}
    }
	
	@Override
    public boolean canHarvestBlock(Block block)
    {
		return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
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
    		String hammer = ChatMessageComponent.createFromText("This hammer breaks:").setColor(EnumChatFormatting.GREEN) + "";
    		list.add(sectionSign + "l" + sectionSign + "a" + hammer);
    		list.add("Iron");
    		list.add("Gold");
    		list.add("Tin");
    		list.add("Lead");
    		list.add("Silver");
    	}
    	else
    	{
    		String shift = ChatMessageComponent.createFromText("<Shift>").setColor(EnumChatFormatting.GOLD) + "";
    		list.add("Press " + sectionSign + "e" + shift + sectionSign + "7" + " for more info");
    	}
    }
    
    public static boolean isShiftKeyDown()
    {
      return (Keyboard.isKeyDown(42)) || (Keyboard.isKeyDown(54));
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World world, int par3, int x, int y, int z,
            EntityLivingBase livingBase)
    {
    	stack.setItemDamage(stack.getItemDamage() + 1);
    	
    	int id = world.getBlockId(x, y, z);
    	int meta = world.getBlockMetadata(x, y, z);
    	
    	if(id == electrolysmCore.nettedBlock.blockID)
    	{
    		ItemStack drop = new ItemStack(electrolysmCore.impureDusts, this.getDustRandomAmount(1, 2), meta);
        	ItemStack net = new ItemStack(electrolysmCore.net, 1, 0);
    		livingBase.entityDropItem(drop, 0);
        	livingBase.entityDropItem(net, 0);
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
		if(repairStuff == (new ItemStack(Item.ingotIron)) || repairStuff == (new ItemStack(Item.ingotGold)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

    
    
}