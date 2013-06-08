package mods.Electrolysm.api.machines;

import java.util.Map;
import net.minecraft.item.ItemStack;

public abstract interface IMachineRecipeManager
{
  public abstract void addRecipe(ItemStack paramItemStack, Object paramObject);

  public abstract Object getOutputFor(ItemStack paramItemStack, boolean paramBoolean);

  public abstract Map getRecipes();
}