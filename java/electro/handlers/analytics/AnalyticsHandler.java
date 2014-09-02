package electro.handlers.analytics;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import electro.handlers.Referance;
import electro.handlers.analytics.google.AnalyticsConfigData;
import electro.handlers.analytics.google.AnalyticsRequestData;
import electro.handlers.analytics.google.JGoogleAnalyticsTracker;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Clarky158 on 02/09/2014.
 */
public class AnalyticsHandler
{
    JGoogleAnalyticsTracker tracker;
    String KEY = "MC:" + MinecraftForge.MC_VERSION + " - FORGE:" + MinecraftForge.getBrandingVersion()
            + " - MOD:" + Referance.MOD_REF.VERSION;

    public AnalyticsHandler() {
        AnalyticsConfigData config = new AnalyticsConfigData("UA-54377296-1");
        tracker = new JGoogleAnalyticsTracker(config, JGoogleAnalyticsTracker.GoogleAnalyticsVersion.V_4_7_2);
        tracker.setEnabled(true);
    }

    public void trackStart(){
        track("GameStart");
    }

    public void track(Object data){
        tracker.trackPageView(KEY, String.valueOf(data), "Electrolysm|Core");
    }
}
