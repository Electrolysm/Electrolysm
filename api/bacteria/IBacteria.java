package mods.Electrolysm.api.bacteria;

import java.util.Random;

public class IBacteria {

	public static String trate1;
	public static String trate2;
	public static String trate3;
	public static String trate4;
	
	public static void setFirstTrate(Random random, int chosenTrate){
		chosenTrate = random.nextInt(trateList.trates1.length);
		int trateLists[] = {trateList.trates1.length};
	
	for(int cT = 0; cT < trateLists.length; cT++){
		trate1 = trateList.trates1[cT];
		
	System.out.println(trate1);
		}	
	
	}
}
