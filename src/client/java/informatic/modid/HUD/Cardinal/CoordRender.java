package informatic.modid.HUD.Cardinal;

import informatic.modid.Util.Coordinate;
import informatic.modid.Util.Direction;
import net.minecraft.client.MinecraftClient;

public class CoordRender {

  public static Coordinate getPlayerCoordinate(MinecraftClient client) {
    if (client.player == null || client.getWindow() == null) {
      return new Coordinate(0, 0, 0);
    }

    int x = (int) client.player.getX();
    int y = (int) client.player.getY();
    int z = (int) client.player.getZ();
    return new Coordinate(x, y, z);
  }


}
