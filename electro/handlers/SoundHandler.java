package assets.electrolysm.electro.handlers;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler {

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event) 
	{
		File dataDir = Minecraft.getMinecraft().mcDataDir;
		
		event.manager.soundPoolSounds.addSound("electrolysm:sound_antimatter.ogg");
		
	}

}