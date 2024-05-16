package informatic.modid.HUD.Cardinal;

import informatic.modid.Util.Direction;
import net.minecraft.client.MinecraftClient;

public class CoordRender {

  public static String getCoords(MinecraftClient client) {
    if (client.player == null || client.getWindow() == null) {
      return "";
    }

    int x = (int) client.player.getX();
    int y = (int) client.player.getY();
    int z = (int) client.player.getZ();
    Direction direction = DirectionRender.getDirection(client);

    return switch (direction) {
      case NORTH -> String.format("X: %d, Y: %d, (-)Z: %d", x, y, z);
      case SOUTH -> String.format("X: %d, Y: %d, (+)Z: %d", x, y, z);
      case WEST -> String.format("(-)X: %d, Y: %d, Z: %d", x, y, z);
      case EAST -> String.format("(+)X: %d, Y: %d, Z: %d", x, y, z);
      case NORTHEAST -> String.format("(+)X: %d, Y: %d, (-)Z: %d", x, y, z);
      case SOUTHEAST -> String.format("(+)X: %d, Y: %d, (+)Z: %d", x, y, z);
      case NORTHWEST -> String.format("(-)X: %d, Y: %d, (-)Z: %d", x, y, z);
      case SOUTHWEST -> String.format("(-)X: %d, Y: %d, (+)Z: %d", x, y, z);
      case UNKNOWN -> "";
    };
  }


}
