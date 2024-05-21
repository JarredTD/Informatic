package informatic.modid.Util;

public class util {

  public static String display(String word) {
    if (word == null || word.isEmpty()) {
      return word;
    }
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }
}
