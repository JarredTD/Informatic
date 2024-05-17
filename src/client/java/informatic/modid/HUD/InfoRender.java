package informatic.modid.HUD;


import informatic.modid.HUD.Cardinal.CoordRender;
import informatic.modid.HUD.Cardinal.DirectionRender;
import informatic.modid.HUD.Ecological.BiomeRender;
import informatic.modid.Util.Coordinate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class InfoRender {

  private static final int WHITE = 0xFFFFFF;
  private final MinecraftClient client;

  private int horizontalOffset = 5;

  public InfoRender(MinecraftClient client) {
    this.client = client;
  }

  public void renderInfo(DrawContext drawContext, float ignoredTickDelta) {

    // Reset offset per tick
    int verticalOffset = 5;
    horizontalOffset = 5;

    int width = client.getWindow().getScaledWidth();
    int height = client.getWindow().getScaledHeight();

    renderCoords( // Coordinates
        drawContext,
        new Coordinate(width, verticalOffset),
        CoordRender.getCoords(client));

    verticalOffset += client.textRenderer.fontHeight + 5;

    renderDirection( // Direction
        drawContext,
        new Coordinate(width, verticalOffset),
        DirectionRender.getDirection(client).toString());

    verticalOffset += client.textRenderer.fontHeight + 5;

    renderBiome( // Biome
        drawContext,
        new Coordinate(width, verticalOffset),
        BiomeRender.getBiome(client));

    verticalOffset += client.textRenderer.fontHeight + 5;

  }

  public void renderCoords(DrawContext drawContext, Coordinate position, String coords) {

    int x = position.x() - client.textRenderer.getWidth(Text.of(coords)) - horizontalOffset;
    int y = position.y();

    drawContext.drawText(
        MinecraftClient.getInstance().textRenderer,
        coords,
        x,
        y,
        WHITE,
        false);
  }

  public void renderDirection(DrawContext drawContext, Coordinate position, String direction) {
    int x = position.x() - client.textRenderer.getWidth((Text.of(direction))) - horizontalOffset;
    int y = position.y();

    drawContext.drawText(
        MinecraftClient.getInstance().textRenderer,
        direction,
        x,
        y,
        WHITE,
        false);
  }

  public void renderBiome(DrawContext drawContext, Coordinate position, String biome) {
    int x = position.x() - client.textRenderer.getWidth((Text.of(biome))) - horizontalOffset;
    int y = position.y();

    drawContext.drawText(
        MinecraftClient.getInstance().textRenderer,
        biome,
        x,
        y,
        WHITE,
        false);
  }
}
