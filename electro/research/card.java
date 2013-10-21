package assets.electrolysm.electro.research;

import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class card extends Item{
	
	public card(int id) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("IDcard");
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {	
    	String message = "You current knowledge level is: " + stack.getItemDamage();
    	
    	if(!player.isSneaking())
    	{
    		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(message);
    	}
    	return stack;
    }
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "ID_card");
    }
    
    public void increaseLevel(ItemStack stack, int amount)
    {
    	if(stack.getItemDamage() <= 10)
    	{
    	stack.setItemDamage(stack.getItemDamage() + amount);
    	}
    }
    
    public void levelToZero(ItemStack stack)
    {
    	stack.setItemDamage(0);
    }
    
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
    {
    	String playerName = player.username;
    	int cardLevel = stack.getItemDamage();
    	
    	list.add(playerName + "'s current level is: " + cardLevel);
    }
    
    
    
}
