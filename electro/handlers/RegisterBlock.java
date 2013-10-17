package assets.electrolysm.electro.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterBlock {

	public static void register() {
		
		GameRegistry.registerBlock(electrolysmCore.workBench);
		GameRegistry.registerBlock(electrolysmCore.desk);
		GameRegistry.registerBlock(electrolysmCore.researchDesk);
		GameRegistry.registerBlock(electrolysmCore.diseaseGrass);
		
		GameRegistry.registerBlock(electrolysmCore.blastProof);
		GameRegistry.registerBlock(electrolysmCore.blastDoor);
		GameRegistry.registerBlock(electrolysmCore.plasma);
		GameRegistry.registerBlock(electrolysmCore.energiser);
		GameRegistry.registerBlock(electrolysmCore.injector);
		
		//Fluids
		/*
		FluidContainerRegistry.registerFluidContainer(
				new FluidContainerData(
					FluidRegistry.getFluidStack( electrolysmCore.plasma.getName(), FluidContainerRegistry.BUCKET_VOLUME ),
					new ItemStack( electrolysmCore.bucketPlasma),
					new ItemStack( Item.bucketEmpty )
				)
			);*/
	}

}
