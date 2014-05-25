package assets.electrolysm.electro.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import assets.electrolysm.electro.block.advMachines.container.ContainerEnergiser;
import assets.electrolysm.electro.block.advMachines.container.ContainerInjector;
import assets.electrolysm.electro.block.advMachines.gui.GUIEnergiser;
import assets.electrolysm.electro.block.advMachines.gui.GUIInjector;
import assets.electrolysm.electro.block.advMachines.te.TileEntityEnergiser;
import assets.electrolysm.electro.block.advMachines.te.TileEntityInjector;
import assets.electrolysm.electro.block.machines.container.ContainerResearchDesk;
import assets.electrolysm.electro.block.machines.container.ContainerWorkBench;
import assets.electrolysm.electro.block.machines.gui.GUIResearchDesk;
import assets.electrolysm.electro.block.machines.gui.GUIWorkBench;
import assets.electrolysm.electro.block.machines.tile.TileEntityResearchDesk;
import assets.electrolysm.electro.block.machines.tile.TileEntityWorkBench;
import assets.electrolysm.electro.oreProccessing.container.ContainerCrusher;
import assets.electrolysm.electro.oreProccessing.container.ContainerElectrolysis;
import assets.electrolysm.electro.oreProccessing.container.ContainerLiquidiser;
import assets.electrolysm.electro.oreProccessing.container.ContainerPort;
import assets.electrolysm.electro.oreProccessing.container.ContainerSmeltory;
import assets.electrolysm.electro.oreProccessing.gui.GUICrusher;
import assets.electrolysm.electro.oreProccessing.gui.GUIElectrolysisCore;
import assets.electrolysm.electro.oreProccessing.gui.GUILiquidiser;
import assets.electrolysm.electro.oreProccessing.gui.GUIPort;
import assets.electrolysm.electro.oreProccessing.gui.GUISmeltory;
import assets.electrolysm.electro.oreProccessing.te.TileEntityCrusher;
import assets.electrolysm.electro.oreProccessing.te.TileEntityElectrolisisCore;
import assets.electrolysm.electro.oreProccessing.te.TileEntityLiquidiser;
import assets.electrolysm.electro.oreProccessing.te.TileEntityPort;
import assets.electrolysm.electro.oreProccessing.te.TileEntitySmeltory;
import assets.electrolysm.electro.powerSystem.generators.GUI.GUIGeneratorAntimatter;
import assets.electrolysm.electro.powerSystem.generators.GUI.GUIGeneratorCoal;
import assets.electrolysm.electro.powerSystem.generators.container.ContainerGeneratorAntimatter;
import assets.electrolysm.electro.powerSystem.generators.container.ContainerGeneratorCoal;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import assets.electrolysm.electro.powerSystem.generators.te.TileEntityGeneratorCoal;
import assets.electrolysm.electro.research.client.GUIIDCardInfo;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{
    public static int id_bookIDCard = 42;

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getBlockTileEntity(x, y, z);

        if (entity instanceof TileEntityResearchDesk)
        {
            return new ContainerResearchDesk((TileEntityResearchDesk)entity, player.inventory);
        }

        if (entity instanceof TileEntityEnergiser)
        {
            return new ContainerEnergiser(player.inventory, (TileEntityEnergiser)entity);
        }

        if (entity instanceof TileEntityInjector)
        {
            return new ContainerInjector(player.inventory, (TileEntityInjector)entity);
        }

        if (entity instanceof TileEntityElectrolisisCore)
        {
            return new ContainerElectrolysis((TileEntityElectrolisisCore)entity, player.inventory);
        }

        if (entity instanceof TileEntityPort)
        {
            return new ContainerPort((TileEntityPort)entity, player.inventory);
        }

        if (entity instanceof TileEntityWorkBench)
        {
            return new ContainerWorkBench((TileEntityWorkBench)entity, player.inventory);
        }

        if (entity instanceof TileEntityCrusher)
        {
            return new ContainerCrusher(player.inventory, (TileEntityCrusher)entity);
        }
        if(entity instanceof TileEntityLiquidiser)
        {
        	return new ContainerLiquidiser(player.inventory, (TileEntityLiquidiser)entity);
        }
        if(entity instanceof TileEntitySmeltory)
        {
        	return new ContainerSmeltory(player.inventory, (TileEntitySmeltory)entity);
        }

        if(entity instanceof TileEntityGeneratorCoal)
        {
        	return new ContainerGeneratorCoal((TileEntityGeneratorCoal)entity, player.inventory);
        }
        
        if(entity instanceof TileEntityGeneratorAntimatter)
        {
        	return new ContainerGeneratorAntimatter((TileEntityGeneratorAntimatter)entity, player.inventory);
        }
        
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getBlockTileEntity(x, y, z);

        if (entity instanceof TileEntityResearchDesk)
        {
            return new GUIResearchDesk((TileEntityResearchDesk)entity, player.inventory);
        }

        if (entity instanceof TileEntityEnergiser)
        {
            return new GUIEnergiser(player.inventory, (TileEntityEnergiser)entity);
        }

        if (entity instanceof TileEntityInjector)
        {
            return new GUIInjector(player.inventory, (TileEntityInjector)entity);
        }

        if (entity instanceof TileEntityElectrolisisCore)
        {
            return new GUIElectrolysisCore((TileEntityElectrolisisCore)entity, player.inventory);
        }

        if (entity instanceof TileEntityPort)
        {
            return new GUIPort((TileEntityPort)entity, player.inventory);
        }

        if (entity instanceof TileEntityWorkBench)
        {
            return new GUIWorkBench((TileEntityWorkBench)entity, player.inventory);
        }

        if (entity instanceof TileEntityCrusher)
        {
            return new GUICrusher((TileEntityCrusher)entity, player.inventory);
        }
        if(entity instanceof TileEntityLiquidiser)
        {
        	return new GUILiquidiser((TileEntityLiquidiser)entity, player.inventory);
        }
        if(entity instanceof TileEntitySmeltory)
        {
        	return new GUISmeltory((TileEntitySmeltory)entity, player.inventory);
        }
        if(entity instanceof TileEntityGeneratorCoal)
        {
        	return new GUIGeneratorCoal((TileEntityGeneratorCoal)entity, player.inventory);
        }

        if(entity instanceof TileEntityGeneratorAntimatter)
        {
        	return new GUIGeneratorAntimatter((TileEntityGeneratorAntimatter)entity, player.inventory);
        }
        if(ID == this.id_bookIDCard )
        {
        	return new GUIIDCardInfo(player.inventory);
        }
        
        return null;
    }
}
