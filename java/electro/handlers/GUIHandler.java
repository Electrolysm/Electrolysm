package electro.handlers;

import electro.oreProccessing.container.*;
import electro.oreProccessing.gui.*;
import electro.oreProccessing.te.*;
import electro.powerSystem.generators.GUI.GUIGeneratorAntimatter;
import electro.powerSystem.generators.GUI.GUIGeneratorCoal;
import electro.powerSystem.generators.container.ContainerGeneratorAntimatter;
import electro.powerSystem.generators.container.ContainerGeneratorCoal;
import electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import electro.powerSystem.generators.te.TileEntityGeneratorCoal;
import electro.research.client.GUIIDCardInfo;
import electro.research.client.GuiResearchNotify;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.block.advMachines.container.ContainerEnergiser;
import electro.block.advMachines.container.ContainerInjector;
import electro.block.advMachines.gui.GUIEnergiser;
import electro.block.advMachines.gui.GUIInjector;
import electro.block.advMachines.te.TileEntityEnergiser;
import electro.block.advMachines.te.TileEntityInjector;
import electro.block.machines.container.ContainerResearchDesk;
import electro.block.machines.container.ContainerWorkBench;
import electro.block.machines.gui.GUIResearchDesk;
import electro.block.machines.gui.GUIWorkBench;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.block.machines.tile.TileEntityWorkBench;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{
    public static int id_bookIDCard = 42;
    public static int id_research = 43;

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

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
        TileEntity entity = world.getTileEntity(x, y, z);

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

        if(ID == this.id_research)
        {
            return new GuiResearchNotify(Minecraft.getMinecraft());
        }
        
        return null;
    }
}
