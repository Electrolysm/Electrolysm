package assets.electrolysm.electro.advAtomics.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HazMap extends ItemArmor {

	@SideOnly(Side.CLIENT)
	public Icon iconHelmat;
	@SideOnly(Side.CLIENT)
	public Icon iconChest;
	@SideOnly(Side.CLIENT)
	public Icon iconLegs;
	@SideOnly(Side.CLIENT)
	public Icon iconBoots;
	
	public int damageReduceAmount;
	
	public HazMap(int id, int armorType)
	{
		super(id, electrolysmCore.PLASTIC, 1, armorType);
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        int id = stack.itemID;
        return "HazMap" + dmg + ":" + id;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
		String modID = "electrolysm:";
		iconHelmat = reg.registerIcon(modID + "mazMatHelmat");
		iconChest = reg.registerIcon(modID + "mazMatChest");
		iconLegs = reg.registerIcon(modID + "mazMatLegs");
		iconBoots = reg.registerIcon(modID + "mazMatBoots");
    }
}
