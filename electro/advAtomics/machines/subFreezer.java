package mods.Electrolysm.electro.advAtomics.machines;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class subFreezer extends BlockContainer {

	private static final String itemIDName = "subFreezer";

	private Icon sides;
	@SideOnly(Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private Icon furnaceIconFront;
	public subFreezer(int par1) {
		super(par1, Material.iron);
		// TODO Auto-generated constructor stub
	
	
	this.setCreativeTab(electrolysmCore.TabElectrolysm);
	this.setUnlocalizedName(itemIDName);
	this.setHardness(5);
	
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.furnaceIconTop : (par1 == 0 ? this.furnaceIconTop : (par1 != par2 ? this.blockIcon : this.furnaceIconFront));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Electrolysm:" + itemIDName);
        this.furnaceIconFront = par1IconRegister.registerIcon("Electrolysm:" + itemIDName + "Front");
        this.furnaceIconTop = par1IconRegister.registerIcon("Electrolysm:" + itemIDName + "Top");
    }
    
    /*
    * Called upon block activation (right click on the block.)
    */
   public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
   {
	return true;
      

   }
   
}