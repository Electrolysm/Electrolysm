package electro.powerSystem.tesla;

import electrolysm.api.powerSystem.tesla.TERecievingCore;
import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 30/08/2014.
 */
public class BlockReciever extends BlockContainer {
    public BlockReciever(String name) {
        super(Material.iron);
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setBlockName(name);
        this.setHardness(5.49887F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TERecievingCore();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float sideX, float sideY, float sideZ) {
        if(!player.isSneaking()){
            player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z);
            return true;
        }
        return super.onBlockActivated(world, x, y, z, player, side, sideX, sideY, sideZ);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        blockIcon = reg.registerIcon("electrolysm:receiverBase");
    }
}
