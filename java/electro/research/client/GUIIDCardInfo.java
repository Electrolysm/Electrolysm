package electro.research.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import electro.Electrolysm;
import electro.common.CommonProxy;
import electro.handlers.helpers.ColourEnumHelper;
import electro.handlers.helpers.EncryptionHelper;
import electro.research.common.SavePlayerScanData;
import electro.research.researchDevice;
import electro.research.system.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.apache.commons.lang3.text.WordUtils;
import org.lwjgl.opengl.GL11;

public class GUIIDCardInfo extends GuiScreen {

    // public static GuiLexicon currentOpenLexicon = new GuiLexicon();
    public static ItemStack stackUsed;

    public static final int BOOKMARK_START = 1337;
    //public static List<GuiLexicon> bookmarks = new ArrayList();
    boolean bookmarksNeedPopulation = false;

    public static final ResourceLocation texture = CommonProxy.BOOK;

    public static String screen;
    public static List<String> researchList = new ArrayList<String>();
    public boolean nextPage;

    String title;
    int guiWidth = 146;
    int guiHeight = 180;
    int left, top;
    int itemsPerPage = 12;//change to 100
    int homeID = itemsPerPage + 1;
    int backID = homeID + 1;
    int forwardID = backID + 1;

    int acrossAlter = -55;
    int upAlter = -20;

    @Override
    public void initGui() {

        super.initGui();

        Item inHand = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem();
        if(inHand instanceof researchDevice)
        {
            researchDevice device = (researchDevice)inHand;

            device.setUse(true);
        }


        title = "Scientist's Encyclopedia";
        //currentOpenLexicon = this;

        left = width / 2 - guiWidth / 2;
        top = height / 2 - guiHeight / 2;

        //hight = 475
        //System.out.println((guiHeight - 10) / 16);

        buttonList.clear();
        if(true) {
            int x = 48 + acrossAlter;
            for(int i = 0; i < itemsPerPage; i++) {
                int y = 11 + (i * 12);
                buttonList.add(new GuiButtonInvisible(i, left + x, top + y /*+ 5 */+ upAlter, 110, 10, ""));
            }
            buttonList.add(new GuiButtonInvisible(homeID, left + x - 30, top + 9 + upAlter, 20, 20, "home"));
            buttonList.add(new GuiButtonInvisible(backID, left + x + 170, top + 10 + upAlter, 20, 20, "back"));
            buttonList.add(new GuiButtonInvisible(forwardID, left + x + 165, top + 30 + upAlter, 20, 20, "forward"));

            //screen = null;
            populateScreen(screen);
        }
        // populateBookmarks();
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        guiWidth = 512 / 2;
        guiHeight = (512 / 2) - 20;

        //this.drawImage(screen);

        //new SavePlayerScanData.ResearchData(mc.thePlayer.getDisplayName(), "carbon_nano_tubes");
        //this.initGui();

        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        drawTexturedModalRect(left + 15  + acrossAlter, top - 30 + upAlter, 0, 0, guiWidth, guiHeight);

        drawTexturedModalRect(left + 18 + acrossAlter, top + 11 + upAlter, 0, 494, 19, 18);//Home
        drawTexturedModalRect(left + 221 + acrossAlter, top + 11 + upAlter, 19, 494, 19, 18);//back
        drawTexturedModalRect(left + 221 + acrossAlter, top + 34 + upAlter, 38, 494, 19, 18);//next

        drawBookmark(left + guiWidth / 2, top - getTitleHeight(), title, true);
        String subtitle = null;

        if(screen != null && screen.contains("_image"))
        {
            this.drawImage(screen.replace("_image", ""), this.getPositionForName(screen.replace("_image", "")));
        }


        super.drawScreen(par1, par2, par3);
    }

    public int getPositionForName(String name)
    {
        if(name == null) { return -2; }
        if(ResearchTextRegistry.getInfoFromResearch(ResearchRegistry.getResearch(name)) == null) { return -2; }

        int top = 0, middle = 1, bottom = 2;

        int length = ResearchTextRegistry.getInfoFromResearch(ResearchRegistry.getResearch(name)).length;
        int divLength = (length / itemsPerPage);
        int finalPage = length - (itemsPerPage * divLength);

        if(finalPage == 12)
        {
            return top;
        }
        else if(finalPage < (itemsPerPage / 2))
        {
            return bottom;
        }
        else if (finalPage < (itemsPerPage / 4))
        {
            return middle;
        }

        return -2;
    }


