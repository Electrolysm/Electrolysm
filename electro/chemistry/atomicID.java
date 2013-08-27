package mods.Electrolysm.electro.chemistry;

import cpw.mods.fml.client.FMLClientHandler;
import mods.Electrolysm.api.elements.Elements;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class atomicID extends Block {

	private static int help;
	
	public atomicID(int id, Material mat) {
		super(id, Material.iron);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("AtomicID");
		this.setCreativeTab(electrolysmCore.TabElectrolysm);
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	String chatMessage = "This block/item is not registered with elements please contact the " +
    			"MOD developer";
        if(help < 1){
        	if(player.getHeldItem() != null){
        		String elements = Elements.getElementsVanilla(player.getHeldItem());
        		if(!(Elements.blockElements.isEmpty())){
        			chatMessage = player.getHeldItem().getDisplayName() + " is made up of " + elements + " atoms.";
        		}
    	
        		FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(chatMessage);	
        	}
        }
    	if(help > 1){
            help = 0;
        }
        help = help + 1;
       
       if(help >= 2){
           help = 0;
       	}
    	
    	return true;
    }

}
