package mods.Electrolysm.electro.advAtomics.lasers.TileEntity;

import cpw.mods.fml.client.FMLClientHandler;
import mods.Electrolysm.electro.electrolysmCore;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityLaserGen extends TileEntity {

	public static boolean built;
	public static int check = 0;

	
	@Override
	public void updateEntity() {
		

		 //FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage("If laser is ready " + this.built);

			
			if(worldObj.getBlockId(xCoord + 4, yCoord, zCoord) == electrolysmCore.laserDiff.blockID){
				
				if(worldObj.getBlockId(xCoord + 7, yCoord, zCoord) == electrolysmCore.laserAmp.blockID){
					if(worldObj.getBlockId(xCoord + 7, yCoord, zCoord + 2) == electrolysmCore.laserAmp.blockID){
						if(worldObj.getBlockId(xCoord + 7, yCoord, zCoord - 2) == electrolysmCore.laserAmp.blockID){
							
			if(worldObj.getBlockId(xCoord + 10, yCoord, zCoord) == electrolysmCore.laserAmp.blockID){
				if(worldObj.getBlockId(xCoord + 10, yCoord, zCoord + 2) == electrolysmCore.laserAmp.blockID){
					if(worldObj.getBlockId(xCoord + 10, yCoord, zCoord - 2) == electrolysmCore.laserAmp.blockID){
						
			if(worldObj.getBlockId(xCoord + 13, yCoord, zCoord) == electrolysmCore.laserDiff.blockID){
				if(worldObj.getBlockId(xCoord + 16, yCoord, zCoord) == electrolysmCore.laserBoiler.blockID
						/*|| worldObj.getBlockId(xCoord + 16, yCoord, zCoord) == electrolysmCore.laserBoiler_Active.blockID*/){

					this.built = true;
											}else{
												this.built = false;
											}
										}else{
											this.built = false;
										}
									}else{
										this.built = false;
									}
								}else{
									this.built = false;
								}
							}else{
								this.built = false;
							}
						}else{
							this.built = false;
						}
					}else{
						this.built = false;
					}
				}else{
					this.built = false;
				}
			}else{
				this.built = false;
			}
			
			if(this.built){
				if(check > 0){
					worldObj.setBlock(xCoord + 15, yCoord, zCoord, electrolysmCore.fakeLaser.blockID);
					worldObj.setBlock(xCoord + 14, yCoord, zCoord, electrolysmCore.fakeLaser.blockID);
					check = check + 1;
				}
				
				
			}
			
			if(this.built == false){
				check = 0;
				worldObj.setBlockToAir(xCoord + 15, yCoord, zCoord);
				worldObj.setBlockToAir(xCoord + 14, yCoord, zCoord);

			}
		}
	}
