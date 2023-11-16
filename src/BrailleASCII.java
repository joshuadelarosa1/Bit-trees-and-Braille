import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import org.xml.sax.InputSource;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BitTree test = new BitTree(6);
    InputStream alphabet = new FileInputStream("BrailleAlphabet.txt");

    test.load(alphabet);
    test.dump(pen);
  }
} // class BrailleASCII
