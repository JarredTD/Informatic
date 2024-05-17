package informatic.modid.HUD.Ecological;

import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;


public class BiomeRender {

  public static String getBiome(MinecraftClient client) {
    if (client.player == null || client.world == null) {
      return "Unknown";
    }

    BlockPos pos = client.player.getBlockPos();
    RegistryEntry<Biome> biomeEntry = client.world.getBiomeAccess().getBiome(pos);
    Biome biome = biomeEntry.value();
    Identifier biomeId = client.world.getRegistryManager().get(RegistryKeys.BIOME).getId(biome);

    return biomeId != null ? prettify(biomeId.getPath()) : "Unknown";
  }

  private static String prettify(String text) {
    text = text.replace("_", " ");

    String[] words = text.split(" ");

    StringBuilder formattedString = new StringBuilder();
    for (String word : words) {
      if (!text.isEmpty()) {
        formattedString.append(Character.toUpperCase(word.charAt(0)))
            .append(word.substring(1).toLowerCase())
            .append(" ");
      }
    }
    return formattedString.toString().trim();
  }
}
