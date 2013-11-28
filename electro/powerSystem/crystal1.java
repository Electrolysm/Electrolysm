package assets.electrolysm.electro.powerSystem;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import assets.electrolysm.electro.electrolysmCore;

public class crystal1 extends Item {

	public crystal1(int id) {
		super(id);

		this.setUnlocalizedName("crystal-tier-1");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
	public static String[] getData()
	{
		NBTTagCompound nbt = new NBTTagCompound();
	
		String[] result = {nbt.getInteger("freq") + "", nbt.getString("username")};
		return result;
	}
	
	public static void setData(int freq, String username)
	{
		NBTTagCompound nbt = new NBTTagCompound();
		
		nbt.setInteger("freq", freq);
		nbt.setString("username", username);
	}

}
