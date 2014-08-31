package electrolysm.api.powerSystem.upgrades;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

/**
 * Created by Clarky158 on 21/06/2014.
 */
public class GuiButtonInvisible extends GuiButton {

    public GuiButtonInvisible(int id, int x, int y, int length, int height, String str) {
        super(id, x, y, length, height, str);
    }

    @Override
    public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
        field_146123_n = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
        int k = getHoverState(field_146123_n);

        boolean unicode = par1Minecraft.fontRenderer.getUnicodeFlag();
        par1Minecraft.fontRenderer.setUnicodeFlag(true);
        par1Minecraft.fontRenderer.drawString(displayString, xPosition + (k == 2 ? 5 : 0), yPosition + (height - 8) / 2, 0);
        par1Minecraft.fontRenderer.setUnicodeFlag(unicode);
    }
}