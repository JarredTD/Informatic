package informatic.modid.HUD.CrosshairData.Entity;

import informatic.modid.Util.CrosshairData.LivingEntityData;
import java.util.Objects;
import net.minecraft.entity.LivingEntity;

public class LivingEntityDataRender {

  public static LivingEntityData getLivingEntityData(LivingEntity entity) {

    LivingEntityData entityData = new LivingEntityData();

    entityData
        .setHealth(entity.getHealth())
        .setName(Objects.requireNonNull(entity.getDisplayName()).getString());

    return entityData;
  }
}
