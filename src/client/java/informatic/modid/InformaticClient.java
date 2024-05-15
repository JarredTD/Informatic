package informatic.modid;

import informatic.modid.HUDRenderer.CoordRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class InformaticClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecraftClient client = MinecraftClient.getInstance();
		CoordRenderer hudRenderer = new CoordRenderer(client);

		HudRenderCallback.EVENT.register(hudRenderer::renderCoords);
	}
}