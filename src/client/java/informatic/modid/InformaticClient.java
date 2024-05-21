package informatic.modid;

import informatic.modid.HUD.HudRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class InformaticClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    MinecraftClient client = MinecraftClient.getInstance();
    HudRender hudInfoRender = new HudRender(client);

    HudRenderCallback.EVENT.register(hudInfoRender::renderInfo);
  }
}