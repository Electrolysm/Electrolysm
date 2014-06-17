package electro.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import assets.electrolysm.electro.electrolysmCore;
import electro.common.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Register
{
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

    public static void addOreDictionary()
    {
        OreDictionary.registerOre("oreCopper", electrolysmCore.copperOre);
        OreDictionary.registerOre("ingotCopper", electrolysmCore.copperIngot);
        //ingots
        OreDictionary.registerOre("ingotTin", new ItemStack(electrolysmCore.ingots, 1, 0));
        OreDictionary.registerOre("ingotSilver", new ItemStack(electrolysmCore.ingots, 1, 1));
        OreDictionary.registerOre("ingotLead", new ItemStack(electrolysmCore.ingots, 1, 2));
        OreDictionary.registerOre("sulphur", new ItemStack(electrolysmCore.sulphur));
        OreDictionary.registerOre("sulphure", new ItemStack(electrolysmCore.sulphur));
        OreDictionary.registerOre("crystalSulphure", new ItemStack(electrolysmCore.sulphur));
        OreDictionary.registerOre("crystalSulphur", new ItemStack(electrolysmCore.sulphur));
        
        for(int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            OreDictionary.registerOre("dust" + CommonProxy.DUSTS[i], new ItemStack(electrolysmCore.dusts, 1, i));
        }

    }
}
