package electro.handlers;

import electro.Electrolysm;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ElectrolysmLootHandler 
{
	public ElectrolysmLootHandler()
	{
		WeightedRandomChestContent knowledge = new WeightedRandomChestContent(new ItemStack(Electrolysm.knowledge), 1,
				10 , 10);
		WeightedRandomChestContent antiMatter = new WeightedRandomChestContent(new ItemStack(Electrolysm.electroContain, 1, 1),
				1, 10 , 10);
		
		this.addLoot(knowledge);
		this.addLoot(antiMatter);

	}
	
	public void addLoot(WeightedRandomChestContent lootEntry)
	{
		String[] category = {"mineshaftCorridor", "pyramidDesertyChest", "pyramidJungleChest", "strongholdCorridor",
				"strongholdCrossing", "villageBlacksmith", "bonusChest", "dungeonChest"};
		
		for(int i = 0; i < category.length; i++)
		{
			ChestGenHooks cgh = ChestGenHooks.getInfo(category[i]);
			cgh.addItem(lootEntry);
		}
	}
}
