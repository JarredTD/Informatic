package informatic.modid;

import informatic.modid.HUDRender.InfoRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

public class InformaticClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    MinecraftClient client = MinecraftClient.getInstance();
    InfoRender hudInfoRender = new InfoRender(client);

    HudRenderCallback.EVENT.register(hudInfoRender::renderInfo);
  }
}