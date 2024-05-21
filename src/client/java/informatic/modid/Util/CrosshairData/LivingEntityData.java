package informatic.modid.Util.CrosshairData;

public class LivingEntityData extends CrosshairData {

  private float health;

  public LivingEntityData() {
    super();
    this.health = -1;
  }

  public float getHealth() {
    return health;
  }

  public LivingEntityData setHealth(float health) {
    this.health = health;
    return this;
  }
}
