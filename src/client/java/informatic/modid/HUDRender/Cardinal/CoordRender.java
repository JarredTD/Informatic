package informatic.modid.HUDRender;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CoordRender {

  public static String getCoords(MinecraftClient client) {
    if (client.player != null && client.getWindow() != null) {

      int x = (int) client.player.getX();
      int y = (int) client.player.getY();
      int z = (int) client.player.getZ();
      String direction = client.player.getFacing().toString();

      return String.format("x: %d, y: %d, z: %d, d: %s", x, y, z, direction);
    }
    return "";
  }
}
