package electro.block.machines.gui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import electro.Electrolysm;
import electro.handlers.helpers.ColourEnumHelper;
import electro.research.common.SavePlayerScanData;
import electro.research.system.PlayerResearchEvent;
import electro.research.system.ResearchRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.player.InventoryPlayer;

import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import electro.block.machines.container.ContainerResearchDesk;
import electro.block.machines.tile.TileEntityResearchDesk;
import electro.common.CommonProxy;

public class GUIResearchDesk extends GuiContainer
{
    private TileEntityResearchDesk entity;

    public GUIResearchDesk(TileEntityResearchDesk entity,	InventoryPlayer inventory)
    {
        super(new ContainerResearchDesk(entity, inventory));
        this.entity = entity;
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if(entity.renderActiveScreen) {
            this.mc.renderEngine.bindTexture(CommonProxy.RESEARCH_DESK_ACTIVE_GUI);
        } else {
            this.mc.renderEngine.bindTexture(CommonProxy.RESEARCH_DESK_GUI);
        }
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
        int progress = 0;
        int heat;

        if (entity.errorRequirement)
        {
            int xMod = 12;
            int yMod = 50;

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glColor4f(1F, 1F, 1F, 0.999999F);
            this.drawTexturedModalRect(x + xMod, y + yMod, 0, 166, 140, 42);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glColor4f(1f, 1f, 1f, 1f);

            String error = "You don't have the";
            String error2 = "correct requirements to";
            String error3 = "continue.";
            fontRendererObj.drawString(ColourEnumHelper.WHITE + error, x + 20 + xMod, y + 6 + yMod, 4210752);
            fontRendererObj.drawString(ColourEnumHelper.WHITE + error2, x + 8 + xMod, y + 16 + yMod, 4210752);
            fontRendererObj.drawString(ColourEnumHelper.WHITE + error3, x + 50 + xMod, y + 26 + yMod, 4210752);
        }

        if(entity.requirements) {
            int size; if(entity.requiredList.size() < 4) { size = 4; } else { size = entity.requiredList.size(); }
            for (int i = 0; i < size; i++) {
                fontRendererObj.drawString(ColourEnumHelper.WHITE + entity.requiredList.get(i), x + 8 + 12, y + (16 * i) + 50, 4210752);
            }
        } else {
            entity.requiredList.clear();
        }

        this.drawTexturedModalRect(x + 150, y + 25, 176, 14, 24, progress);
        this.buttonList.add(new GuiButton(0, x + 66, y + 116, 60, 20, "Research"));

    }

    @Override
    public void actionPerformed(GuiButton button)
    {
        PlayerResearchEvent.callScanEvent(mc.getMinecraft().thePlayer, mc.getMinecraft().thePlayer.getDisplayName());
        int id = button.id;
        String name = button.displayString;
        Random rand = new Random();
        ItemStack note = entity.getStackInSlot(1);

        if(note != null && note.stackTagCompound != null && !note.stackTagCompound.getBoolean("active")) {
            String researchString = note.stackTagCompound.getString("researchData");
            entity.selected = ResearchRegistry.getResearchFromString(researchString);
        }

        if(name.toLowerCase() == "research" || id == 0)
        {
            if(entity.requirements && entity.selected != null)
            {
                LinkedHashMap<String, String> hashMap = ResearchRegistry.getRequireMap();

                String research = entity.selected.toAdvString();
                String requirementString = hashMap.get(research);
                String[] requireArray = ResearchRegistry.getRequirementsFromStringAsArray(requirementString);

                if(requireArray != null) {
                    List<String> notUnlocked = new ArrayList<String>();

                    for (int i = 0; i < requireArray.length; i++) {
                        if (!(SavePlayerScanData.ScanData.hasPlayerScanned(mc.getMinecraft().thePlayer.getDisplayName(),
                                requireArray[i])) &&
                                !notUnlocked.contains(requireArray[i]) &&
                                !entity.requiredList.contains(requireArray[i]))
                        {
                            notUnlocked.add(requireArray[i]);
                            entity.requiredList.add(requireArray[i]);

                            PlayerResearchEvent.callScanEvent(mc.getMinecraft().thePlayer,
                                    mc.getMinecraft().thePlayer.getDisplayName());

                            entity.canSet = true;
                        }
                    }
                }
                //this.setInventorySlotContents(1, new ItemStack(Electrolysm.researchPaper));
            }
            else
            {
                entity.errorRequirement = true;
            }
            //unlock research
        }

    }

    @Override
    public void onGuiClosed()
    {
        entity.renderActiveScreen = false;
        entity.errorRequirement = false;
        entity.requirements = false;
        entity.requiredList.clear();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        fontRendererObj.drawString(entity.getInventoryName(), 40, 6, 4210752);
    }
}
