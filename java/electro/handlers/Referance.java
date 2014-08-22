package electro.handlers;

public class Referance
{
    public @interface MOD_REF
    {
        public static String MOD_ID = "Electrolysm";
        public static String MOD_ID_LOWER = MOD_ID.toLowerCase();
        public static String VERSION = "1.1.3";
        public static String CHANNEL = "Electrolysm";
    }

    public static String MOD_ID_LOWER = (Referance.MOD_REF.MOD_ID.toLowerCase());
}
