package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;
import hybridcraft.FoodStuff.HybridModFoodStuff;

public class ContainerCounter extends ContainerWorkbench {

	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerCounter(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
		super(par1InventoryPlayer, par2World, par3, par4, par5);
		this.worldObj = par2World;
		this.posX = par3;
		this.posY = par4;
		this.posZ = par5;
	}

	@Override
	public void onCraftMatrixChanged(IInventory par1IInventory) {
		this.craftResult.setInventorySlotContents(0, CounterManager.getInstance().findMatchingRecipe(this.craftMatrix));
	}

	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != HybridModFoodStuff.counter.blockID ? false : par1EntityPlayer.getDistanceSq((double) this.posX + 0.5D, (double) this.posY + 0.5D, (double) this.posZ + 0.5D) <= 64.0D && (this.worldObj.getBlockId(this.posX + 1, this.posY, this.posZ) == HybridModFoodStuff.stove.blockID || this.worldObj.getBlockId(this.posX - 1, this.posY, this.posZ) == HybridModFoodStuff.stove.blockID || this.worldObj.getBlockId(this.posX, this.posY, this.posZ + 1) == HybridModFoodStuff.stove.blockID || this.worldObj.getBlockId(this.posX, this.posY, this.posZ - 1) == HybridModFoodStuff.stove.blockID);
	}
}
