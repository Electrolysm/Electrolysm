package electro.research;

import electro.Electrolysm;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ResearchRecipes
{
    private static ItemStack[] recipe = new ItemStack[9];

    //List of all research recipes and note metadata
    //Blast Proof Blocks - 0
    //Shrodingers cat -1
    //Tesla  Tower Core - 2
    //Electromagnetic Containment - 3 - not finished

    public static ItemStack getResultBasedOnDamage(int damage)
    {
        if (damage == 0)
        {
            return new ItemStack(Electrolysm.blastProof, 8);
        }
        else if (damage == 1)
        {
            return null;
        }/*
        else if (damage == 2)
        {
            return new ItemStack(electrolysmCore.teslaTowerCore, 1);
        }*/
        else
        {
            return null;
        }
    }

    public static ItemStack[] getRecipeBasedOnDamage(int damage)
    {
        if (damage == 0)
        {
            return blastProofRecipe();
        }
        else if (damage == 1)
        {
            return null;
        }/*
        else if (damage == 2)
        {
            return teslaTowerRecipe();
        }*/
        else
        {
            return null;
        }
    }
/*
    public static ItemStack[] teslaTowerRecipe()
    {
        recipe[0] = new ItemStack(Block.blockIron);
        recipe[1] = new ItemStack(Block.glass);
        recipe[2] = new ItemStack(Block.blockGold);
        recipe[3] = new ItemStack(electrolysmCore.stoneObsidian);
        recipe[4] = new ItemStack(electrolysmCore.crystal1);
        recipe[5] = new ItemStack(electrolysmCore.stoneObsidian);
        recipe[6] = new ItemStack(electrolysmCore.diamondShard);
        recipe[7] = new ItemStack(Block.obsidian);
        recipe[8] = new ItemStack(electrolysmCore.diamondShard);
        return recipe;
    }*/

    public static ItemStack[] blastProofRecipe()
    {
        recipe[0] = new ItemStack(Items.iron_ingot);
        recipe[1] = new ItemStack(Electrolysm.stoneObsidian);
        recipe[2] = new ItemStack(Items.iron_ingot);
        recipe[3] = new ItemStack(Electrolysm.stoneObsidian);
        recipe[4] = null;
        recipe[5] = new ItemStack(Electrolysm.stoneObsidian);
        recipe[6] = new ItemStack(Items.iron_ingot);
        recipe[7] = new ItemStack(Electrolysm.stoneObsidian);
        recipe[8] = new ItemStack(Items.iron_ingot);
        return recipe;
    }
}
