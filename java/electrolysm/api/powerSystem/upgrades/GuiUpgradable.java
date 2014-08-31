package electrolysm.api.powerSystem.upgrades;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import org.apache.commons.lang3.text.WordUtils;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public class GuiUpgradable extends GuiContainer
{
    TileEntity entity;
    String guiState = null;

    public GuiUpgradable(Container container, TileEntity te) {
        super(container);
        entity = te;
        update();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        String name = button.displayString.toUpperCase();
        guiState = name;
        update();
    }

    protected void update() {
        buttonList.clear();
        new ContainerUpgradable(entity, guiState);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        if (guiState != null) {
            for (int i = 0; i < Upgrades.UPGRADES.list.size(); i++) {
                buttonList.add(i, new GuiButtonInvisible(i, x + 5, y + 10 + (16 * i), 50, 16,
                        WordUtils.capitalizeFully(Upgrades.UPGRADES.list.get(i))));
            }
        } else {
            buttonList.add(0, new GuiButton(0, x + 5, y + 5, 10, 10, "Upgrade"));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        update();
    }
}
