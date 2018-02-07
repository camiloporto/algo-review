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
        if(left != null) {
            left.parent = this;
        }
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if(right != null) {
            right.parent = this;
        }

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

    public TreeNode parent() {return parent;}

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
