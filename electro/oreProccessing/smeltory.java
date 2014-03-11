package assets.electrolysm.electro.oreProccessing;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntitySmeltory;
import assets.electrolysm.electro.powerSystem.te.TileEntityTeslaTower;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class smeltory extends oreProcessMachineBase
{
    public String className = "" + this.getClass();
    public String unlocalName = className.replace("assets.electrolysm.electro", "");
    public String textureName = unlocalName.replace(".", "/");

    public smeltory(int par1, Material par2Material)
    {
        super(par1, Material.iron);
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
        this.setUnlocalizedName("smeltory");
        this.setHardness(6.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        this.frontIcon = reg.registerIcon("electrolysm:oreProcessMachines/" + "smeltory_Front");
        this.frontActive = reg.registerIcon("electrolysm:oreProcessMachines/" + "smeltory_Front_Active");
        this.blockIcon = reg.registerIcon("electrolysm:oreProcessMachines/" + "sidePanels");
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world)
    {
        // TODO Auto-generated method stub
        return new TileEntitySmeltory();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            player.openGui(electrolysmCore.GUIInstance, 0, world, x, y, z);
            return true;
        }
    }
    
    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int block)
    {
        TileEntitySmeltory te = (TileEntitySmeltory)world.getBlockTileEntity(x, y, z);

        if (this.isRecievingRedstonePower(world, x, y, z))
        {
            te.setRedstonePower(true);
        }
        else
        {
        	te.setRedstonePower(false);
        }
    }
    
    public boolean isRecievingRedstonePower(World world, int x, int y, int z)
    {
        return (world.isBlockIndirectlyGettingPowered(x, y, z));
    }
}
