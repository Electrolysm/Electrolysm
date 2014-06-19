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
public class GuiResearchNotify extends Gui
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

    public void updateResearchWindow()
    {
        //this.updateResearchWindowScale();

        xSize = 512 / 2;
        ySize = 512 / 2;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(1.0F, -10.0F, 1.0F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        int xStart = (windowWidth - xSize) / 2;
        int yStart = (windowHeight - ySize) / 2;
        //System.out.println("rendering");

        this.theGame.renderEngine.bindTexture(CommonProxy.RESEARCH_BACKING);
        this.drawTexturedModalRect(xStart/* - 100 - 50 - 50 + 60*/, yStart, 0, 0, xSize, ySize);
    }
}
