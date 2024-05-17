package informatic.modid.Cartographic;

import java.util.concurrent.*;

import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.WorldChunk;

public class MapProcess {

  private final MinecraftClient client;
  private static ChunkPos latestChunk;


  public MapProcess(MinecraftClient client) {
    this.client = client;
  }

  public void processMap(MinecraftServer ignoredMinecraftServer) {
    if (client == null || client.player == null) {
      return;
    }

    ChunkPos currentChunk = new ChunkPos((client.player.getBlockPos()));
    if (currentChunk.equals(latestChunk)) {
      return;
    }
    latestChunk = currentChunk;
    World clientWorld = client.player.clientWorld;

    int updateRadius = 4;
    try {
      ExecutorService executor = Executors.newFixedThreadPool(4);
      for (int dx = -updateRadius; dx <= updateRadius; dx++) {
        for (int dz = -updateRadius; dz <= updateRadius; dz++) {
          final int finalDx = dx;
          final int finalDz = dz;
          executor.submit(() -> {
            ChunkPos pos = new ChunkPos(currentChunk.x + finalDx, currentChunk.z + finalDz);
            if (clientWorld.isChunkLoaded(pos.x, pos.z)) {
              WorldChunk chunk = clientWorld.getWorldChunk(pos.getStartPos());
              if (chunk.getStatus().isAtLeast(ChunkStatus.FULL)) {
//                processChunk(chunk);
              }
            }
          });
        }
      }
      executor.shutdown();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void processChunk(WorldChunk chunk) {
    for (int x = 0; x < 16; x++) {
      for (int z = 0; z < 16; z++) {
        for (int y = chunk.getHeight() - 1; y >= 0; y--) {
          BlockPos pos = new BlockPos(x, y, z);
          BlockState blockState = chunk.getBlockState(pos);
          if (!blockState.isAir()) {
            System.out.println("Block at " + pos + ": " + blockState);
            break;
          }
        }
      }
    }
  }
}
