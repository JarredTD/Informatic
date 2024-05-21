package informatic.modid.HUD.CrosshairData;

import informatic.modid.HUD.CrosshairData.Block.BlockDataRender;
import informatic.modid.HUD.CrosshairData.Entity.LivingEntityDataRender;
import informatic.modid.Util.CrosshairData.CrosshairData;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class CrosshairDataRender {

  public static CrosshairData getCrosshairData(MinecraftClient client) {

    if (client == null || client.player == null) {
      return null;
    }

    HitResult hitResult = client.crosshairTarget;
    if (hitResult == null) {
      return null;
    }

    if (client.crosshairTarget.getType() == HitResult.Type.BLOCK) {
      return BlockDataRender.getBlockData(client,
          ((BlockHitResult) hitResult).getBlockPos());
    } else if (client.crosshairTarget.getType() == HitResult.Type.ENTITY) {
      return LivingEntityDataRender.getLivingEntityData(
          (LivingEntity) ((EntityHitResult) hitResult).getEntity());
    }

    return null;
  }
}
