package electro.powerSystem.tesla;

import electrolysm.api.powerSystem.tesla.TERecievingCore;
import electro.Electrolysm;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
}
