package informatic.modid;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
public class InformaticClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		MinecraftClient client = MinecraftClient.getInstance();
		HUDRenderer hudRenderer = new HUDRenderer(client);

		HudRenderCallback.EVENT.register(hudRenderer::renderCoords);
	}
}