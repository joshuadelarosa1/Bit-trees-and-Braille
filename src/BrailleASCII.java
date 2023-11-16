import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import org.xml.sax.InputSource;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      System.err.println("Please enter two inputs and try again.");
      System.exit(1);
    }

    switch (args[0]) {
      case "braille":
        break;
      case "ascii":
        break;
      case "unicode":
        break;
      default:
        System.err
            .println("You have not entered a correct input. Here is what you entered: " + args[0]);
        System.err.println("");
    }
  }
} // class BrailleASCII
