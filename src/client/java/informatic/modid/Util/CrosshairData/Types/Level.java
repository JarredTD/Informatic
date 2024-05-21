package informatic.modid.Util.CrosshairData.Types;

import informatic.modid.Util.util;

public enum Level {

  DIAMOND,
  IRON,
  STONE,
  NONE;

  public String display() {
    if (this == NONE) {
      return "";
    }
    return util.display(this.toString());
  }
}
