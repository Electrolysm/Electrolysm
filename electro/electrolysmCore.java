package assets.electrolysm.electro;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import assets.electrolysm.electro.block.machines.desk;
import assets.electrolysm.electro.block.machines.researchDesk;
import assets.electrolysm.electro.block.machines.workBench;
import assets.electrolysm.electro.client.ClientProxy;
import assets.electrolysm.electro.handlers.Crafting;
import assets.electrolysm.electro.handlers.IDHandler;
import assets.electrolysm.electro.handlers.Names;
import assets.electrolysm.electro.handlers.Referance;
import assets.electrolysm.electro.handlers.Register;
import assets.electrolysm.electro.handlers.RegisterBlock;
import assets.electrolysm.electro.handlers.VersionCheck;
import assets.electrolysm.electro.research.card;
import assets.electrolysm.electro.robotics.artMuscle;
import assets.electrolysm.electro.robotics.bionicArm;
import assets.electrolysm.electro.robotics.bionicChest;
import assets.electrolysm.electro.robotics.bionicHead;
import assets.electrolysm.electro.robotics.bionicLeg;
import assets.electrolysm.electro.robotics.carbonBone;
import assets.electrolysm.electro.robotics.chipDup;
import assets.electrolysm.electro.robotics.metalSheet;
import assets.electrolysm.electro.robotics.microCont;
import assets.electrolysm.electro.robotics.partAssemb;
import assets.electrolysm.electro.robotics.servo;
import assets.electrolysm.electro.robotics.silChip;
import assets.electrolysm.electro.robotics.soldering;
import assets.electrolysm.electro.robotics.upgrade;
import assets.electrolysm.electro.robotics.wire;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


	@Mod(modid=Referance.MOD_REF.MOD_ID, name=Referance.MOD_REF.MOD_ID, version= Referance.MOD_REF.VERSION)

	@NetworkMod(channels = { Referance.MOD_REF.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = packetHandler.class)
	 
	
	public class electrolysmCore {

		public static CreativeTabs TabElectrolysm = new TabElectrolysm(CreativeTabs.getNextID(),"Electrolysm|Basics of Science");

		///Basic Machines
        public static Block workBench = new workBench(IDHandler.machines.basic.workBenchID, null);
        public static Block desk = new desk(IDHandler.machines.basic.deskID, null);
        public static Block researchDesk = new researchDesk(IDHandler.machines.basic.researchDeskID, null);
        //Research System
        public static Item card= new card(IDHandler.research.cardID);
        
		//Robots
        //Parts
        public static Item metalSheet = new metalSheet(IDHandler.robotics.metalSheetID);
        public static Item wire = new wire(IDHandler.robotics.wireID);
        public static Item servo = new servo(IDHandler.robotics.servoID);
        public static Item artMuscle = new artMuscle(IDHandler.robotics.artMuscleID);
        public static Item carbonBone = new carbonBone(IDHandler.robotics.carbonBoneID);
        //=====================Adv. Parts================================
        public static Item microController = new microCont(IDHandler.robotics.microContID);
        public static Item upgrade = new upgrade(IDHandler.robotics.upgradeID);
        public static Item silChip = new silChip(IDHandler.robotics.silChipID);
        public static Item ChipDup = new chipDup(IDHandler.robotics.chipDub);
        //===============================================================
        public static Item bionicArm = new bionicArm(IDHandler.robotics.bionicArmID);
        public static Item bionicChest = new bionicChest(IDHandler.robotics.bionicChestID);
        public static Item bionicHead = new bionicHead(IDHandler.robotics.bionicHeadID);
        public static Item bionicLeg = new bionicLeg(IDHandler.robotics.bionicLegID);
        //====================Machines!==================================
        public static Block soldering = new soldering(IDHandler.robotics.machines.solderingID, null);
        public static Block partAssemb = new partAssemb(IDHandler.robotics.machines.partAssembID, null);
		
/* 
 * ===============================================================================================================
 * ===============================================================================================================
 * 										Config (In game Stuff)
 * ===============================================================================================================
 * ===============================================================================================================
 */
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        	configHandler.init(event.getSuggestedConfigurationFile());

        configHandler.init(event.getSuggestedConfigurationFile());
		VersionCheck.check();

        }
        
		@EventHandler
		public void loadConfiguration(FMLPreInitializationEvent evt){
	    
		Crafting.addCrafting();
		RegisterBlock.register();
		Names.addName();
		Register.addAchievementLocalizations();
		
		}
		
		@SideOnly(Side.CLIENT)
		@EventHandler
	    public void load(FMLInitializationEvent event) {
	        ClientProxy ClientProxy = new ClientProxy();
	        ClientProxy.registerRenderThings();

	}
}

 				
	