package electro.powerSystem;

import electrolysm.api.powerSystem.prefab.BlockEnergy;
import electrolysm.api.powerSystem.prefab.TEPowerCore;
import electro.Electrolysm;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Clarky158 on 23/07/2014.
 *
 * Electrolysm is an open source Minecraft mod
 * released under version 3 of the GNU Lesser
 * General Public License. This means that
 * the source of this mod is publicly available
 * and you have certain rights with respective
 * to the code.
 */
public class BlockCreativeEnergyCore extends BlockEnergy {
    public BlockCreativeEnergyCore() {
        super();
        this.setCreativeTab(Electrolysm.TabElectrolysm);
        this.setHardness(2F);
        setHarvestLevel("pickaxe", 1);
        setStepSound(soundTypeMetal);
    }


    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!player.isSneaking()) { player.openGui(Electrolysm.GUIInstance, 0, world, x, y, z); return true; }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TEPowerCore(-1);//-1
    }


    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        blockIcon = reg.registerIcon("electrolysm:" + "model_filler");
    }
}