package informatic.modid.HUDRenderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class HUDRenderer {

    private final MinecraftClient client;

    public HUDRenderer(MinecraftClient client) {
        this.client = client;
    }

    public void renderCoords(DrawContext drawContext, float tickDelta) {
        if (client.player != null && client.getWindow() != null) {
            // Coordinates as String

            int x = (int) client.player.getX();
            int y = (int) client.player.getY();
            int z = (int) client.player.getZ();
            String direction = client.player.getFacing().toString();
            String coords = String.format("x: %d, y: %d, z: %d, d: %s", x, y, z, direction);

            int windowWidth = client.getWindow().getScaledWidth();
            int textWidth = client.textRenderer.getWidth(Text.of(coords));
            int textX = windowWidth - textWidth - 5;
            int textY = 5;
            int color = 0xFFFFFF; // White color

            // Drawing the text
            drawContext.drawText(MinecraftClient.getInstance().textRenderer, coords, textX, textY, color, false);
        }
    }
}
