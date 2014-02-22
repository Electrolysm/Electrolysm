package assets.electrolysm.electro.biome;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import assets.electrolysm.electro.electrolysmCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class spawnZS extends Item
{
    public static String mode;
    public static String message = "Setting mode to - ";

    public spawnZS(int id)
    {
        super(id);
        this.setUnlocalizedName("zombieScientistEgg");
        this.setCreativeTab(electrolysmCore.TabElectrolysm);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("Electrolysm" + ":" + "zombieScientistEgg");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
                             int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (!(player.isSneaking()))
        {
            if (world.isRemote)
            {
            }
            else
            {
                int i1 = world.getBlockId(x, y, z);
                x += Facing.offsetsXForSide[par7];
                y += Facing.offsetsYForSide[par7];
                z += Facing.offsetsZForSide[par7];
                double d0 = 0.0D;

                if (par7 == 1 && Block.blocksList[i1] != null
                        && Block.blocksList[i1].getRenderType() == 11)
                {
                    d0 = 0.5D;
                }

                EntityZombie_Scientist Zombie_Scientist = spawnZombie_Scientist(world, x + 0.5D, y + d0, z + 0.5D);

                if (Zombie_Scientist != null)
                {
                    if (Zombie_Scientist instanceof EntityLiving && stack.hasDisplayName())
                    {
                        ((EntityLiving) Zombie_Scientist).setCustomNameTag(stack.getDisplayName());
                    }
                }
            }

            return true;
        }
        else
        {
            if (world.isRemote)
            {
            }
            else
            {
                int i1 = world.getBlockId(x, y, z);
                x += Facing.offsetsXForSide[par7];
                y += Facing.offsetsYForSide[par7];
                z += Facing.offsetsZForSide[par7];
                double d0 = 0.0D;

                if (par7 == 1 && Block.blocksList[i1] != null
                        && Block.blocksList[i1].getRenderType() == 11)
                {
                    d0 = 0.5D;
                }

                VillagerScientist VillagerScientist = spawnVillagerScientist(world, x + 0.5D, y + d0, z + 0.5D);

                if (VillagerScientist != null)
                {
                    if (VillagerScientist instanceof EntityLiving && stack.hasDisplayName())
                    {
                        ((EntityLiving) VillagerScientist).setCustomNameTag(stack.getDisplayName());
                    }
                }
            }
        }

        return false;
    }

    private VillagerScientist spawnVillagerScientist(
        World world, double x, double y, double z)
    {
        VillagerScientist robot = new VillagerScientist(world);
        EntityLiving entity = robot;
        robot.setLocationAndAngles(x, y, z, MathHelper
                                   .wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
        entity.rotationYawHead = entity.rotationYaw;
        entity.renderYawOffset = entity.rotationYaw;
        //entity.initCreature();
        world.spawnEntityInWorld(robot);
        entity.playLivingSound();
        return robot;
    }

    public static EntityZombie_Scientist spawnZombie_Scientist(World world, double x, double y,
            double z)
    {
        EntityZombie_Scientist robot = new EntityZombie_Scientist(world);
        EntityLiving entity = robot;
        robot.setLocationAndAngles(x, y, z, MathHelper
                                   .wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
        entity.rotationYawHead = entity.rotationYaw;
        entity.renderYawOffset = entity.rotationYaw;
        //entity.initCreature();
        world.spawnEntityInWorld(robot);
        entity.playLivingSound();
        return robot;
    }
}