package informatic.modid.Util.CrosshairData.Types;

import informatic.modid.Util.util;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;

public enum Tool {
  PICKAXE,
  AXE,
  SHOVEL,
  HOE,
  NONE;

  public static Tool getTool(BlockState blockState) {
    if (blockState.isIn(BlockTags.PICKAXE_MINEABLE)) {
      return PICKAXE;
    } else if (blockState.isIn(BlockTags.SHOVEL_MINEABLE)) {
      return SHOVEL;
    } else if (blockState.isIn(BlockTags.AXE_MINEABLE)) {
      return AXE;
    } else if (blockState.isIn(BlockTags.HOE_MINEABLE)) {
      return HOE;
    }
    return NONE;
  }

  public String display() {
    if (this == NONE) {
      return "";
    }
    return util.display(this.toString());
  }
}
