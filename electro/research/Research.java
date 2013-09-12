package assets.electrolysm.electro.research;

import java.util.Arrays;
import java.util.List;

public class Research {

	//Ressearch levels
	public static List<String> Level1 = Arrays.asList(researchNotes.reinStone.toString(), "World!", "How", "Are", "You");
	public static String[] Level2 = {"bye", "bye1", "bye2", "bye3"};

	

	public static class researchNotes{
		public static List<String> reinStone = Arrays.asList("stone", "41", "42");
		
		public static String[] NAMES = {"Blast-Proof Stone"};
	}
}
