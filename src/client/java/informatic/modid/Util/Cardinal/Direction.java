package informatic.modid.Util.Cardinal;

public enum Direction {
  NORTH,
  SOUTH,
  WEST,
  EAST,
  NORTHEAST,
  SOUTHEAST,
  NORTHWEST,
  SOUTHWEST,

  UNKNOWN;

  @Override
  public String toString() {
    return switch (this) {
      case NORTH -> "North";
      case SOUTH -> "South";
      case WEST -> "West";
      case EAST -> "East";
      case NORTHEAST -> "Northeast";
      case SOUTHEAST -> "Southeast";
      case NORTHWEST -> "Northwest";
      case SOUTHWEST -> "Southwest";
      case UNKNOWN -> "Unknown";
    };
  }
}
