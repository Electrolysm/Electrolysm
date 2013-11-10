package assets.electrolysm.electro.handlers;

import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.advAtomics.liquids.plasma;
import assets.electrolysm.electro.block.advMachines.energiser;
import assets.electrolysm.electro.block.advMachines.injector;
import assets.electrolysm.electro.block.advMachines.quantumComp;
import assets.electrolysm.electro.common.CommonProxy;
import assets.electrolysm.electro.research.Research;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Names {

	public static void addName() {

		LanguageRegistry.addName(electrolysmCore.workBench, "Work Bench");
		LanguageRegistry.addName(electrolysmCore.desk, "Scientist's Desk");
		LanguageRegistry.addName(electrolysmCore.researchDesk, "Research Desk");
		LanguageRegistry.addName(electrolysmCore.blastProof, "Blast Proof Iron Block");
		LanguageRegistry.addName(electrolysmCore.blastDoor, "Blast Proof Iron Door");
		LanguageRegistry.addName(electrolysmCore.energiser, "Fluid Energiser");
		LanguageRegistry.addName(electrolysmCore.injector, "Injector");

		
		//LanguageRegistry.addName(electrolysmCore.plasma, "Liquid Plasma");
		//LanguageRegistry.addName(electrolysmCore.quantumComp, "Quantum Computer");
		LanguageRegistry.addName(electrolysmCore.blastGlass, "Blast Proof Iron Glass");
		LanguageRegistry.addName(electrolysmCore.modBlastGlass, "Modified Blast Proof Iron Glass");
		LanguageRegistry.addName(electrolysmCore.plasmaDrill, "Plasma Drill");
		LanguageRegistry.addName(electrolysmCore.diseaseGrass, "Diseased Grass");
		LanguageRegistry.addName(electrolysmCore.spawnZS, "Spawn Zombie-Scientist");
		LanguageRegistry.addName(electrolysmCore.knowledge, "Knowledge Strip");
		LanguageRegistry.addName(electrolysmCore.drillCasing, "Plasma Drill Casing");
		LanguageRegistry.addName(electrolysmCore.graphite, "Graphite");
		LanguageRegistry.addName(electrolysmCore.chunkGraphite, "Graphite Chunk");
		LanguageRegistry.addName(electrolysmCore.injectionArm, "Injection Arm");
		LanguageRegistry.addName(electrolysmCore.energisingRod, "Energising Filament");
		LanguageRegistry.addName(electrolysmCore.glassModifire, "Glass Modifier");
		
		
		//Items
		for(int i = 0; i < Research.researchNames1.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(electrolysmCore.researchPaper, 1, i), "Research Paper");
		}
		LanguageRegistry.addName(electrolysmCore.card, "ID Card");
		
		for(int i = 0; i < CommonProxy.HOLDABLE_FLUIDS.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(electrolysmCore.fluidStorage, 1, i),
					"Strengthened Fluid Storage Capsule");
		}
		for(int i = 0; i < CommonProxy.DUSTS.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(electrolysmCore.dusts, 1, i), CommonProxy.DUSTS[i] + " Dust");
			LanguageRegistry.addName(new ItemStack(electrolysmCore.impureDusts, 1, i), "Impure " + 
						CommonProxy.DUSTS[i] + " Dust");
		}
	
	
	}

}
