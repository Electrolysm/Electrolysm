package mods.Electrolysm.electro.data;

import java.util.Random;

import org.bouncycastle.crypto.prng.RandomGenerator;

import com.google.common.collect.Range;

import scala.util.*;

public class data {

	
	
	public static int IC2Multiplyer = 2;
	public static int IC2Divider = 2;
	public static int CombWantedEU = 20;
	public static int AverWantEU = (CombWantedEU) / 1;
	public static int wastedRate = (AverWantEU / 100) * 2;
	public static int combCap = 50;
	public static int combCurrentEnergy = 50;


	//Hidden Matter Name
	public static String hiddenMatterDustName;
	public static String hiddenMatterIngotName;
	public static int hiddenMatterFound;
	
	
}