package electro.research.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Clarky158 19/06/2014.
 */
public class GuiTickHandler
{
    public GuiResearchNotify guiNotify = null;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        //System.out.println("tick");

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player;
        int limit;
        if ((Minecraft.getMinecraft().thePlayer instanceof EntityPlayer))
        {
            player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
            long time = System.currentTimeMillis();
            if (guiNotify == null) guiNotify = new GuiResearchNotify(mc);
            guiNotify.updateResearchWindow();
            //System.out.println("rendering");

            boolean hasWorld = mc.theWorld != null;
            GuiScreen gui = mc.currentScreen;
        }
    }
}
