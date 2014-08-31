package electrolysm.api.powerSystem.upgrades;

import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public class Upgrades {
    public static class SCREENS{
        public static final String UPGRADE = "UPGRADE";
        public static final String SETTINGS = "SETTINGS_";
        public static class SETTINGS{

        }
    }
    public static class UPGRADES{
        public static final String STORAGE = "STORAGE";
        public static final String NETWORK = "NETWORK";
        public static final String SPEED = "SPEED";
        public static List<String> list = new ArrayList<String>(Arrays.asList(new Object[] {STORAGE, NETWORK, SPEED}));
    }
}
