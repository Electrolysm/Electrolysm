package assets.electrolysm.electro.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.block.machines.tile.TileEntityDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import assets.electrolysm.electro.powerSystem.te.TileEntityTransformerMachine;
import assets.electrolysm.electro.powerSystem.te.TileEntityTransformerSource;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockInventoryRendering implements ISimpleBlockRenderingHandler 
{
	public static final double POSITION_FIX = -0.5D;
	private static TileEntityResearchDesk researchDeskTE = new TileEntityResearchDesk();
	private static TileEntityDesk deskTE = new TileEntityDesk();
	private static TileEntityWorkBench workBenchTE = new TileEntityWorkBench();
	private static TileEntityTransformerMachine transformerMachineTE = new TileEntityTransformerMachine();
	private static TileEntityTransformerSource transformerSourceTE = new TileEntityTransformerSource();
	
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		TileEntityRenderer entityRenderer = TileEntityRenderer.instance;
		
		if(block == electrolysmCore.researchDesk)
		{
			entityRenderer.renderTileEntityAt(researchDeskTE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
		}
		else if(block == electrolysmCore.desk)
		{
			entityRenderer.renderTileEntityAt(deskTE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
		}
		else if(block == electrolysmCore.workBench)
		{
			entityRenderer.renderTileEntityAt(workBenchTE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
		}
		/*else if(block == electrolysmCore.transformerMachine)
		{
			entityRenderer.renderTileEntityAt(transformerMachineTE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
		}
		else if(block == electrolysmCore.transformerSource)
		{
			entityRenderer.renderTileEntityAt(transformerSourceTE, POSITION_FIX, POSITION_FIX, POSITION_FIX, 0.0F);
		}
		*/
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) 
	{
		return true;
	}
		
	@Override
	public boolean shouldRender3DInInventory() 
	{
		return true;
	}
	@Override
	public int getRenderId() 
	{
		return -1;
	}
}