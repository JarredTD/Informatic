package informatic.modid.Util.CrosshairData;

public abstract class CrosshairData {

  private String name;

  public CrosshairData() {
    this.name = "";
  }

  public CrosshairData setName(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return this.name;
  }
}


