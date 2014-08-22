package electrolysm.electro.handlers;

public class MultipartHandler
{
    private static MultipartHandler instance = null;

    public static MultipartHandler getInstance()
    {
        if (instance == null) {
            instance = new MultipartHandler();
        }
        return instance;
    }
	
	public MultipartHandler()
	{
        this.addMultiparts();
	}

	private void addMultiparts()
	{/*
        BlockMicroMaterial.createAndRegister(Electrolysm.blastBrick, "Blast Proof Iron Brick");
        BlockMicroMaterial.createAndRegister(Electrolysm.blastProof, "Blast Proof Iron Block");
        BlockMicroMaterial.createAndRegister(Electrolysm.BlockLumRed, "Luminous Redstone Block");
        BlockMicroMaterial.createAndRegister(Electrolysm.diseaseGrass, "Diseased Grass");
        BlockMicroMaterial.createAndRegister(Electrolysm.graphite, "Graphite");
        BlockMicroMaterial.createAndRegister(Electrolysm.stoneObsidian, "Stone");
        BlockMicroMaterial.createAndRegister(Electrolysm.sulphurOre, "Sulphur Ore");*/
	}
}