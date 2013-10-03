package assets.electrolysm.electro.item.basic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.ForgeHooks;

public class plasmaDrill extends ItemTool {

	public plasmaDrill(int id, float par2, EnumToolMaterial toolMaterial, Block[] block) {
		super(id, par2, EnumToolMaterial.EMERALD, block);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName("plasmaDrill");
		
		this.toolMaterial = toolMaterial;
        this.maxStackSize = 1;
        this.damageVsEntity = 20;
        this.efficiencyOnProperMaterial = 20;
	}

	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon("electrolysm:" + "plasmaDrill");
	    }

	 @Override
	 public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	    {
	        return 20.0F;
	    }
	 
	 @Override
	    public float getStrVsBlock(ItemStack stack, Block block, int meta) 
	    {
	        return getStrVsBlock(stack, block);
	    }
}
