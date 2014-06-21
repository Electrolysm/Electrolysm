package electro.crafting.items;

import java.util.List;

import electro.Electrolysm;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class advancedMicrochip extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon iconIcon;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconIcon2;
	
	public static Block[] breakingBlock = null;
	
    public advancedMicrochip()
    {
        super();
        {
            this.setCreativeTab(Electrolysm.TabElectrolysm);
            this.hasSubtypes = true;
            //LanguageRegistry.addName(new ItemStack(this, 1, 0), "Advanced Microchip");

            for(int i = 0; i < 5; i++)
            {
            	GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 1), 
            		new ItemStack(this, 1, 0),
            		new ItemStack(Items.skull, 1, 4),
            		new ItemStack(Blocks.tnt),
            		new ItemStack(Blocks.tnt),
            		new ItemStack(Items.wooden_sword),
            		new ItemStack(Items.skull, 1, i));
            }
        }
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        String[] type = {"EXPERIM", "CREEP"};
        return "advMicrochip" + type[dmg];
    }
    
    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 1; i++)
        {
            list.add(new ItemStack(Electrolysm.advancedMicrochip, 1, i));
        }
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player)
    {
        //stack.damageItem(2, livingBase2);
        if(stack.getItemDamage() != 0)
        {
        	if(!(target instanceof EntityHorse))
        	{/*
        		ServerTickHandler.canRun = true;
            	ServerTickHandler.entity = player;
            	ServerTickHandler.target = target;
        		
            	TickHandler.canRun = true;
            	TickHandler.entity = player;
            	TickHandler.target = target;
        		stack.stackSize = stack.stackSize - 1;
        		return true;*/
        	}
        	else
        	{
        		return false;
        	}
        }
        else
        {
        	return false;
        }

        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "advMicro");
    	this.iconIcon = reg.registerIcon("electrolysm:" + "advMicro2");
    	//this.iconIcon2 = reg.registerIcon("electrolysm:" + "advMicro3");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dmg)
    {
        if(dmg == 0)
        {
        	return this.itemIcon;
        }
        else if(dmg == 1)
        {
        	return this.iconIcon;
        }
        else
        {
        	return this.iconIcon2;
        }
    }
    
}