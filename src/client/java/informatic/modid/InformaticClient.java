package informatic.modid;

import informatic.modid.HUDRenderer.BlockDataRenderer;
import informatic.modid.HUDRenderer.CoordRenderer;
import informatic.modid.HUD.HudRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class InformaticClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecraftClient client = MinecraftClient.getInstance();
		CoordRenderer hudRenderer = new CoordRenderer(client);
		BlockDataRenderer blockDataRenderer = new BlockDataRenderer(client);

		HudRenderCallback.EVENT.register(hudRenderer::renderCoords);
		HudRenderCallback.EVENT.register(blockDataRenderer::renderBlockData);
	}
    HudRenderCallback.EVENT.register(hudInfoRender::renderInfo);
  }
}