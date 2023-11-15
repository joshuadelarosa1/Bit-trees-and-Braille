public class BitTreeLeaf<K, V> extends BitTreeNode<K> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The key. May not be null.
   */
  K key;

  /*
   * The value inside the key. Only avaialabe on leaves.
   */
  V value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Creates a new BitTreeLeaf with a key and a value;
   */
  public BitTreeLeaf(K key, V value) {
    super(key);
    this.key = key;
    this.value = value;
  } // BitTreeLeaf(K key, V value)

} // class BitTreeLeaf<K, V> extends BitTreeNode<K>
