import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);
    BitTree test = new BitTree(6);

    test.set("101100", "M");
    test.set("101101", "N");

    test.dump(pen);
  }
} // class BrailleASCII
