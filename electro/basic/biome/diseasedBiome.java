package mods.Electrolysm.electro.basic.biome;

import java.util.Collection;

import mods.Electrolysm.electro.electrolysmCore;
import mods.Electrolysm.electro.biology.entity.EntityZombie_Scientist;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class diseasedBiome extends BiomeGenBase {

	public diseasedBiome(int par1) {
		super(par1);

	this.setBiomeName("Diseased Biome");
	this.topBlock = (byte)electrolysmCore.diseasedGrass.blockID;
	this.fillerBlock = (byte)Block.dirt.blockID;
	this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie_Scientist.class, 5, 3, 4));
	this.setDisableRain();
	this.setTemperatureRainfall(10000, 0);
	}

}
