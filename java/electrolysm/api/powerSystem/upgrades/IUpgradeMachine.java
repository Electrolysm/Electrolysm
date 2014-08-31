package electrolysm.api.powerSystem.upgrades;

/**
 * Created by Clarky158 on 31/08/2014.
 */
public interface IUpgradeMachine {

    public boolean canUpgrade();

    public boolean doesUpgradeFit(Upgrade upgrade);
}
