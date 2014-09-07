package electro.powerSystem.tesla;

import electro.Electrolysm;
import electro.powerSystem.tesla.te.TileEntityReceiverModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 03/09/2014.
 */
public class BlockReceiverModel extends BlockContainer {
    public BlockReceiverModel(String name) {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setBlockName(name);
        this.setHardness(1.456F);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityReceiverModel();
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        blockIcon = reg.registerIcon("electrolysm:" + "model_filler");
    }
}
