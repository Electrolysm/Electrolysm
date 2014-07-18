package electro.handlers.multipart;

import codechicken.lib.data.MCDataInput;
import codechicken.lib.data.MCDataOutput;
import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.render.IFaceRenderer;
import codechicken.lib.render.RenderUtils;
import codechicken.lib.render.Vertex5;
import codechicken.lib.vec.BlockCoord;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Vector3;
import codechicken.lib.lighting.LightMatrix;
import codechicken.microblock.IMicroMaterialRender;
import codechicken.microblock.ISidedHollowConnect;
import codechicken.microblock.MicroMaterialRegistry;
import codechicken.multipart.*;
import codechicken.multipart.scalatraits.TSlottedTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import codechicken.microblock.MicroblockClient;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Ben on 18/07/2014.
 */
public class PartCable extends JCuboidPart
        implements JIconHitEffects, IFaceRenderer, IMicroMaterialRender, TSlottedPart, IMicroBlock
{
    public static final String type = "extrautils:pipeJacket";
    int material;
    public MicroMaterialRegistry.IMicroMaterial mat = null;
    private static LightMatrix olm;
    public int connectionMask = 0;
    public double pipeSize = 0.3D;
    public TMultiPart centerPart = null;
    private MicroMaterialRegistry.IMicroMaterial wool;
    public static Cuboid6[] axisCubes = null;

    public PartCable()
    {
    }

    public void harvest(MovingObjectPosition hit, EntityPlayer player)
    {
        super.harvest(hit, player);
    }

    public boolean occlusionTest(TMultiPart npart)
    {
        return !npart.getClass().equals(getClass());
    }

    public void renderFace(Vertex5[] face, int side)
    {
        this.mat.renderMicroFace(face, side, new Vector3(x(), y(), z()), olm.load(), this);
    }

    @Override
    public void writeDesc(MCDataOutput packet)
    {
        packet.writeInt(this.material);
    }

    public void readDesc(MCDataInput packet)
    {
        this.material = packet.readInt();
    }

    public void save(NBTTagCompound tag)
    {
        super.save(tag);
        tag.setString("mat", MicroMaterialRegistry.materialName(this.material));
    }

    public void load(NBTTagCompound tag)
    {
        super.load(tag);
        this.material = MicroMaterialRegistry.materialID(tag.getString("mat"));
    }

    public PartCable(int material)
    {
        this.material = material;
    }

    public String getType()
    {
        return "extrautils:pipeJacket";
    }

    public Cuboid6 getBounds()
    {
        return new Cuboid6(0.5D - this.pipeSize, 0.5D - this.pipeSize, 0.5D - this.pipeSize, 0.5D + this.pipeSize, 0.5D + this.pipeSize, 0.5D + this.pipeSize);
    }

    public Iterable<Cuboid6> getCollisionBoxes()
    {
        ArrayList boxes = new ArrayList();
        boxes.add(getRenderBounds());

        for (int i = 0; i < 6; i++)
        {
            if ((this.connectionMask & 1 << i) != 0)
            {
                boxes.add(new Cuboid6(0.5D - this.pipeSize, 0.5D + this.pipeSize, 0.5D - this.pipeSize, 0.5D + this.pipeSize, 1.0D, 0.5D + this.pipeSize).apply(codechicken.lib.vec.Rotation.sideRotations[net.minecraft.util.Facing.field_71588_a[i]].at(new Vector3(0.5D, 0.5D, 0.5D))));
            }
        }

        return boxes;
    }

    public ItemStack getItemDrop()
    {
        ItemStack item = new ItemStack(ItemMicroBlock.instance, 1);
        NBTTagCompound tag = new NBTTagCompound("tag");
        tag.setString("mat", MicroMaterialRegistry.materialName(this.material));
        item.setTagCompound(tag);
        return item;
    }

    public Iterable<ItemStack> getDrops()
    {
        return Arrays.asList(new ItemStack[]{getItemDrop()});
    }

    public ItemStack pickItem(MovingObjectPosition hit)
    {
        return getItemDrop();
    }

    public IIcon getBreakingIcon(Object subPart, int side)
    {
        return getBrokenIcon(side);
    }

    private MicroMaterialRegistry.IMicroMaterial getMaterial()
    {
        if (this.mat == null)
        {
            this.mat = MicroMaterialRegistry.getMaterial(this.material);
        }

        return this.mat;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBrokenIcon(int side)
    {
        if (this.mat != null)
        {
            return this.mat.getBreakingIcon(side);
        }
        return null;
        //return Block..(0, 0);
    }

    public void addHitEffects(MovingObjectPosition hit, EffectRenderer effectRenderer)
    {
        IconHitEffects.addHitEffects(this, hit, effectRenderer);
    }

    public void addDestroyEffects(EffectRenderer effectRenderer)
    {
        IconHitEffects.addDestroyEffects(this, effectRenderer, false);
    }

    public Cuboid6 getRenderBounds()
    {
        return getBounds();
    }

    public int getLightValue()
    {
        return MicroMaterialRegistry.getMaterial(this.material).getLightValue();
    }

    public void onNeighborChanged()
    {
        if (!world().isRemote)
        {
            dropIfCantStay();
        }
        else
        {
            reloadShape();
        }
    }

    public boolean canStay()
    {
        return ((TSlottedTile)getTile()).partMap(6) != null;
    }

    public boolean dropIfCantStay()
    {
        if (!canStay())
        {
            drop();
            return true;
        }

        reloadShape();
        return false;
    }

    public void drop()
    {
        TileMultipart.dropItem(getItemDrop(), world(), Vector3.fromTileEntityCenter(tile()));
        tile().remPart(this);
    }

    public void onPartChanged(TMultiPart part)
    {
        if (!world().isRemote)
        {
            dropIfCantStay();
        }
    }

    public Iterable<IndexedCuboid6> getSubParts()
    {
        ArrayList boxes = new ArrayList();
        Iterator iter = getCollisionBoxes().iterator();

        while (iter.hasNext())
        {
            boxes.add(new IndexedCuboid6(Integer.valueOf(0), (Cuboid6)iter.next()));
        }

        return boxes;
    }

    public void onWorldJoin()
    {
        reloadShape();
        super.onWorldJoin();
    }

    public void reloadShape()
    {
        int prevMask = this.connectionMask;
        this.centerPart = ((TSlottedTile)getTile()).partMap(6);
        double prevSize = this.pipeSize;
        this.pipeSize = 0.26D;
        this.connectionMask = 0;

        if (this.centerPart != null)
        {
            if ((this.centerPart instanceof IHollowConnect))
            {
                this.pipeSize = Math.max(this.pipeSize, (((IHollowConnect)this.centerPart).getHollowSize() + 1) / 32.0F);
            }

            if ((this.centerPart instanceof ISidedHollowConnect)) {
                for (int side = 0; side < 6; side++)
                {
                    this.pipeSize = Math.max(this.pipeSize, (((ISidedHollowConnect)this.centerPart).getHollowSize(side) + 1) / 32.0F);
                }
            }
            for (int i = 0; i < 6; i++)
            {
                Iterator iter = this.centerPart.getCollisionBoxes().iterator();

                while (iter.hasNext())
                {
                    if (((Cuboid6)iter.next()).intersects(new Cuboid6(this.pipeSize, 0.0D, this.pipeSize, 1.0D - this.pipeSize, 0.01D, 1.0D - this.pipeSize).apply(codechicken.lib.vec.Rotation.sideRotations[i].at(new Vector3(0.5D, 0.5D, 0.5D)))))
                    {
                        this.connectionMask |= 1 << i;
                    }
                }
            }
        }

        if ((prevMask != this.connectionMask) || (prevSize != this.pipeSize))
        {
            tile().notifyPartChange(this);
            tile().markRender();
        }
    }

    public void renderStatic(Vector3 pos, LightMatrix olm, int pass)
    {
        reloadShape();

        if (this.mat == null)
        {
            this.mat = MicroMaterialRegistry.getMaterial(this.material);
        }

        if ((this.mat != null) && (this.mat.canRenderInPass(pass)))
        {
            olm = olm;
            Iterator iter = getCollisionBoxes().iterator();

            //RenderUtils.renderBlock(getRenderBounds(), this.connectionMask, this);

            for (int i = 0; i < 6; i++)
            {
                if ((this.connectionMask & 1 << i) != 0)
                {
                    //RenderUtils.renderBlock(new Cuboid6(0.5D - this.pipeSize, 0.5D + this.pipeSize, 0.5D - this.pipeSize, 0.5D + this.pipeSize, 1.0D, 0.5D + this.pipeSize).apply(codechicken.lib.vec.Rotation.sideRotations[net.minecraft.util.Facing.field_71588_a[i]].at(new Vector3(0.5D, 0.5D, 0.5D))), 1 << net.minecraft.util.Facing.field_71588_a[i], this);
                }

            }

            olm = null;
        }
    }

    public int getSlotMask()
    {
        return 0;
    }

    public float getStrength(MovingObjectPosition hit, EntityPlayer player)
    {
        return getMaterial().getStrength(player) * 4.0F;
    }

    public int getMetadata()
    {
        return 0;
    }

    public TMultiPart newPart(boolean client)
    {
        return new PartCable();
    }

    public TMultiPart placePart(ItemStack stack, EntityPlayer player, World world, BlockCoord pos, int side, Vector3 arg5, int materialID)
    {
        TileMultipart tile = TileMultipart.getOrConvertTile(world, new BlockCoord(pos.x, pos.y, pos.z));

        if ((tile instanceof TSlottedTile))
        {
            TMultiPart part = ((TSlottedTile)tile).partMap(6);
            return new PartCable(materialID);
        }

        return null;
    }

    public void registerPassThroughs()
    {
    }

    public void renderItem(ItemStack item, MicroMaterialRegistry.IMicroMaterial material)
    {
        if (this.wool == null)
        {
            //this.wool = MicroMaterialRegistry.getMaterial(Block.blockRegistry.getKeys());
        }

        //MicroblockClient.renderCuboid(new Vector3(0.0D, 0.0D, 0.0D), null, this.wool, new Cuboid6(0.1995D, 0.4D, 0.4D, 0.8005D, 0.6D, 0.6D), 15, this);
        //MicroblockClient.renderCuboid(new Vector3(0.0D, 0.0D, 0.0D), null, material, new Cuboid6(0.2D, 0.25D, 0.25D, 0.8D, 0.75D, 0.75D), 0, this);
    }
}