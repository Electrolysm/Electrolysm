package electro.sciences;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemArmorLab extends ItemArmor {

    //@SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[2];

	public ItemArmorLab(int piece, String unlocalName) {
		super(ArmorMaterial.CLOTH, 0, piece);
		
		this.setMaxStackSize(1);
		this.setCreativeTab(Electrolysm.TabElectrolysm);
		this.setUnlocalizedName(unlocalName);
	}

    @Override
    @SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return ("electrolysm:" + "textures/models/armor/labCoat.png");
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        this.icons[0] = reg.registerIcon("electrolysm:labGoggles");
        this.icons[1] = reg.registerIcon("electrolysm:labCoat");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass) {
        if(stack == null) { return null; }
        if (stack.getDisplayName().toLowerCase().contains("coat")) {
            return icons[1];
        } else {
            return icons[0];
        }
    }
}
