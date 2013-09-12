package assets.electrolysm.electro.handlers;

import net.minecraft.item.ItemStack;
import assets.electrolysm.electro.electrolysmCore;
import assets.electrolysm.electro.research.Research;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Names {

	public static void addName() {

		LanguageRegistry.addName(electrolysmCore.workBench, "Work Bench");
		LanguageRegistry.addName(electrolysmCore.desk, "Scientist's Desk");
		LanguageRegistry.addName(electrolysmCore.researchDesk, "Research Desk");
		//LanguageRegistry.addName(electrolysmCore.soldering, "Soldering Station");
		
		//Items
		for(int i = 0; i < Research.researchNotes.NAMES.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(electrolysmCore.researchPaper, 1, i), "Research Paper");
		}
		LanguageRegistry.addName(electrolysmCore.card, "ID Card");
		
	}

}
