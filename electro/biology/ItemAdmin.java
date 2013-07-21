package mods.Electrolysm.electro.biology;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.biology.entity.EntityZombie_Scientist;
import mods.Electrolysm.electro.world.WorldGenStructures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemAdmin extends Item {

	public static String mode;
	public static String message = "Setting mode to - ";
	
	public ItemAdmin(int id) {
		super(id);
		this.setUnlocalizedName("zombieScientistEgg");
		this.setCreativeTab(electrolysmCore.TabElectrolysmPhysics);
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("Electrolysm" + ":" + "zombieScientistEgg");	
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int par7, float par8, float par9, float par10) {

			if (world.isRemote) {

			} else {
				int i1 = world.getBlockId(x, y, z);
				x += Facing.offsetsXForSide[par7];
				y += Facing.offsetsYForSide[par7];
				z += Facing.offsetsZForSide[par7];
				double d0 = 0.0D;

				if (par7 == 1 && Block.blocksList[i1] != null
						&& Block.blocksList[i1].getRenderType() == 11) {
					d0 = 0.5D;
				}

			EntityZombie_Scientist Zombie_Scientist = spawnZombie_Scientist(world, x + 0.5D, y + d0, z + 0.5D);

			if (Zombie_Scientist != null) {
				if (Zombie_Scientist instanceof EntityLiving && stack.hasDisplayName()) {
					((EntityLiving) Zombie_Scientist).func_94058_c(stack.getDisplayName());
				}
			}
		}
	return true;
}

	

	public static EntityZombie_Scientist spawnZombie_Scientist(World world, double x, double y,
			double z) {
		EntityZombie_Scientist robot = new EntityZombie_Scientist(world);

		EntityLiving entity = robot;
		robot.setLocationAndAngles(x, y, z, MathHelper
				.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		entity.rotationYawHead = entity.rotationYaw;
		entity.renderYawOffset = entity.rotationYaw;
		entity.initCreature();
		world.spawnEntityInWorld(robot);
		entity.playLivingSound();

		return robot;
	}
	
	
	private void modeChange() {
		// TODO Auto-generated method stub
		try{
			
		}catch (IndexOutOfBoundsException e) {
	        // this should never happen...
		}
	}

}