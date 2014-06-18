package electro.handlers.jokes;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IChatComponent;

public class DamageSourceCraftingTable extends DamageSource 
{

	public DamageSourceCraftingTable(String string, int justChecking) 
	{
		super(string);
	}
	
	public static DamageSource causeSulphuricBurn(EntityPlayer player)
    {
        return new EntityDamageSource("crafting", player);
    }

	@Override
	public IChatComponent func_151519_b(EntityLivingBase entity)
    {
		Random rand = new Random();
		String message1 = " was slain by a crafting table!";
		String message2 = " died because crafting tables don't like him!";
		String message3 = " was killed by a crafting table!";
		String[] message = {message1, message2, message3};
		
		if(entity instanceof EntityPlayer)
		{
			return IChatComponent.Serializer.func_150699_a(((EntityPlayer)entity).getDisplayName() + message[rand.nextInt(2)]);
		}
		else
		{
			return IChatComponent.Serializer.func_150699_a("Ellio98 was killed by a crafting table!!");
		}
    }
}
