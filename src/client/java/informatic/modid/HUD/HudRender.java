package informatic.modid.HUD;

import informatic.modid.HUD.Cardinal.CoordRender;
import informatic.modid.HUD.Cardinal.DirectionRender;
import informatic.modid.HUD.CrosshairData.CrosshairDataRender;
import informatic.modid.HUD.Ecological.BiomeRender;
import informatic.modid.Util.Cardinal.Coordinate;
import informatic.modid.Util.CrosshairData.BlockData;
import informatic.modid.Util.CrosshairData.CrosshairData;
import informatic.modid.Util.CrosshairData.LivingEntityData;
import informatic.modid.Util.Cardinal.Direction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.Optional;

public class HudRender {

  private static final int WHITE = 0xFFFFFF;
  private static final float TEXT_SCALE = .82f;
  private static final int VERTICAL_OFFSET_INCREMENT = 2;
  private static final int HORIZONAL_OFFSET_INCREMENT = 5;
  private final MinecraftClient client;

  private int horizontalOffset;
  private int verticalOffset;

  public HudRender(MinecraftClient client) {
    this.client = client;
    resetOffsets();
  }

  private void resetOffsets() {
    this.horizontalOffset = HORIZONAL_OFFSET_INCREMENT;
    this.verticalOffset = VERTICAL_OFFSET_INCREMENT;
  }

  public void renderInfo(DrawContext drawContext, float ignoredTickDelta) {
    if (client == null || client.world == null) {
      return;
    }

    int width = client.getWindow().getScaledWidth();

    drawContext.getMatrices().push();
    drawContext.getMatrices().scale(TEXT_SCALE, TEXT_SCALE, 1f);

    int scaledWidth = (int) (width / TEXT_SCALE);
    resetOffsets();

    RegistryKey<DimensionType> dimensionTypeKey = getDimensionTypeKey();
    Coordinate playerCoordinate = CoordRender.getPlayerCoordinate(client);
    Direction direction = DirectionRender.getDirection(client);

    renderPlayerCoordinate(drawContext, scaledWidth, playerCoordinate, direction, dimensionTypeKey);
    renderDirection(drawContext, scaledWidth, direction.toString());
    renderBiome(drawContext, scaledWidth, BiomeRender.getBiome(client));
    renderCrosshairData(drawContext, scaledWidth, CrosshairDataRender.getCrosshairData(client));

    drawContext.getMatrices().pop();
  }

  private RegistryKey<DimensionType> getDimensionTypeKey() {
    if (client.world == null) {
      return null;
    }

    Optional<RegistryKey<DimensionType>> dimension = client.world.getDimensionEntry().getKey();
    return dimension.orElse(null);
  }

  private void renderPlayerCoordinate(DrawContext drawContext, int screenWidth,
      Coordinate playerPOS, Direction direction,
      RegistryKey<DimensionType> dimensionType) {
    if (dimensionType == null) {
      return;
    }

    if (dimensionType == DimensionTypes.OVERWORLD) {
      drawText(drawContext, "Overworld " + playerPOS.display(direction), screenWidth);
      drawText(drawContext, "Nether " + playerPOS.toNether().display(direction), screenWidth);
    } else if (dimensionType == DimensionTypes.THE_NETHER) {
      drawText(drawContext, "Nether " + playerPOS.display(direction), screenWidth);
      drawText(drawContext, "Overworld " + playerPOS.toOverworld().display(direction), screenWidth);
    } else {
      drawText(drawContext, playerPOS.display(direction), screenWidth);
    }
  }

  private void renderDirection(DrawContext drawContext, int screenWidth, String direction) {
    drawText(drawContext, direction, screenWidth);
  }

  private void renderBiome(DrawContext drawContext, int screenWidth, String biome) {
    drawText(drawContext, biome, screenWidth);
  }

  private void renderCrosshairData(DrawContext drawContext, int screenWidth,
      CrosshairData crosshairData) {

    if (crosshairData == null) {
      return;
    }

    switch (crosshairData) {
      case LivingEntityData livingEntityData -> {
        drawText(drawContext, livingEntityData.getName(), screenWidth);
        drawText(drawContext, Float.toString(livingEntityData.getHealth()), screenWidth);
      }
      case BlockData blockData -> {
        drawText(drawContext, blockData.getName(), screenWidth);

        String toolAndLevel = String.format("%s %s", blockData.getLevel().display(),
            blockData.getTool().display());

        drawText(drawContext, toolAndLevel, screenWidth);
      }
      default -> {
      }
    }
  }

  private void drawText(DrawContext drawContext, String text, int screenWidth) {
    int scaledHorizontalOffset = (int) (horizontalOffset / TEXT_SCALE);
    int scaledVerticalOffset = (int) (verticalOffset / TEXT_SCALE);

    int x = screenWidth - client.textRenderer.getWidth(Text.of(text)) - scaledHorizontalOffset;
    int y = scaledVerticalOffset;

    drawContext.drawText(client.textRenderer, Text.of(text), x, y, WHITE, false);

    verticalOffset += (int) ((client.textRenderer.fontHeight * TEXT_SCALE)
        + VERTICAL_OFFSET_INCREMENT);
  }
}
