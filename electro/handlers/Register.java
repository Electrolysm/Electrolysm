package assets.electrolysm.electro.handlers;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class Register {

	private static void addAchievementName(String ach, String name)
	{
	        LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private static void addAchievementDesc(String ach, String desc)
	{
	        LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	
	public static void addAchievementLocalizations()
    {
                    addAchievementName("LookingInto", "Looking into Things?");
                    addAchievementDesc("LookingInto", "You are begining to explore the sciences!!");
    }

	
	
}