package assets.electrolysm.electro.api;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MachineBaseClass extends BlockContainer{

	public static String unlocalName;
	public static String displayName;
	public static TileEntity te;
	
	@SideOnly(Side.CLIENT)
	public Icon machineFront;
	@SideOnly(Side.CLIENT)
	public Icon machineSide;
	@SideOnly(Side.CLIENT)
	public Icon machineTop;
	
	public MachineBaseClass(int id, Material mat) {
		super(id, Material.iron);
		
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
		this.setUnlocalizedName(this.unlocalName);
		this.setHardness(5.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return te;
	}

	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.machineTop : (par1 == 0 ? this.machineTop :
        	(par1 != par2 ? this.machineSide : this.machineFront));
    }

    @SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister)
    {
        this.machineSide = par1IconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_side");
        this.machineFront = par1IconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_Front");
        this.machineTop = par1IconRegister.registerIcon("Electrolysm:" + this.unlocalName + "_Top");
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack stack)
	{
	        int l = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	
	        if (l == 0)
		    {
	            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	        }
	        
		    if (l == 1)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	        }
	
		    if (l == 2)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	        }
	
		    if (l == 3)
		    {
	           world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		    }
	 }
    
	public static String getDisplayName() 
	{
		return displayName;
	}
}