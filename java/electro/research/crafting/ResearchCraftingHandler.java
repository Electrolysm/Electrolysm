package electro.research.crafting;

import api.items.RecipeStack;
import cpw.mods.fml.common.registry.GameRegistry;
import electro.Electrolysm;
import electro.handlers.helpers.RecipeRegistry;
import electro.research.ResearchRecipes;
import electro.research.system.Research;
import electro.research.system.ResearchRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ben on 12/07/2014.
 */
public class ResearchCraftingHandler
{
    public HashMap<List<RecipeStack>, String> ShapedResearchMap = new HashMap<List<RecipeStack>, String>();
    public HashMap<String, List<RecipeStack>> ShapedResearchMapRev = new HashMap<String, List<RecipeStack>>();

    public HashMap<List<RecipeStack>, RecipeStack> ShapedResultMap = new HashMap<List<RecipeStack>, RecipeStack>();

    public static HashMap<String, List<RecipeStack>> getRevMap() {
        //System.out.println(new ResearchCraftingHandler().ShapedResearchMapRev);
        return new ResearchCraftingHandler().ShapedResearchMapRev;
    }

    public ResearchCraftingHandler()
    {
        ShapedResultMap = new HashMap<List<RecipeStack>, RecipeStack>();
        ShapedResearchMap = new HashMap<List<RecipeStack>, String>();
        ShapedResearchMapRev = new HashMap<String, List<RecipeStack>>();

        /*
        * Example of how to add recipes, for research
        addRecipe(ResearchRegistry.getResearch("the_basics"), new ItemStack(Items.coal, 2),
                new Object[]{
                        "XXX", "XXY", "XXX",
                        Character.valueOf('X'), Items.iron_ingot,
                        Character.valueOf('Y'), Items.gold_ingot});
        */

        addRecipe(ResearchRegistry.getResearch("energy_storage"), new ItemStack(Electrolysm.basicEnergyStorage),
                new Object[] {
                        "BGB", "GCG", "BGB",
                        Character.valueOf('B'), Electrolysm.blastProof,
                        Character.valueOf('G'), Electrolysm.blastGlass,
                        Character.valueOf('C'), Electrolysm.crystal1
                });

        addRecipe(ResearchRegistry.getResearch("thermal_generator"), new ItemStack(Electrolysm.thermalGenerator),
                new Object[] {
                        "ILI", "FMF", "IBI",
                        Character.valueOf('B'), Items.bucket,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('L'), Items.lava_bucket,
                        Character.valueOf('F'), Blocks.furnace,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip
                });

        addRecipe(ResearchRegistry.getResearch("solar_panel"), new ItemStack(Electrolysm.thermalGenerator),
                new Object[] {
                        "GGG", "IDI", "IMI",
                        Character.valueOf('D'), Blocks.daylight_detector,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('G'), Blocks.glass,
                        Character.valueOf('M'), Electrolysm.BasicMicrochip
                });

        addRecipe(ResearchRegistry.getResearch("electrolysis"), new ShapedOreResearchRecipe(new ItemStack(Electrolysm.electrolisisCore), true,
                new Object[] {
                        "YIY", "RXR", "YIY",
                        'I', "ingotCopper",
                        'Y', Electrolysm.electrolChamber,
                        'X', Electrolysm.advancedMicrochip,
                        'R', Items.redstone
                }));

        addRecipe(ResearchRegistry.getResearch("intergrated_circuit"),
                new ShapedOreResearchRecipe(Electrolysm.experimentalMicrochip, true, new Object[]{
                        "   ", "ADA", "MCM",
                        'A', Electrolysm.advancedCPU,
                        'D', Items.diamond,
                        'M', Electrolysm.advancedMicrochip,
                        'C', "ingotCopper"}));

        addRecipe(ResearchRegistry.getResearch("CPU"), new ShapedOreResearchRecipe(Electrolysm.CPU, true, new Object[]{
                        "CTC", "TRT", "CTC",
                        'C', Electrolysm.copperIngot,
                        'T', Electrolysm.transistor,
                        'R', Items.redstone}));

        addRecipe(ResearchRegistry.getResearch("microprocessor"), new ShapedOreResearchRecipe(Electrolysm.advancedCPU, true, new Object[]{
                "RCR", "PDP", "RCR",
                'R', Items.redstone,
                'C', "ingotCopper",
                'P', Electrolysm.CPU,
                'D', Items.diamond}));

        addRecipe(ResearchRegistry.getResearch("crusher"), new ShapedOreResearchRecipe(new ItemStack(Electrolysm.crusher, 1, 3),
                true, new Object[]{
                "IMI", "PGP", "ICI",
                Character.valueOf('I'), Items.iron_ingot,
                Character.valueOf('M'), Electrolysm.BasicMicrochip,
                Character.valueOf('P'), Blocks.cobblestone,
                Character.valueOf('G'), Electrolysm.grindStone,
                Character.valueOf('C'), "ingotSteel"}));
        addRecipe(ResearchRegistry.getResearch("smeltery"), new ItemStack(Electrolysm.smeltory, 1, 3),
                new Object[]{
                        "IRI", "IMI", "FFF",
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('F'), Blocks.furnace
                });

        addRecipe(ResearchRegistry.getResearch("endothermic_cable"), new ItemStack(Electrolysm.experimentalCable, 8),
                new Object[]{
                        "III", "GGG", "III",
                        Character.valueOf('I'), Electrolysm.endoInsulator,
                        Character.valueOf('G'), Electrolysm.chunkGraphite
                });

        System.out.println(this.ShapedResearchMapRev);
    }

