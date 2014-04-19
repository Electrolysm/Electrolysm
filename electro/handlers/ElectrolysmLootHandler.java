package assets.electrolysm.electro.handlers;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import assets.electrolysm.electro.electrolysmCore;

public class ElectrolysmLootHandler 
{
	public ElectrolysmLootHandler()
	{
		WeightedRandomChestContent knowledge = new WeightedRandomChestContent(new ItemStack(electrolysmCore.knowledge), 1,
				10 , 10);
		WeightedRandomChestContent antiMatter = new WeightedRandomChestContent(new ItemStack(electrolysmCore.electroContain, 1, 1),
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
