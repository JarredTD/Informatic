package informatic.modid;

import informatic.modid.HUDRenderer.HUDRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class InformaticClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecraftClient client = MinecraftClient.getInstance();
		HUDRenderer hudRenderer = new HUDRenderer(client);

		HudRenderCallback.EVENT.register(hudRenderer::renderCoords);
	}
}