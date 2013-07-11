package mods.Electrolysm.electro.physics.lasers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.physics.lasers.TileEntity.TileEntityLaserGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class fakeLaser extends Block
{
  public fakeLaser(int paramInt)
  {
    super(paramInt, Material.air);

  }

  public int func_71857_b()
  {
    return -1;
  }

  public AxisAlignedBB func_71872_e(World paramWorld, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }

  public void func_71869_a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Entity paramEntity)
  {
    paramEntity.setRotationYawHead(10);
  }

  public int getLightValue(IBlockAccess paramIBlockAccess, int paramInt1, int paramInt2, int paramInt3)
  {
    return 15;
  }

  public boolean func_71926_d()
  {
    return false;
  }

  public boolean func_71886_c()
  {
    return false;
  }

  public boolean isAirBlock(World paramWorld, int paramInt1, int paramInt2, int paramInt3)
  {
    return true;
  }
/*
  public void func_71861_g(World paramWorld, int paramInt1, int paramInt2, int paramInt3)
  {
    paramWorld.func_72836_a(paramInt1, paramInt2, paramInt3, this.field_71990_ca, 1);
  }

  public void func_71863_a(World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramWorld.func_72836_a(paramInt1, paramInt2, paramInt3, this.field_71990_ca, 1);
  }

  public void func_71847_b(World paramWorld, int paramInt1, int paramInt2, int paramInt3, Random paramRandom)
  {
    TileEntity localTileEntity = paramWorld.func_72796_p(paramInt1, paramInt2 + 1, paramInt3);
    int i = paramWorld.func_72798_a(paramInt1, paramInt2 + 1, paramInt3);
    int j = paramWorld.func_72798_a(paramInt1, paramInt2 - 1, paramInt3);

    if ((!paramWorld.field_72995_K) && (!(localTileEntity instanceof TileEntityLaserDrill)) && (i != this.field_71990_ca))
    {
      paramWorld.func_94571_i(paramInt1, paramInt2, paramInt3);
    }
    if ((j != this.field_71990_ca) && ((Block.field_71973_m[j] == null) || (Block.field_71973_m[j].isAirBlock(paramWorld, paramInt1, paramInt2 - 1, paramInt3))))
    {
      paramWorld.func_94575_c(paramInt1, paramInt2 - 1, paramInt3, this.field_71990_ca);
    }
  }
*/
  @SideOnly(Side.CLIENT)
  public void func_94332_a(IconRegister paramIconRegister)
  {
  }
  
}