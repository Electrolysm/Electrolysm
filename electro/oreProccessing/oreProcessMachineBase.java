package assets.electrolysm.electro.oreProccessing;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class oreProcessMachineBase extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	public Icon frontIcon;
	
	
	public oreProcessMachineBase(int id, Material mat) {
		super(id, Material.iron);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = reg.registerIcon("electrolysm:oreProcessMachines/" + "sidePanels");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(side == meta)
		{
			return this.frontIcon;
		}
		else
		{
			return this.blockIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null; 
	}
	
	@Override
    public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
    	list.add(new ItemStack(this.blockID, 1, 3));
    }
}
