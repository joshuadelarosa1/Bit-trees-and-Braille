import java.io.InputStream;
import java.io.PrintWriter;

public class BitTree {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The number of bits.
   */
  int n;

  /*
   * The root of the tree.
   */
  BitTreeNode<String> root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Builds a tree that will store mappings from strings of n bits to strings.
   */
  public BitTree(int n) {
    this.n = n;
    this.root = null;
  } // BitTree(int n)

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /*
   * Follows the path through the tree given by bits (adding nodes as appropriate) and adds or
   * replaces the value at the end with value. Throws an exception if bits is the inappropriate
   * length or contains values other than 0 or 1.
   */
  public void set(String bits, String value) throws Exception {
    if (bits.length() != this.n) {
      throw new Exception("Invalid number of characters");
    }

    if (this.root == null) {
      this.root = new BitTreeNode<String>("");
    }

    BitTreeNode<String> current = this.root;
    int i = 0;

    while (i < bits.length()) {
      if (bits.charAt(i) == '0') {
        if (current.left == null) {
          current.left = new BitTreeNode<String>("0");
          current = current.left;
        } else {
          current = current.left;
        }
      } else if (bits.charAt(i) == '1') {
        if (current.right == null) {
          current.right = new BitTreeNode<String>("1");
          current = current.right;

        } else {
          current = current.right;
        }
      } else {
        throw new Exception("Invalid input in bits. Please only use '0' or '1'");
      } 
      i++;
    }

    current.left = new BitTreeLeaf<String, String>(bits, value);
  } // set(String bits, String value)

  /*
   * Follows the path through the tree given by bits, returning the value at the end. If there is no
   * such path, or if bits is the incorrect length, get throws an exception.
   */
  public String get(String bits) throws Exception {
    if (bits.length() != n) {
      throw new Exception("Invalid number of characters.");
    }

    if (this.root == null) {
      this.root = new BitTreeNode<String>("");
    }

    BitTreeNode<String> current = this.root;
    int i = 0;
    String result = "";

    while (i < bits.length()) {
      if (bits.charAt(i) == '0') {
        if (current == null) {
          throw new Exception("Not a valid key");
        }
        current = current.left;
      } else if (bits.charAt(i) == '1') {
        if (current == null) {
          throw new Exception("Not a valid key");
        }
        current = current.right;
      }

      i++;
    }

    if (current == null) {
      throw new Exception("Not a valid key");
    }

    BitTreeLeaf<String, String> temp = (BitTreeLeaf<String, String>) current.left;
    result = temp.value.toString();

    return result;
  } // get(String bits)

  /*
   * Prints out the contents of the tree in CSV forma.
   */
  public void dump(PrintWriter pen) {
    BitTreeNode<String> current = this.root;

    dump(pen, current);
  } // dump(PrintWriter pen)

  /*
   * Reads a series of lines of the form bits,value and stores them in the tree.
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream source)

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /*
   * Helper functino for dump, prints out keys and values
   */
  public void dump(PrintWriter pen, BitTreeNode<String> current) {
    if (current.left == null && current.right == null) {
      BitTreeLeaf<String, String> result = (BitTreeLeaf<String, String>) current;
      pen.println(result.key + ", " + result.value);
      return;
    }

    if (current.left != null) {
      dump(pen, current.left);
    }

    if (current.right != null) {
      dump(pen, current.right);
    }
  } // dump(PrintWriter pen, BitTreeNode<String> current)

} // class BitTree
