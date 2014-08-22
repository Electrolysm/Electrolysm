package electrolysm.electro.client;

import net.minecraft.client.model.ModelBase;

/**
 * Created by Ben on 12/07/2014.
 */
public class ItemBlockModelBase extends ModelBase
{
    public void render()
    {
        render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    }
}
