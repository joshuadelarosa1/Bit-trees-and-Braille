public class BitTreeNode<K> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The key. May not be null.
   */
  K key;

  /*
   * The left subtree.
   */
  BitTreeNode<K> left;

  /*
   * The right subtree
   */
  BitTreeNode<K> right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new bit tree node.
   */
  public BitTreeNode(K key) {
    this.key = key;
    this.left = null;
    this.right = null;
  } // BitTreeNode (K key, V value)


} // class BitTreeNode<K>
