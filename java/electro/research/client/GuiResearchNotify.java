package electro.research.client;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import electro.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Clarky158 on 19/06/2014.
 */
public class GuiResearchNotify extends GuiScreen
{
    private int windowWidth;
    private int windowHeight;
    private Minecraft theGame;
    int xSize = 741;
    int ySize = 646;

    @SubscribeEvent
    public void overlayEvent(RenderGameOverlayEvent event)
    {
        //event.
    }

    public GuiResearchNotify(Minecraft mc)
    {
        super();
        this.theGame = mc;
    }

    private void updateResearchWindowScale()
    {
        GL11.glViewport(0, 0, this.theGame.displayWidth, this.theGame.displayHeight);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this.windowWidth = this.theGame.displayWidth;
        this.windowHeight = this.theGame.displayHeight;
        ScaledResolution var1 = new ScaledResolution(this.theGame.gameSettings, this.theGame.displayHeight, this.theGame.displayWidth);
        this.windowWidth = var1.getScaledWidth();
        this.windowHeight = var1.getScaledHeight();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, this.windowWidth, this.windowHeight, 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
    }

    @Override
    public void drawScreen(int i, int j, float f)
    {
        this.updateResearchWindow();
    }

    public void updateResearchWindow()
    {/*
        xSize = (741 / 2) - 100 - 20 + 5;
        ySize = (646 / 2) - 100 + 50 - 20;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(CommonProxy.IMAGE_TECH_TREE);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);*/

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(3553);
        this.bindTexture("/achievement/bg.png");
        this.drawString("/achievement/bg.png");
        this.drawTexturedModalRect(200, 200, 0, 0, 10000, 10000);
        GL11.glDisable(2896);
    }

    public static void drawString(String texture)
    {
        Minecraft.getMinecraft().ingameGUI.func_110326_a(texture, true);
    }

    public static void bindTexture(String texture)
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(CommonProxy.RESEARCH_DESK_GUI);
    }
}
