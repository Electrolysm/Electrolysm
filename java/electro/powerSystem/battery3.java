package electro.powerSystem;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;

public class battery3 extends Item {

	public static int capacity;
	public static int tier;
	
	public battery3(int id, int cap, int tier1) {
		super(id);

		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.capacity = cap;
		this.hasSubtypes = true;
		this.setMaxDamage(cap);
		this.tier = tier1;
		this.setMaxStackSize(1);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
    	itemIcon = reg.registerIcon("electrolysm:" + "batteryTier" + tier);
    }

    @Override
    public void getSubItems(int id, CreativeTabs creativeTab, List list)
    {
    	list.add(new ItemStack(electrolysmCore.battery3, 1, (capacity - capacity)));
    	list.add(new ItemStack(electrolysmCore.battery3, 1, capacity));
    }
    
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        int dmg = stack.getItemDamage();
        int maxDmg = stack.getMaxDamage();
		String sectionSign = "\u00a7";
        String shift = "<Shift>";
        
        list.add("Energy Stored: " + dmg + "TeU");
        if(isShifting())
        {
        	list.add("Energy Stored: " + dmgAsPersent(dmg, maxDmg) + "%");
        	list.add("Energy Stored: " + dmg + "/" + maxDmg + "TeU");
        }
        else
        {
    		list.add("Press " + sectionSign + "e" + shift + sectionSign + "7" + " for more info");
        }
    }

    public static boolean isShifting()
    {
      return (Keyboard.isKeyDown(42)) || (Keyboard.isKeyDown(54));
    }

	private String dmgAsPersent(int dmg, int maxDmg) 
	{
		int persent = ((dmg * 100) / maxDmg);
		
		return String.valueOf(persent);
	}
}