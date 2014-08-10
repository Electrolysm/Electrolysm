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
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Ben on 12/07/2014.
 */
public class ResearchCraftingHandler
{
    public static LinkedHashMap<List<RecipeStack>, String> ShapedResearchMap = new LinkedHashMap<List<RecipeStack>, String>();
    public static LinkedHashMap<String, List<RecipeStack>> ShapedResearchMapRev = new LinkedHashMap<String, List<RecipeStack>>();

    public static LinkedHashMap<List<RecipeStack>, RecipeStack> ShapedResultMap = new LinkedHashMap<List<RecipeStack>, RecipeStack>();

    public static LinkedHashMap<String, List<RecipeStack>> getRevMap() {
        //System.out.println(ShapedResearchMapRev);
        return ShapedResearchMapRev;
    }

    public ResearchCraftingHandler()
    {
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
                        "IRI", "GCG", "IRI",
                        Character.valueOf('R'), Electrolysm.basicCable,
                        Character.valueOf('G'), Blocks.glass,
                        Character.valueOf('C'), Electrolysm.crystal1,
                        Character.valueOf('I'), Items.iron_ingot,
                });
        
        addRecipe(ResearchRegistry.getResearch("electricity"), new ItemStack(Electrolysm.generator),
                new Object[] {
                        "ICI", "RCR", "IFI",
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('C'), Electrolysm.basicCable,
                        Character.valueOf('F'), Blocks.furnace
                });

        addRecipe(ResearchRegistry.getResearch("thermal_generator"), new ItemStack(Electrolysm.thermalGenerator),
                new Object[] {
                        "IBI", "FMF", "IBI",
                        Character.valueOf('B'), Items.bucket,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('L'), Items.lava_bucket,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip
                });

        addRecipe(ResearchRegistry.getResearch("solar_panel"), new ItemStack(Electrolysm.solarPanel),
                new Object[] {
                        "GGG", "IDI", "IMI",
                        Character.valueOf('D'), Blocks.daylight_detector,
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('G'), Blocks.glass,
                        Character.valueOf('M'), Electrolysm.BasicMicrochip
                });
        
        addRecipe(ResearchRegistry.getResearch("copper_cable"), new ItemStack(Electrolysm.basicCable),
                new Object[] {
                        "WWW", "CCC", "WWW",
                        Character.valueOf('W'), Blocks.wool,
                        Character.valueOf('C'), Electrolysm.copperIngot,
                });

        addRecipe(ResearchRegistry.getResearch("electrolysis"), new ShapedOreResearchRecipe(new ItemStack(Electrolysm.electrolisisCore), true,
                new Object[] {
                        "YIY", "RXR", "YIY",
                        'I', "ingotCopper",
                        'Y', new ItemStack(Electrolysm.electrolChamber, 1, 0),
                        'X', Electrolysm.advancedMicrochip,
                        'R', Items.redstone
                }));

        addRecipe(ResearchRegistry.getResearch("intergrated_circuit"), new ShapedOreResearchRecipe(Electrolysm.microchipBoard, true, new Object[]{
                		"   ", "   ", "RRR",
                		'R', Items.redstone}));
                		
                
               
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
                Character.valueOf('C'), "Item.redstone"}));
        addRecipe(ResearchRegistry.getResearch("smeltery"), new ItemStack(Electrolysm.smeltory, 1, 3),
                new Object[]{
                        "IRI", "IMI", "FFF",
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('F'), Blocks.furnace
                });

      /*  addRecipe(ResearchRegistry.getResearch("endothermic_cable"), new ItemStack(Electrolysm.experimentalCable, 8),
                new Object[]{
                        "III", "GGG", "III",
                        Character.valueOf('I'), Electrolysm.endoInsulator,
                        Character.valueOf('G'), Electrolysm.chunkGraphite
                });
*/
        addRecipe(ResearchRegistry.getResearch("liquidiser"), new ItemStack(Electrolysm.liquidiser, 1, 3),
                new Object[]{
                        "ILI", "RLM", "IFI",
                        Character.valueOf('I'), Items.iron_ingot,
                        Character.valueOf('L'), Electrolysm.fluidStorage,
                        Character.valueOf('R'), Items.redstone,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('F'), Blocks.furnace
                });
        addRecipe(ResearchRegistry.getResearch("molder"), new ItemStack(Electrolysm.injector, 1, 3),
                new Object[]{
                        "SFS", "FMF", "SIS",
                        Character.valueOf('I'), Electrolysm.injectionArm,
                        Character.valueOf('F'), Electrolysm.fluidStorage,
                        Character.valueOf('M'), Electrolysm.advancedMicrochip,
                        Character.valueOf('S'), Electrolysm.steel
                });

        addRecipe(ResearchRegistry.getResearch("improved_fuels"), new ItemStack(Electrolysm.improvedCoal),
                new Object[]{
                        "CH ", "R  ", "   ",
                        Character.valueOf('C'), new ItemStack(Items.coal, 1, 0),
                        Character.valueOf('H'), new ItemStack(Items.coal, 1, 1),
                        Character.valueOf('R'), Items.redstone
                });

        //System.out.println(this.ShapedResearchMapRev.get(ResearchRegistry.getResearch("the_basics").toAdvString()));
    }

    public static boolean hasCrafting(Research research)
    {
        return getRevMap().get(research.toAdvString()) != null;
    }

    public static LinkedHashMap<List<RecipeStack>, RecipeStack> getResultMap()
    {
        return ShapedResultMap;
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

        LinkedHashMap LinkedHashMap;

        for (LinkedHashMap = new LinkedHashMap(); i < objects.length; i += 2)
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

            LinkedHashMap.put(character, itemstack1);
        }

        RecipeStack[] aitemstack = new RecipeStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (LinkedHashMap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = new RecipeStack(((ItemStack)LinkedHashMap.get(Character.valueOf(c0))));
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
