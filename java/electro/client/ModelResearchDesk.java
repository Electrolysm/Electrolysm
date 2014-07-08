package electro.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelResearchDesk extends ModelBase
{
    //fields
    ModelRenderer leg0;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer books;
    ModelRenderer table;

    public ModelResearchDesk()
    {
        textureWidth = 64;
        textureHeight = 64;

        leg0 = new ModelRenderer(this, 0, 0);
        leg0.addBox(-1F, 0F, -1F, 2, 8, 2);
        leg0.setRotationPoint(-7F, 16F, 7F);
        leg0.setTextureSize(64, 64);
        leg0.mirror = true;
        setRotation(leg0, 0F, 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 0);
        leg1.addBox(0F, 0F, 0F, 2, 8, 2);
        leg1.setRotationPoint(6F, 16F, 6F);
        leg1.setTextureSize(64, 64);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 0);
        leg2.addBox(0F, 0F, 0F, 2, 8, 2);
        leg2.setRotationPoint(-8F, 16F, -8F);
        leg2.setTextureSize(64, 64);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 0);
        leg3.addBox(0F, 0F, 0F, 2, 8, 2);
        leg3.setRotationPoint(6F, 16F, -8F);
        leg3.setTextureSize(64, 64);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        books = new ModelRenderer(this, 0, 18);
        books.addBox(-6F, -4F, -6F, 12, 8, 12);
        books.setRotationPoint(0F, 20F, 0F);
        books.setTextureSize(64, 64);
        books.mirror = true;
        setRotation(books, 0F, 0F, 0F);
        table = new ModelRenderer(this, 0, 46);
        table.addBox(-8F, -1F, -8F, 16, 2, 16);
        table.setRotationPoint(0F, 15F, 0F);
        table.setTextureSize(64, 64);
        table.mirror = true;
        setRotation(table, 0F, 0F, 0F);
    }

    public void render()
    {
        this.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        leg0.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        books.render(f5);
        table.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    }

}
