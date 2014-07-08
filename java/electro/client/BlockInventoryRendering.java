package electro.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import electro.block.advMachines.te.TileEntityCharger;
import electro.block.machines.tile.TileEntityDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import electro.oreProccessing.te.TileEntityElectrolisisCore;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.client.IItemRenderer;

public class BlockInventoryRendering
{
    public static final double POSITION_FIX = -0.5D;
    private static TileEntityResearchDesk RESEARCH_DESK_TE = new TileEntityResearchDesk();
    private static TileEntityDesk DESK_TE = new TileEntityDesk();
    private static TileEntityWorkBench WORK_BENCH_TE = new TileEntityWorkBench();
    private static TileEntityElectrolisisCore ELECTROL_CORE_TE = new TileEntityElectrolisisCore();
    private static TileEntityCharger CHARGER_TE = new TileEntityCharger();

    /*
        ItemRenderer entityRenderer = ItemRenderer.;

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
        }*/
}