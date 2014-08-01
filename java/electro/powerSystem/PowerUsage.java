package electro.powerSystem;

import electro.Electrolysm;
import net.minecraft.block.Block;

public class PowerUsage
{
	public static int CRUSHER = 14;
	public static int ELECTROLYSIS = 62;
	public static int SMELTORY = 19;

    public static int SOLAR_PANEL = 2;
    public static int GENERATOR = 3;
    public static int ADV_GENERATOR = 19;
    public static int THERMAL_GENERATOR = 42;
    public static int ANTIMATTER = 100000;

    public static int getTeUFromBlock(Block block)
    {
        if(block == Electrolysm.crusher) { return CRUSHER; }
        else if(block == Electrolysm.electrolisisCore) { return ELECTROLYSIS; }
        else if(block == Electrolysm.smeltory) { return SMELTORY; }
        else if(block == Electrolysm.crusherActive) { return CRUSHER; }
        else if(block == Electrolysm.smeltoryActive) { return SMELTORY; }

        else if(block == Electrolysm.solarPanel) { return SOLAR_PANEL; }
        else if(block == Electrolysm.generator) { return GENERATOR; }
        else if(block == Electrolysm.advancedGenerator) { return ADV_GENERATOR; }
        else if(block == Electrolysm.thermalGenerator) { return THERMAL_GENERATOR; }
        else if(block == Electrolysm.matterGen) { return ANTIMATTER; }
        else if(block == Electrolysm.genActive) { return GENERATOR; }
        else if(block == Electrolysm.advGenActive) { return ADV_GENERATOR; }
        return 0;
    }
}
