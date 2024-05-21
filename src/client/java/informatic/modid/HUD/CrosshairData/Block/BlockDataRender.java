package informatic.modid.HUD.CrosshairData.Block;


import informatic.modid.Util.CrosshairData.BlockData;
import informatic.modid.Util.CrosshairData.Types.Level;
import informatic.modid.Util.CrosshairData.Types.Tool;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;


public class BlockDataRender {

  private final MinecraftClient client;

  public BlockDataRender(MinecraftClient client) {
    this.client = client;
  }

  private static Level getRequiredMiningLevel(Block block) {
    if (block == Blocks.OBSIDIAN || block == Blocks.NETHERITE_BLOCK ||
        block == Blocks.ANCIENT_DEBRIS) {
      return Level.DIAMOND;

    } else if (block == Blocks.DIAMOND_ORE || block == Blocks.DIAMOND_BLOCK ||
        block == Blocks.EMERALD_ORE || block == Blocks.EMERALD_BLOCK ||
        block == Blocks.GOLD_ORE || block == Blocks.GOLD_BLOCK) {
      return Level.IRON;

    } else if (block == Blocks.IRON_ORE || block == Blocks.IRON_BLOCK) {
      return Level.STONE;

    } else {
      return Level.NONE;
    }
  }

  public static BlockData getBlockData(MinecraftClient client, BlockPos pos) {

    if (client.player == null && client.getWindow() == null) {
      return null;
    }

    ClientPlayerEntity player = client.player;

    BlockData blockData = new BlockData();

    World world = player.getEntityWorld();
    BlockState blockState = world.getBlockState(pos);
    Block block = blockState.getBlock();

    blockData
        .setTool(Tool.getTool(blockState))
        .setLevel(getRequiredMiningLevel(block))
        .setName(block.getName().getString());

    return blockData;
  }
}