    public void drawBookmark(int x, int y, String s, boolean drawLeft) {
        // This function is called from the buttons so I can't use fontRendererObj
        FontRenderer font = Minecraft.getMinecraft().fontRenderer;
        boolean unicode = font.getUnicodeFlag();
        font.setUnicodeFlag(true);
        int l = font.getStringWidth(s.trim());
        int fontOff = 0;

        if(!drawLeft) {
            x += l / 2;
            fontOff = 2;
        }

        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        //Draws title
        GL11.glColor4f(1F, 1F, 1F, 1F);
        font.drawString(ColourEnumHelper.WHITE + s, x - l / 2 + fontOff + acrossAlter, y - 10 + upAlter, 0x111111, false);
        font.setUnicodeFlag(unicode);
    }

    //When button is pressed
    @Override
    protected void actionPerformed(GuiButton button)
    {
        //new ResearchRegistry(true);
        int id = button.id;
        String name = button.displayString.toLowerCase().replace(" ", "_")
                .replace(ColourEnumHelper.WHITE.toString(), "").replace(ColourEnumHelper.BLACK.toString(), "");
        HashMap<String, EnumResearchType> typeMap = EnumResearchType.getHashMap();
        Set<String> keySet = typeMap.keySet();

        if(keySet.contains(name)) {
            EnumResearchType type = ResearchRegistry.getEnumFromString(name);
            List<String> list = new ArrayList<String>();

            for (int i = 0; i < ResearchRegistry.getResearchMap().size(); i++) {
                Set<String> set = ResearchRegistry.getResearchMap().keySet();
                Research research = ResearchRegistry.getResearchFromString(ResearchRegistry.getResearchMap().get(set.toArray()[i]));

                //System.out.println(research.getType().getName());

                if (research != null && type != null) {
                    if (research.getType().getName().contains(type.getName())) {
                        list.add(research.toAdvString());
                    }
                }
            }

            this.researchList = list;
            screen = name;
            this.populateScreen(screen);
        }
        else if(id == this.homeID || id == this.backID || id == this.forwardID)
        {
            if(id == this.homeID)
            {
                screen = null;
                this.populateScreen(screen);

                return;
                //System.out.println("homeID");
            }
            else if(id == this.forwardID)
            {
                nextPage = true;
                this.populateScreen(screen);
            }
            else if(id == this.backID)
            {
                nextPage = false;
                screen = screen.replace("_image", "");
                this.populateScreen(screen);
            }
        }
        else
        {
            //research info rendering here!
            //System.out.println(ResearchRegistry.getResearch(name) + ":" + name);
            if(ResearchRegistry.getResearch(name) != null)
            {
                //System.out.println("research");
                screen = name;
                this.populateScreen(screen);
            }
            else
            {
                if(name != "") {
                    if (!isShiftKeyDown()) {
                        String message = ColourEnumHelper.RED + "You haven't unlocked this project yet...";
                        mc.thePlayer.addChatMessage(new ChatComponentTranslation(message));

                        this.populateScreen(screen);
                    } else {
                        screen = null;
                        int slot = mc.thePlayer.inventory.getFirstEmptyStack();
                        Research research = null;
                        research = ResearchRegistry.getResearch(EncryptionHelper.decode(name));

                        if(mc.thePlayer.inventory.hasItemStack(new ItemStack(Electrolysm.inkAndQuill)) && slot >= 0 &&
                                research != null)
                        {
                            if(PlayerResearchEvent.hasPlayerUnlockedReliants(research, mc.thePlayer)) {
                                String message = ColourEnumHelper.BRIGHT_GREEN + "Your idea has been recorded on paper";
                                mc.thePlayer.addChatMessage(new ChatComponentTranslation(message));
                                this.populateScreen(screen);
                                mc.thePlayer.inventory.setInventorySlotContents(
                                        slot, new ItemStack(Electrolysm.researchPaper));
                                mc.thePlayer.inventory.getStackInSlot(slot).stackTagCompound = new NBTTagCompound();
                                mc.thePlayer.inventory.getStackInSlot(slot).stackTagCompound.setString("researchData",
                                        research.toAdvString());
                            }
                        }
                        else
                        {
                            String message = ColourEnumHelper.RED + "You don't have the sufficient tools to make notes...";
                            mc.thePlayer.addChatMessage(new ChatComponentTranslation(message));
                            this.populateScreen(screen);
                        }
                    }
                }
                else
                {
                    this.populateScreen(screen);
                }
            }
        }

        if(((GuiButtonInvisible)(buttonList.get(itemsPerPage - 1))).displayString == "")
        {
            if(screen != null || screen != "") {
                this.showImages();
            }
        }

    }

    public void drawImage(String name, int pos/*, int heightDefault*/)
    {
        int imageWidth = 200, imageHeight = 150;
        int[] positionY = new int[] {-2, 35, 75};
        if(hasImage(name))
        {
            ResourceLocation location = CommonProxy.IMAGE_THE_BASICS;
            this.mc.renderEngine.bindTexture(location);
            drawTexturedModalRect(left + 55 + acrossAlter, top + positionY[pos] + upAlter, 0, 0, imageWidth, imageHeight);
        }
    }

