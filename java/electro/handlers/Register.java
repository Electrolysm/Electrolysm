package electro.handlers;

import electro.Electrolysm;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
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
        OreDictionary.registerOre("oreCopper", Electrolysm.copperOre);
        OreDictionary.registerOre("ingotCopper", Electrolysm.copperIngot);
        OreDictionary.registerOre("blockSteel", Electrolysm.steelBlock);
        //ingots
        OreDictionary.registerOre("ingotTin", new ItemStack(Electrolysm.ingots, 1, 0));
        OreDictionary.registerOre("ingotSilver", new ItemStack(Electrolysm.ingots, 1, 1));
        OreDictionary.registerOre("ingotLead", new ItemStack(Electrolysm.ingots, 1, 2));
        OreDictionary.registerOre("ingotSteel", new ItemStack(Electrolysm.steel));
        OreDictionary.registerOre("sulphur", new ItemStack(Electrolysm.sulphur));
        OreDictionary.registerOre("sulphure", new ItemStack(Electrolysm.sulphur));
        OreDictionary.registerOre("crystalSulphure", new ItemStack(Electrolysm.sulphur));
        OreDictionary.registerOre("crystalSulphur", new ItemStack(Electrolysm.sulphur));


        for(int i = 0; i < CommonProxy.DUSTS.length; i++)
        {
            OreDictionary.registerOre("dust" + CommonProxy.DUSTS[i], new ItemStack(Electrolysm.dusts, 1, i));
        }

    }
}
