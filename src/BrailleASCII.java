import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import org.xml.sax.InputSource;

/**
 * Driver class for implementation of BitTrees
 * 
 * @author Joshua Delarosa
 * 
 */
public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      System.err.println("Please enter two inputs and try again.");
      System.exit(1);
    }

    switch (args[0]) {
      case "braille":
        String resultBraille = "";
        String upper = args[1].toUpperCase();
        char argArray[] = upper.toCharArray();

        for (char temp : argArray) {
          resultBraille += BrailleASCIITables.toBraille(temp);
        }
        System.out.println(resultBraille);

        break;
      case "ascii":
        String resultASCII = "";
        String[] splitString = args[1].split("(?<=\\G.{6})");

        for (String ASCIITemp : splitString) {
          resultASCII += BrailleASCIITables.toASCII(ASCIITemp);
        }
        System.out.println(resultASCII);

        break;
      case "unicode":
        String resultUnicode = BrailleASCIITables.toUnicode(args[1]);
        String[] unicodeSplit = resultUnicode.split("(?<=\\G.{4})");
        String finalUnicode = "";

        for (String unicodeTemp : unicodeSplit) {
          int hexVal = Integer.parseInt(unicodeTemp, 16);
          finalUnicode += (char) hexVal;
        }
        
        pen.println(finalUnicode);
        break;
      default:
        System.err.print("You have not entered a correct input.");
        System.err.println(" Here is what you entered: " + args[0]);
        System.err.print("Correct inputs are 'braille' 'ascii' & 'unicode' followed by ");
        System.err.println("the desired string");
    }
  }
} // class BrailleASCII
