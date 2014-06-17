package electro.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.world.IBlockAccess;
import electro.electrolysmCore;
import electro.block.advMachines.te.TileEntityCharger;
import electro.block.machines.tile.TileEntityDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.block.te.TileEntityIronFrame;
import electro.oreProccessing.te.TileEntityElectrolisisCore;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockInventoryRendering implements ISimpleBlockRenderingHandler
{
    public static final double POSITION_FIX = -0.5D;
    private static TileEntityResearchDesk RESEARCH_DESK_TE = new TileEntityResearchDesk();
    private static TileEntityDesk DESK_TE = new TileEntityDesk();
    private static TileEntityWorkBench WORK_BENCH_TE = new TileEntityWorkBench();
    private static TileEntityElectrolisisCore ELECTROL_CORE_TE = new TileEntityElectrolisisCore();
    private static TileEntityCharger CHARGER_TE = new TileEntityCharger();

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        TileEntitySpecialRenderer entityRenderer = TileEntitySpecialRenderer.class;

        if (block == electrolysmCore.researchDesk)
        {
            entityRenderer.renderTileEntityAt(RESEARCH_DESK_TE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
        }
        else if (block == electrolysmCore.desk)
        {
            entityRenderer.renderTileEntityAt(DESK_TE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
        }
        else if (block == electrolysmCore.workBench)
        {
            entityRenderer.renderTileEntityAt(WORK_BENCH_TE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
        }
        else if (block == electrolysmCore.electrolisisCore)
        {
            entityRenderer.renderTileEntityAt(ELECTROL_CORE_TE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
        }
        else if (block == electrolysmCore.charger)
        {
            entityRenderer.renderTileEntityAt(CHARGER_TE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0f);
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
                                    RenderBlocks renderer)
    {
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int i)
    {
        return true;
    }
    @Override
    public int getRenderId()
    {
        return -1;
    }
}