package electro.handlers;

import java.io.File;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onSoundLoad(SoundLoadEvent event) 
	{
		File dataDir = Minecraft.getMinecraft().mcDataDir;
		
		//event.manager.soundPoolSounds.addSound("electrolysm:sound_antimatter.ogg");
		
	}

}