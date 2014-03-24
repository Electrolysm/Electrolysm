package assets.electrolysm.electro.crafting.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.handlers.TickHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class advancedMicrochip extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon iconIcon;
	
	@SideOnly(Side.CLIENT)
	private Icon iconIcon2;
	
	public static Block[] breakingBlock = null;
	
    public advancedMicrochip(int par1)
    {
        super(par1);
        {
            this.setCreativeTab(electrolysmCore.TabElectrolysm);
            this.setUnlocalizedName("advMicrochip");
            this.hasSubtypes = true;
            LanguageRegistry.addName(new ItemStack(this, 1, 0), "Advanced Microchip");
            LanguageRegistry.addName(new ItemStack(this, 1, 1), "Creepified Microchip");
            
            for(int i = 0; i < 5; i++)
            {
            	GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 1), 
            		new ItemStack(this, 1, 0),
            		new ItemStack(Item.skull, 1, 4),
            		new ItemStack(Block.tnt),
            		new ItemStack(Block.tnt),
            		new ItemStack(Item.swordWood),
            		new ItemStack(Item.skull, 1, i));
            }
        }
    }
    
    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < 1; i++)
        {
            list.add(new ItemStack(electrolysmCore.advancedMicrochip, 1, i));
        }
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player)
    {
        //stack.damageItem(2, livingBase2);
        if(stack.getItemDamage() != 0)
        {
        	TickHandler.canRun = true;
        	TickHandler.entity = player;
        	TickHandler.target = target;
        	stack.stackSize = stack.stackSize - 1;
        	return true;
        }
        
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	this.itemIcon = reg.registerIcon("electrolysm:" + "advMicro");
    	this.iconIcon = reg.registerIcon("electrolysm:" + "advMicro2");
    	//this.iconIcon2 = reg.registerIcon("electrolysm:" + "advMicro3");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int dmg)
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