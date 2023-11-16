import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BrailleASCIITables {

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+


  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /*
   * Converts an ASCII character to a string of bits representing the corresponding braille
   * character.
   */
  public static String toBraille(char letter) {
    int treeSize = 8;
    BitTree toBrailleTree = new BitTree(treeSize);

    try {
      InputStream conversion = new FileInputStream("ASCIIToBraille.txt");
      toBrailleTree.load(conversion);

      String chString = Character.toString(letter);
      String result = toBrailleTree.get(chString);
      return result;

    } catch (FileNotFoundException e) {
      System.err.println("Could load file: ASCIIToBraille.txt");
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("Could not find the following char: " + letter);
      e.printStackTrace();
    }

    return "";
  } // toBraille(char letter)

  /*
   * Converts a string of bits representing a braille character to the corresponding ASCII
   * character.
   */
  public static String toASCII(String bits) {
    int treeSize = 6;
    BitTree toASCIITree = new BitTree(treeSize);

    try {
      InputStream conversion = new FileInputStream("BrailleToASCII.txt");
      toASCIITree.load(conversion);

      String result = toASCIITree.get(bits);
      return result;

    } catch (FileNotFoundException e) {
      System.err.println("Could not load file: BrailleToASCII.txt");
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("Could not find the following bit: " + bits);
      e.printStackTrace();
    }

    return "";
  } // toASCII(String bits)

  /*
   * Converts a string of bits representing a braille character to the corresponding Unicode braille
   * character for those bits.
   */
  public static String toUnicode(String bits) {
    int treeSize = 6;
    BitTree toUnicodeTree = new BitTree(treeSize);

    try {
      InputStream conversion = new FileInputStream("BrailleToUnicode.txt");
      toUnicodeTree.load(conversion);

      String result = toUnicodeTree.get(bits);
      return result;

    } catch (FileNotFoundException e) {
      System.err.println("Could not load file: BrailleToUnicode.TXT");
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("Could not find the following bit: " + bits);
      e.printStackTrace();
    }

    return "";
  } // toUnicode(String bits)

} // class BrailleASCIITables
