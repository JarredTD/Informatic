package informatic.modid.HUDRender;


import informatic.modid.Util.Coordinate;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class InfoRender {

  private static final int WHITE = 0xFFFFFF;
  private final MinecraftClient client;

  private int verticalOffset = 10;

  public InfoRender(MinecraftClient client) {
    this.client = client;
  }

  public void renderInfo(DrawContext drawContext, float tickDelta) {

    int width = client.getWindow().getScaledWidth();
    int height = client.getWindow().getScaledHeight();

    renderCoords(drawContext, new Coordinate(width, verticalOffset), CoordRender.getCoords(client));
    verticalOffset += client.textRenderer.fontHeight + 5;

//    renderText(drawContext, new Coordinate(width, verticalOffset), "Yabba Dabba Doo");
    verticalOffset += client.textRenderer.fontHeight + 5;


  }

  public void renderCoords(DrawContext drawContext, Coordinate position, String coords) {

    int x = position.x() - client.textRenderer.getWidth(Text.of(coords));
    int y = position.y();

    drawContext.drawText(
        MinecraftClient.getInstance().textRenderer,
        coords,
        x,
        y,
        WHITE,
        false);
  }

//  public void renderText(DrawContext drawContext, Coordinate position, String text) {
//    int x = position.x() - client.textRenderer.getWidth((Text.of(text)));
//    int y = position.y();
//
//    drawContext.drawText(
//        MinecraftClient.getInstance().textRenderer,
//        text,
//        x,
//        y,
//        WHITE,
//        false);
//  }
}
