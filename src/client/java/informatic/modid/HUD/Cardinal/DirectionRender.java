package informatic.modid.HUD.Cardinal;

import informatic.modid.Util.Direction;
import net.minecraft.client.MinecraftClient;

public class DirectionRender {

  public static Direction getDirection(MinecraftClient client) {
    if (client.player == null) {
      return Direction.UNKNOWN;
    }

    float yaw = client.player.getYaw(1.0F);
    yaw = (yaw % 360 + 360) % 360;  // Normalize the yaw to 0-360

    if (yaw >= 337.5 || yaw < 22.5) {
      return Direction.SOUTH;
    } else if (yaw >= 22.5 && yaw < 67.5) {
      return Direction.SOUTHWEST;
    } else if (yaw >= 67.5 && yaw < 112.5) {
      return Direction.WEST;
    } else if (yaw >= 112.5 && yaw < 157.5) {
      return Direction.NORTHWEST;
    } else if (yaw >= 157.5 && yaw < 202.5) {
      return Direction.NORTH;
    } else if (yaw >= 202.5 && yaw < 247.5) {
      return Direction.NORTHEAST;
    } else if (yaw >= 247.5 && yaw < 292.5) {
      return Direction.EAST;
    } else if (yaw >= 292.5 && yaw < 337.5) {
      return Direction.SOUTHEAST;
    }

    return Direction.UNKNOWN;
  }
}
