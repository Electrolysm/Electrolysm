package electrolysm.api.powerSystem.upgrades;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public class Upgrade {

    String name = null;

    public Upgrade(String upgrade) {
        name = upgrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
