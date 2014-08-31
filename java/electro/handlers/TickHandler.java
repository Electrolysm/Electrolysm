package electro.handlers;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electro.handlers.version.VersionCheck;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ChatComponentTranslation;

import java.util.Random;

/**
 * Created by Clarky158 19/06/2014.
 */
public class TickHandler
{
    int times = 0;
    //public EntityLightningBolt bolt = null;

    @SubscribeEvent
    public void checkUpdate(TickEvent.ClientTickEvent event)
    {
        if (FMLClientHandler.instance().getClient().inGameHasFocus) {
            if (times <= 0) {
                if (VersionCheck.getMessage() != null) {
                    this.printChatMessage(VersionCheck.getMessage());
                    times = 100;
                }
            }
        }
        /*if(bolt != null){
        }*/
    }

    @SideOnly(Side.CLIENT)
    public void printChatMessage(String message)
    {
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation(message));
    }

    public static float rotation = 0;
    public static int rotationBeam = 0;

    @SubscribeEvent
    public void renderTicks(TickEvent.ClientTickEvent event)
    {
        Random rand = new Random();
        float[] value = new float[] {0.021F, 0.0125F, 0.0197F, 0.0158F, 0.0638F, 0.015F};
        if (!Minecraft.getMinecraft().isGamePaused()) {
            if(rotation >= 360)
            {
                rotation = 0;
            } else {
                rotation = rotation + 0.015F;
            }

            if(rotationBeam >= 360)
            {
                rotationBeam = 0;
            }
            else
            {
                rotationBeam = rotationBeam + 1;
            }

        }

    }
}