    public ResourceLocation getImage(String name)
    {
        return null;
    }

    public boolean hasImage(String name)
    {
        if(ResearchRegistry.getResearch(name) != null)
        {
            Research research = ResearchRegistry.getResearch(name);
            return research.hasImage();
        }

        return false;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public int bookmarkWidth(String b) {
        boolean unicode = fontRendererObj.getUnicodeFlag();
        fontRendererObj.setUnicodeFlag(true);
        int width = fontRendererObj.getStringWidth(b) + 15;
        fontRendererObj.setUnicodeFlag(unicode);
        return width;
    }

    int getTitleHeight() {
        return 12;
    }

    private void populateScreen(String screen1)
    {
        for(int i = 0; i < buttonList.size(); i++)
        {
            GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);
            button.displayString = "";
            button.enabled = true;
        }

        if(screen1 == "nothing") { return; }

        HashMap<String, EnumResearchType> typeMap = EnumResearchType.getHashMap();
        Set<String> keySet = typeMap.keySet();

        //home
        if(screen1 == null)
        {
            int size; if(keySet.size() >= buttonList.size()) { size = buttonList.size(); } else { size = keySet.size(); }

            for(int i = 0; i < size; i++) {
                GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i);

                button.displayString = ColourEnumHelper.WHITE + WordUtils.capitalize(String.valueOf(
                        typeMap.keySet().toArray()[i]).replace("_", " "));
                //button.setHeight(20);
                //button.setWidth(100);
            }
        }
        //research list from enum
        else if(keySet.contains(screen1))
        {
            List<String> list = researchList;

            //System.out.println(list.size());
            int value = 0;
            int x = 0;
            int size; if(list.size() >= buttonList.size()) { size = buttonList.size(); } else { size = list.size(); }

            if(nextPage && list.size() >= itemsPerPage) { x =+ 12; value =+ 12; nextPage = false; } else { x = 0; value = 0; }

            for(int i = x; i < size + x; i++)
            {
                if(i >= itemsPerPage + x || i >= list.size()) { return; }
                String researchName = ResearchRegistry.getResearchFromString(list.get(i)).getName();
                //System.out.println(SavePlayerScanData.ResearchData.hasPlayerUnlocked(mc.thePlayer.getDisplayName(), researchName));

                if((SavePlayerScanData.ResearchData.hasPlayerUnlocked(mc.thePlayer.getDisplayName() + "_active", researchName)))
                {
                    GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i - x);

                    button.displayString = (ColourEnumHelper.WHITE + WordUtils.capitalize(String.valueOf(
                            researchName.replace("_", " "))));
                }
                else
                {
                    GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i - x);

                    button.displayString = (ColourEnumHelper.BLACK + WordUtils.capitalize(String.valueOf(
                            (EncryptionHelper.encode(researchName)).replace("_", " "))));
                }
            }
        }
        //research information
        else if(ResearchRegistry.getResearch(screen1) != null)
        {
            String[] text = ResearchTextRegistry.getInfoFromResearch(ResearchRegistry.getResearch(screen1));

            if(text != null)
            {
                int x = 0, value = 0;
                int size = 0; if(text.length >= buttonList.size()) { size = buttonList.size(); } else { size = text.length; }
                if(nextPage && text.length >= itemsPerPage) { x =+ 12; value =+ 12; nextPage = false; } else { x = 0; value = 0; }


                for (int i = x; i < size + x; i++)
                {
                    if(i >= (itemsPerPage + x) || i >= text.length) { return; }
                    if(i >= (itemsPerPage + x) || i >= text.length) { return; }

                    GuiButtonInvisible button = (GuiButtonInvisible) buttonList.get(i - x);
                    GuiButtonInvisible buttonPic = (GuiButtonInvisible) buttonList.get(i - x + 1);

                    button.displayString = ColourEnumHelper.WHITE + text[i];
                    button.enabled = false;

                    if((i - x + 1) > itemsPerPage) { return; }
                    if(this.hasImage(screen1)) {
                        //buttonPic.displayString = ColourEnumHelper.BRIGHT_GREEN + "          Click to view images!";
                        //this.showImages();e
                    }
                }
            }
        }

    }

    public void showImages()
    {
        if(screen != null) {
            //nextPage = false;
            //this.populateScreen(screen.replace("_image", "").replace("image", ""));

            if(((GuiButtonInvisible)buttonList.get(itemsPerPage - 1)).displayString == "") {
                nextPage = true;
            }
            else{
                nextPage = false;
            }
            this.populateScreen(screen.replace("_image", "").replace("image", ""));
            screen = screen + "_image";
        }
    }

    @Override
    public void onGuiClosed()
    {
        Item inHand = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getItem();
        if(inHand instanceof researchDevice)
        {
            researchDevice device = (researchDevice)inHand;

            device.setUse(false);
        }

        this.screen = null;
    }
}