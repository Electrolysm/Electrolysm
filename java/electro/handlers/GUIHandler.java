package electro.handlers;

import api.powerSystem.prefab.TEPowerCore;
import cpw.mods.fml.common.network.IGuiHandler;
import electro.machines.advMachines.container.ContainerEnergiser;
import electro.machines.advMachines.container.ContainerInjector;
import electro.machines.advMachines.gui.GUIEnergiser;
import electro.machines.advMachines.gui.GUIInjector;
import electro.machines.advMachines.te.TileEntityEnergiser;
import electro.machines.advMachines.te.TileEntityInjector;
import electro.machines.assemblySystem.crafting.ContainerMatrix;
import electro.machines.assemblySystem.crafting.GuiMatrix;
import electro.machines.assemblySystem.crafting.TileEntityMatrix;
import electro.machines.assemblySystem.inventory.ContainerCrafting;
import electro.machines.assemblySystem.inventory.TileEntityCrafting;
import electro.oreProccessing.container.*;
import electro.oreProccessing.gui.*;
import electro.oreProccessing.te.*;
import electro.powerSystem.generators.GUI.GUIAdvGenerator;
import electro.powerSystem.generators.GUI.GUIGeneratorAntimatter;
import electro.powerSystem.generators.GUI.GUIGeneratorCoal;
import electro.powerSystem.generators.GUI.GuiThermalGenerator;
import electro.powerSystem.generators.container.ContainerAdvGenerator;
import electro.powerSystem.generators.container.ContainerGeneratorAntimatter;
import electro.powerSystem.generators.container.ContainerGeneratorCoal;
import electro.powerSystem.generators.container.ContainerThermalGenerator;
import electro.powerSystem.generators.te.TileEntityAdvGenerator;
import electro.powerSystem.generators.te.TileEntityGeneratorAntimatter;
import electro.powerSystem.generators.te.TileEntityGeneratorCoal;
import electro.powerSystem.generators.te.TileEntityThermalGenerator;
import electro.powerSystem.gui.ContainerEnergyCore;
import electro.powerSystem.gui.EnergyCoreGUI;
import electro.sciences.alloyFurnace.ContainerAlloyFurnace;
import electro.sciences.alloyFurnace.GuiAlloyFurnace;
import electro.sciences.alloyFurnace.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {
    public static int id_bookIDCard = 42;
    public static int id_research = 43;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof TileEntityEnergiser) {
            return new ContainerEnergiser(player.inventory, (TileEntityEnergiser) entity);
        }
        if (entity instanceof TileEntityInjector) {
            return new ContainerInjector(player.inventory, (TileEntityInjector) entity);
        }
        if (entity instanceof TileEntityElectrolisisCore) {
            return new ContainerElectrolysis((TileEntityElectrolisisCore) entity, player.inventory);
        }
        if (entity instanceof TileEntityPort) {
            return new ContainerPort((TileEntityPort) entity, player.inventory);
        }
        if (entity instanceof TileEntityCrusher) {
            return new ContainerCrusher(player.inventory, (TileEntityCrusher) entity);
        }
        if (entity instanceof TileEntityLiquidiser) {
            return new ContainerLiquidiser(player.inventory, (TileEntityLiquidiser) entity);
        }
        if (entity instanceof TileEntitySmeltory) {
            return new ContainerSmeltory(player.inventory, (TileEntitySmeltory) entity);
        }
        if (entity instanceof TileEntityGeneratorCoal) {
            return new ContainerGeneratorCoal((TileEntityGeneratorCoal) entity, player.inventory);
        }
        if (entity instanceof TileEntityGeneratorAntimatter) {
            return new ContainerGeneratorAntimatter((TileEntityGeneratorAntimatter) entity, player.inventory);
        }
        if (entity instanceof TileEntityMatrix) {
            return new ContainerMatrix(player.inventory, (TileEntityMatrix) entity);
        }
        if (entity instanceof TileEntityCrafting) {
            return new ContainerCrafting(player.inventory, (TileEntityCrafting) entity);
        }
        if (entity instanceof TileEntityAlloyFurnace) {
            return new ContainerAlloyFurnace(player.inventory, (TileEntityAlloyFurnace) entity);
        }
        if (entity instanceof TileEntityThermalGenerator) {
            return new ContainerThermalGenerator(player.inventory, (TileEntityThermalGenerator) entity);
        }
        if (entity instanceof TileEntityAdvGenerator) {
            return new ContainerAdvGenerator((TileEntityAdvGenerator) entity, player.inventory);
        }
        if (entity instanceof TEPowerCore) {
            return new ContainerEnergyCore((TEPowerCore) entity, player.inventory);
        }
        if (entity instanceof TileEntityImprovedFurnace) {
            return new ContainerImprovedFurnace(player.inventory, (TileEntityImprovedFurnace)entity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof TileEntityEnergiser) {
            return new GUIEnergiser(player.inventory, (TileEntityEnergiser) entity);
        }
        if (entity instanceof TileEntityInjector) {
            return new GUIInjector(player.inventory, (TileEntityInjector) entity);
        }
        if (entity instanceof TileEntityElectrolisisCore) {
            return new GUIElectrolysisCore((TileEntityElectrolisisCore) entity, player.inventory);
        }
        if (entity instanceof TileEntityPort) {
            return new GUIPort((TileEntityPort) entity, player.inventory);
        }
        if (entity instanceof TileEntityCrusher) {
            return new GUICrusher((TileEntityCrusher) entity, player.inventory);
        }
        if (entity instanceof TileEntityLiquidiser) {
            return new GUILiquidiser((TileEntityLiquidiser) entity, player.inventory);
        }
        if (entity instanceof TileEntitySmeltory) {
            return new GUISmeltory((TileEntitySmeltory) entity, player.inventory);
        }
        if (entity instanceof TileEntityGeneratorCoal) {
            return new GUIGeneratorCoal((TileEntityGeneratorCoal) entity, player.inventory);
        }
        if (entity instanceof TileEntityGeneratorAntimatter) {
            return new GUIGeneratorAntimatter((TileEntityGeneratorAntimatter) entity, player.inventory);
        }
        if (entity instanceof TileEntityMatrix) {
            return new GuiMatrix((TileEntityMatrix) entity, player.inventory);
        }
        if (entity instanceof TileEntityAlloyFurnace) {
            return new GuiAlloyFurnace((TileEntityAlloyFurnace) entity, player.inventory);
        }
        if (entity instanceof TileEntityThermalGenerator) {
            return new GuiThermalGenerator((TileEntityThermalGenerator) entity, player.inventory);
        }
        if (entity instanceof TileEntityAdvGenerator) {
            return new GUIAdvGenerator((TileEntityAdvGenerator) entity, player.inventory);
        }
        if (entity instanceof TEPowerCore) {
            return new EnergyCoreGUI((TEPowerCore) entity, player.inventory);
        }
        if (entity instanceof TileEntityImprovedFurnace) {
            return new GuiImprovedFurnace(player.inventory, (TileEntityImprovedFurnace)entity);
        }
        return null;
    }
}
