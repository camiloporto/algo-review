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

    public void insert(int key) {
        TreeNode newNode = new TreeNode(key);
        if(root == null) {
            root = newNode;
        }
        else {
            TreeNode parent = null;
            TreeNode place = root;
            while (place != null) {
                parent = place;
                if(key <= place.key()) {
                    place = place.left();
                }
                else {
                    place = place.right();
                }
            }
            if(key <= parent.key()) {
                parent.setLeft(newNode);
            }
            else {
                parent.setRight(newNode);
            }
        }
    }

    public TreeNode min() {
        return min(this.root);
    }


    public TreeNode max() {
        return max(this.root);
    }

    private TreeNode max(TreeNode root) {
        TreeNode n = root;
        while (n != null && n.right() != null) {
            n = n.right();
        }

        return n;
    }

    public TreeNode sucessor(TreeNode node) {
        if(node.right() != null) {
            return min(node.right());
        }
        else {
            TreeNode n = node;
            TreeNode parent = n.parent();
            while (parent != null && parent.right().equals(n)) {
                n = parent;
                parent = n.parent();
            }
            return parent;
        }
    }

    private TreeNode min(TreeNode root) {
        TreeNode n = root;
        while (n != null && n.left() != null) {
            n = n.left();
        }

        return n;
    }

    public TreeNode predecessor(TreeNode node) {
        if(node.left() != null) {
            return max(node.left());
        }
        else {
            TreeNode n = node;
            TreeNode parent = n.parent();
            while (parent != null && parent.left().equals(n)) {
                n = parent;
                parent = n.parent();
            }
            return parent;
        }
    }

    public void delete(TreeNode node) {
        if(node.left() == null) {
            transplantSubtree(node, node.right());
        }
        else if(node.right() == null) {
            transplantSubtree(node, node.left());
        }
        else {
            TreeNode sucessor = min(node.right());
            if(!sucessor.parent().equals(node)) {
                transplantSubtree(sucessor, sucessor.right());
                sucessor.setRight(node.right());
            }
            transplantSubtree(node, sucessor);
            sucessor.setLeft(node.left());
        }
    }

    private void transplantSubtree(TreeNode toDelete, TreeNode newNode) {
        if(toDelete.isRoot()) {
            this.root = newNode;
        }
        else if(toDelete.parent().left() != null && toDelete.parent().left().equals(toDelete)) {
            toDelete.parent().setLeft(newNode);
        }
        else {
            toDelete.parent().setRight(newNode);
        }

        if(newNode != null) {
            newNode.setParent(toDelete.parent());
        }

        toDelete.setParent(null);
    }
}
