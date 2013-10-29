package assets.electrolysm.electro.block.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class hammer extends Item {

	public hammer(int id) {
		super(id);
	
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("Hammer");
		this.maxStackSize = 1;
		}

		@SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "Hammer");
	    }
	}