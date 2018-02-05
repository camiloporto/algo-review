package datastructure;

import com.sun.org.glassfish.gmbal.Description;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by camiloporto on 2/2/18.
 */
public class BinaryTree {

    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public BinaryTree() {}

    public TreeNode findByKey(int key) {
        return find(root, key);
    }

    private TreeNode find(TreeNode node, int key) {
        if(node == null) return null;
        if(node.key() == key) return node;
        if(key <= node.key()) {
            return find(node.left(), key);
        }
        else {
            return find(node.right(), key);
        }
    }

    public List<Integer> getInOrder() {
        List elements = new ArrayList();
        inOrder(elements);
        return elements;
    }

    private void inOrder(List elements) {
        inOrder(root, elements);
    }

    private void inOrder(TreeNode root, List elements) {
        if(root == null) return;
        inOrder(root.left(), elements);
        elements.add(root.key());
        inOrder(root.right(), elements);
    }

    public void insert(int key) {
        TreeNode newNode = new TreeNode(key);
        if(root == null) {
            root = newNode;
        }
        else {
            TreeNode parent = root;
            boolean foundParent = false;
            while (!foundParent) {
                if(newNode.key() <= parent.key()) {
                    if(parent.left() == null) {
                        foundParent = true;
                        parent.setLeft(newNode);
                    }
                    else {
                        parent = parent.left();
                    }
                }
                else {
                    if(parent.right() == null) {
                        foundParent = true;
                        parent.setRight(newNode);
                    }
                    else {
                        parent = parent.right();
                    }
                }
            }
        }
    }

    //recursive version of insertion node...
    /*
    private void insert(TreeNode root, TreeNode newNode) {
        if(newNode.key() <= root.key()) {
            if(root.left() == null) {
                root.setLeft(newNode);
            }
            else {
                insert(root.left(), newNode);
            }
        }
        else {
            if(root.right() == null) {
                root.setRight(newNode);
            }
            else {
                insert(root.right(), newNode);
            }
        }
    }
    */
}
