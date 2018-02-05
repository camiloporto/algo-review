package datastructure;

/**
 * Created by camiloporto on 2/2/18.
 */
public class TreeNode {

    private int key;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(int key) {
        this.key = key;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        left.parent = this;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        right.parent = this;
    }

    public int key() {
        return key;
    }

    public TreeNode left() {
        return this.left;
    }

    public TreeNode right() {
        return this.right;
    }
}
