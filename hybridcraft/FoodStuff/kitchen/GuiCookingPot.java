package hybridcraft.FoodStuff.kitchen;

import net.minecraft.src.*;

public class GuiCookingPot extends GuiContainer {

	public GuiCookingPot(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
		super(new ContainerCookingPot(par1InventoryPlayer, par2World, par3, par4, par5));
	}

	protected void drawGuiContainerForegroundLayer() {
		fontRenderer.drawString("Cooking Pot", 28, 6, 0x404040);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		int i = mc.renderEngine.getTexture("/gui/crafting.png");
		org.lwjgl.opengl.GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(i);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}
}
