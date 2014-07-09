package electro.assemblySystem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.Electrolysm;
import electro.assemblySystem.tileEntity.TileEntityAdvCrafting;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Ben on 07/07/2014.
 */
public class advancedCrafting extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    public IIcon iconTop;

    public advancedCrafting()
    {
        super(Material.iron);
        this.setBlockName("advancedCrafting");
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(7F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityAdvCrafting();
    }

    //advCraftingSide
    //advCraftingTop

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("electrolysm:advCraftingSide");
        this.iconTop = reg.registerIcon("electrolysm:advCraftingTop");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int dmg)
    {
        if(side == 1 || side == 0)
        {
            return this.iconTop;
        }
        else
        {
            return this.blockIcon;
        }
    }


}
