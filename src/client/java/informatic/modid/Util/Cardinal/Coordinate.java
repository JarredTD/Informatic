package informatic.modid.Util;

public record Coordinate(int x, int y, int z) {

  public Coordinate(int x, int y) {
    this(x, y, 0);
  }


  public String display(Direction direction) {
    return switch (direction) {
      case NORTH -> String.format("X: %d, Y: %d, (-)Z: %d", this.x, this.y, this.z);
      case SOUTH -> String.format("X: %d, Y: %d, (+)Z: %d", this.x, this.y, this.z);
      case WEST -> String.format("(-)X: %d, Y: %d, Z: %d", this.x, this.y, this.z);
      case EAST -> String.format("(+)X: %d, Y: %d, Z: %d", this.x, this.y, this.z);
      case NORTHEAST -> String.format("(+)X: %d, Y: %d, (-)Z: %d", this.x, this.y, this.z);
      case SOUTHEAST -> String.format("(+)X: %d, Y: %d, (+)Z: %d", this.x, this.y, this.z);
      case NORTHWEST -> String.format("(-)X: %d, Y: %d, (-)Z: %d", this.x, this.y, this.z);
      case SOUTHWEST -> String.format("(-)X: %d, Y: %d, (+)Z: %d", this.x, this.y, this.z);
      case UNKNOWN -> "Unknown";
    };
  }

  public Coordinate toNether() {
    return new Coordinate(this.x / 8, this.y / 8, this.z / 8);
  }

  public Coordinate toOverworld() {
    return new Coordinate(this.x * 8, this.y * 8, this.z * 8);
  }

}
