package informatic.modid.Util.CrosshairData;

import informatic.modid.Util.CrosshairData.Types.Level;
import informatic.modid.Util.CrosshairData.Types.Tool;

public class BlockData extends CrosshairData {

  private Tool tool;
  private Level level;

  public BlockData() {
    super();
    this.tool = Tool.NONE;
    this.level = Level.NONE;
  }

  public Tool getTool() {
    return tool;
  }

  public BlockData setTool(Tool tool) {
    this.tool = tool;
    return this;
  }

  public Level getLevel() {
    return level;
  }

  public BlockData setLevel(Level level) {
    this.level = level;
    return this;
  }
}
