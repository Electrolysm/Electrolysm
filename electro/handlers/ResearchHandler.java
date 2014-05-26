package assets.electrolysm.electro.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ResearchHandler
{
    public static String down_file;
    public static int amountOnlineNames;

	public static void downloadSkinByUsername(String username)
    {
		down_file = "config/electrolysm/username.png";
		downloadLabSkin();
        try
        {
            URL website = new URL("http://skins.minecraft.net/MinecraftSkins/" + username + ".png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file.replace("username", username + ""));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void downloadTechTree()
    {
		down_file = "config/electrolysm/techTree.png";
		downloadLabSkin();
        try
        {
            URL website = new URL("https://raw.githubusercontent.com/Electrolysm/Electrolysm/master/electro/research/system/Tech%20Tree.png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
	
	public static void downloadLabSkin()
	{
		try
        {
            URL website = new URL("https://raw.githubusercontent.com/Electrolysm/Electrolysm/master/textures/models/armor/labCoat.png");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(down_file.replace("username", "labCoat"));
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void copyFileToLocation(File aFile, File[] files, String path)
	{
		addFilesToZip(aFile, files, path);
	}
	
	private static void addFilesToZip(File source, File[] files, String path)
	{
	    try
	    {
	        File tmpZip = File.createTempFile(source.getName(), null);
	        tmpZip.delete();
	        if(!source.renameTo(tmpZip))
	        {
	            throw new Exception("Could not make temp file (" + source.getName() + ")");
	        }
	        byte[] buffer = new byte[4096];
	        ZipInputStream zin = new ZipInputStream(new FileInputStream(tmpZip));
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));
	        for(int i = 0; i < files.length; i++)
	        {
	            InputStream in = new FileInputStream(files[i]);
	            out.putNextEntry(new ZipEntry(path + files[i].getName()));
	            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
	            {
	                out.write(buffer, 0, read);
	            }
	            out.closeEntry();
	            in.close();
	        }
	        for(ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
	        {
	            if(!zipEntryMatch(ze.getName(), files, path))
	            {
	                out.putNextEntry(ze);
	                for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
	                {
	                    out.write(buffer, 0, read);
	                }
	                out.closeEntry();
	            }
	        }
	        out.close();
	        tmpZip.delete();
	    }catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}

	private static boolean zipEntryMatch(String zeName, File[] files, String path){
	    for(int i = 0; i < files.length; i++){
	        if((path + files[i].getName()).equals(zeName)){
	            return true;
	        }
	    }
	    return false;
	}
}
