package hybrid.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import hybridcraft.IngotStuff.CommonProxyHybrid;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxyHybrid extends hybridcraft.CommonProxyHybrid
{
	public void registerRenderThings()
	{
	MinecraftForgeClient.preloadTexture("/hc/armor.png");
	MinecraftForgeClient.preloadTexture("/hc/blocks.png");
	MinecraftForgeClient.preloadTexture("/hc/flowers.png");
	MinecraftForgeClient.preloadTexture("/hc/foods.png");
	MinecraftForgeClient.preloadTexture("/hc/ingots.png");
	MinecraftForgeClient.preloadTexture("/hc/kitchen.png");
	MinecraftForgeClient.preloadTexture("/hc/sandwich.png");
	MinecraftForgeClient.preloadTexture("/hc/tools.png");
	MinecraftForgeClient.preloadTexture("/hc/worldblocks.png");
	
	//mobs
	MinecraftForgeClient.preloadTexture("/hc/mob/creepig.png");
	}
	
	@Override
	public int addArmor(String name)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}
