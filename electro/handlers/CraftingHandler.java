package assets.electrolysm.electro.handlers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import assets.electrolysm.electro.handlers.jokes.DamageSourceCraftingTable;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler {

	public static int goTime = 0;
	
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) 
	{
		Random rand = new Random();
		if(player.username.contains(ElectroEventHandler.prankUser) && item.getItem() != null && ElectroEventHandler.pranks)
		{
			String[] warning = {"Watch your back!", "Be carefull...", "Dont say I didn't warn you!"};
			if(goTime != 3)
			{
				if(player.worldObj.isRemote)
				{
					this.printMessage(player, warning[goTime]);
				}
				goTime = goTime + 1;
			}
			else if(goTime == 3)
			{
				goTime = 0;
				this.printMessage(player, "Told you so!");
				if(rand.nextInt(10) <= 3)
				{
					player.attackEntityFrom(new DamageSourceCraftingTable("crafting", 1), (player.getHealth() + 2));
				}
				else
				{
					player.attackEntityFrom(DamageSource.causePlayerDamage(player), (player.getHealth() + 2));
				}
			}
		}
	}

	private void printMessage(EntityPlayer player, String string) 
	{
		player.addChatMessage(string);
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{

	}

}
