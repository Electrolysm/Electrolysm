package electro.misc.item.tools;

import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HazMap extends ItemArmor {

	@SideOnly(Side.CLIENT)
	public IIcon iconHelmat;
	@SideOnly(Side.CLIENT)
	public IIcon iconChest;
	@SideOnly(Side.CLIENT)
	public IIcon iconLegs;
	@SideOnly(Side.CLIENT)
	public IIcon iconBoots;
	
	public int damageReduceAmount;
	
	public HazMap(int armorType)
	{
		super(Electrolysm.PLASTIC, 1, armorType);
		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int dmg = stack.getItemDamage();
        Item id = stack.getItem();
        return "HazMap" + dmg + ":" + id;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
		String modID = "electrolysm:";
		iconHelmat = reg.registerIcon(modID + "mazMatHelmat");
		iconChest = reg.registerIcon(modID + "mazMatChest");
		iconLegs = reg.registerIcon(modID + "mazMatLegs");
		iconBoots = reg.registerIcon(modID + "mazMatBoots");
    }
}
