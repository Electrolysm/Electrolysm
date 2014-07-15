package electro.handlers;

import electro.machines.assemblySystem.crafting.ContainerMatrix;
import electro.machines.assemblySystem.crafting.GuiMatrix;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electro.machines.assemblySystem.inventory.ContainerCrafting;
import electro.machines.assemblySystem.inventory.TileEntityCrafting;
import electro.research.machines.gui.GuiCrafting;
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
import electro.sciences.alloyFurnace.ContainerAlloyFurnace;
import electro.sciences.alloyFurnace.GuiAlloyFurnace;
import electro.sciences.alloyFurnace.TileEntityAlloyFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import electro.machines.advMachines.container.ContainerEnergiser;
import electro.machines.advMachines.container.ContainerInjector;
import electro.machines.advMachines.gui.GUIEnergiser;
import electro.machines.advMachines.gui.GUIInjector;
import electro.machines.advMachines.te.TileEntityEnergiser;
import electro.machines.advMachines.te.TileEntityInjector;
import electro.research.machines.container.ContainerResearchDesk;
import electro.research.machines.container.ContainerWorkBench;
import electro.research.machines.gui.GUIResearchDesk;
import electro.research.machines.gui.GUIWorkBench;
import electro.research.machines.tile.TileEntityResearchDesk;
import electro.research.machines.tile.TileEntityWorkBench;
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

        if(entity instanceof TileEntityMatrix)
        {
            return new ContainerMatrix(player.inventory, (TileEntityMatrix)entity);
        }

        if(entity instanceof TileEntityCrafting)
        {
            return new ContainerCrafting(player.inventory, (TileEntityCrafting)entity);
        }

        if(entity instanceof TileEntityAlloyFurnace)
        {
            return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace)entity);
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
        	return new GUIIDCardInfo(/*player.inventory*/);
        }

        if(ID == this.id_research)
        {
            return new GuiResearchNotify(Minecraft.getMinecraft());
        }

        if(entity instanceof TileEntityMatrix)
        {
            return new GuiMatrix((TileEntityMatrix)entity, player.inventory);
        }

        if(entity instanceof TileEntityCrafting)
        {
            return new GuiCrafting((TileEntityCrafting)entity, player.inventory);
        }

        if(entity instanceof TileEntityAlloyFurnace)
        {
            return new GuiAlloyFurnace((TileEntityAlloyFurnace)entity, player.inventory);
        }
        return null;
    }
}
