package electro.block.basic;

import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blastProof extends BlockContainer 
{
    @SideOnly(Side.CLIENT)
    public IIcon iconBrick;

    public blastProof()
   {
        super(Material.iron);
        this.setBlockUnbreakable();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setResistance(6000000.0F);
        this.setHardness(9000);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg)
    {
        if (!(this.getUnlocalizedName().contains("Glass")))
        {
            this.blockIcon = reg.registerIcon("electrolysm:" + this.getUnlocalizedName().replace("tile.", ""));
            this.iconBrick = reg.registerIcon("electrolysm:" + "blastProofBrick");
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return null;
    }
}
