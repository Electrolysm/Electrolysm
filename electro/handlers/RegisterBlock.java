package assets.electrolysm.electro.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.crafting.WorkBenchCraftingManager;
import assets.electrolysm.electro.world.WorldGenStructures;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock {

	public static void register() {
		
		GameRegistry.registerBlock(electrolysmCore.workBench);
		GameRegistry.registerBlock(electrolysmCore.desk);
		GameRegistry.registerBlock(electrolysmCore.researchDesk);
		GameRegistry.registerBlock(electrolysmCore.diseaseGrass);
		
		GameRegistry.registerBlock(electrolysmCore.blastProof);
		GameRegistry.registerBlock(electrolysmCore.blastDoor);
		GameRegistry.registerBlock(electrolysmCore.blastGlass);
		GameRegistry.registerBlock(electrolysmCore.plasma);
		GameRegistry.registerBlock(electrolysmCore.energiser);
		GameRegistry.registerBlock(electrolysmCore.injector);
		GameRegistry.registerBlock(electrolysmCore.quantumComp);
		
		GameRegistry.registerWorldGenerator(new WorldGenStructures());
		
		//Fluids
		/*
		FluidContainerRegistry.registerFluidContainer(
				new FluidContainerData(
					FluidRegistry.getFluidStack( electrolysmCore.plasma.getName(), FluidContainerRegistry.BUCKET_VOLUME ),
					new ItemStack( electrolysmCore.bucketPlasma),
					new ItemStack( Item.bucketEmpty )
				)
			);*/
		
		//Adding knowledge to dungeon chests
		WeightedRandomChestContent itemChest = new WeightedRandomChestContent(electrolysmCore.knowledge.itemID,
        		0, 1, 2, 0);
        ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, itemChest);
        //End
	}

}