    public static boolean hasCrafting(Research research)
    {
        return getRevMap().get(research.toAdvString()) != null;
    }

    public static HashMap<List<RecipeStack>, RecipeStack> getResultMap()
    {
        return new ResearchCraftingHandler().ShapedResultMap;
    }

    private void addRecipes(List<RecipeStack> list, Research research)
    {
        ShapedResearchMap.put(list, research.toAdvString());
        ShapedResearchMapRev.put(research.toAdvString(), list);

    }

    private void addRecipes(List<RecipeStack> list, RecipeStack result)
    {
        ShapedResultMap.put(list, result);
    }

    public Research getResearch(ItemStack[] stacks)
    {
        if(stacks == null) { return null; }

        RecipeStack[] recipeStacks = new RecipeStack[stacks.length];
        for(int i = 0; i < stacks.length; i++)
        {
            recipeStacks[i] = new RecipeStack(stacks[i]);
        }

        if(ShapedResearchMap.get(Arrays.asList(recipeStacks)) != null)
        {
            return ResearchRegistry.getResearchFromString(ShapedResearchMap.get(Arrays.asList(recipeStacks)));
        }

        return null;
    }

    public ItemStack getResult(ItemStack[] stacks)
    {
        if(stacks == null) { return null; }

        RecipeStack[] recipeStacks = new RecipeStack[stacks.length];
        for(int i = 0; i < stacks.length; i++)
        {
            recipeStacks[i] = new RecipeStack(stacks[i]);
        }
        //System.out.println(ShapedResultMap);

        if(ShapedResultMap.get(Arrays.asList(recipeStacks)) == null) { return null; }

        return ShapedResultMap.get(Arrays.asList(recipeStacks)).getStackValue();
    }

    private void addShapedRecipe(Research research, ItemStack result, Object... objects)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (objects[i] instanceof String[])
        {
            String[] astring = (String[])((String[])objects[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (objects[i] instanceof String)
            {
                String s2 = (String)objects[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < objects.length; i += 2)
        {
            Character character = (Character)objects[i];
            ItemStack itemstack1 = null;

            if (objects[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)objects[i + 1]);
            }
            else if (objects[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)objects[i + 1], 1, 32767);
            }
            else if (objects[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)objects[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        RecipeStack[] aitemstack = new RecipeStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = new RecipeStack(((ItemStack)hashmap.get(Character.valueOf(c0))));
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        ShapedResearchRecipe recipe = new ShapedResearchRecipe(aitemstack, result, research);
        this.addRecipes(Arrays.asList(aitemstack), research);
        this.addRecipes(Arrays.asList(aitemstack), new RecipeStack(result));

        //ShapedResultMap.put(Arrays.asList(aitemstack), new RecipeStack(result));
        //System.out.println(Arrays.asList(aitemstack) + " : " + research + " : " + result.getDisplayName());
    }

    public void addRecipe(Research research, ShapedOreResearchRecipe recipe)
    {
        Object[] inputs = recipe.getInput();
        ItemStack output = recipe.getRecipeOutput();
        RecipeStack[] stacks = new RecipeStack[inputs.length];
        for(int i = 0; i < inputs.length; i++)
        {
            if(inputs[i] instanceof ItemStack) {
                stacks[i] = new RecipeStack((ItemStack) inputs[i]);
            }
            else
            {
                stacks[i] = null;
            }
        }
        this.addRecipes(Arrays.asList(stacks), research);
        this.addRecipes(Arrays.asList(stacks), new RecipeStack(output));
    }

    public void addRecipe(Research research, ItemStack result, Object... objects)
    {
        addShapedRecipe(research, result, objects);
    }
}
