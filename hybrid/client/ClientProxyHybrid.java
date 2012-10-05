package hybrid.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import hybridcraft.IngotStuff.CommonProxyHybrid;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyHybrid extends hybridcraft.IngotStuff.CommonProxyHybrid
{
	public void registerRenderThings()
	{
	MinecraftForgeClient.preloadTexture("/hc/tools.png");
	MinecraftForgeClient.preloadTexture("/hc/ingots.png");
	MinecraftForgeClient.preloadTexture("/hc/blocks.png");
	MinecraftForgeClient.preloadTexture("/hc/armor.png");
	MinecraftForgeClient.preloadTexture("/hc/worldblocks.png");
	MinecraftForgeClient.preloadTexture("hc/flowers.png");
	}
	
	@Override
	public int addArmor(String name)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}
