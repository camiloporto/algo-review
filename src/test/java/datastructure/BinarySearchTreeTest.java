package datastructure;

import algorithm.ArrayTestHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Created by camiloporto on 2/2/18.
 */
public class BinarySearchTreeTest {

    @Test
    public void shouldFindByKey() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(8);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(13);
        TreeNode n9 = new TreeNode(18);
        TreeNode n10 = new TreeNode(11);
        TreeNode n11 = new TreeNode(14);
        TreeNode n12 = new TreeNode(17);
        TreeNode n13 = new TreeNode(19);

        root.setLeft(n1);
        root.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n3.setLeft(n6);
        n3.setRight(n7);

        n2.setLeft(n8);
        n2.setRight(n9);

        n8.setLeft(n10);
        n8.setRight(n11);

        n9.setLeft(n12);
        n9.setRight(n13);

        BinaryTree t = new BinaryTree(root);
        Assert.assertEquals(10, t.findByKey(10).key());
        Assert.assertEquals(15, t.findByKey(15).key());
        Assert.assertEquals(5, t.findByKey(5).key());
        Assert.assertEquals(1, t.findByKey(1).key());
        Assert.assertEquals(3, t.findByKey(3).key());
        Assert.assertEquals(17, t.findByKey(17).key());
        Assert.assertEquals(19, t.findByKey(19).key());
        Assert.assertEquals(18, t.findByKey(18).key());

        Assert.assertNull(t.findByKey(50));
    }

    @Test
    public void shouldTraverseInOrder() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(15);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(8);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(13);
        TreeNode n9 = new TreeNode(18);
        TreeNode n10 = new TreeNode(11);
        TreeNode n11 = new TreeNode(14);
        TreeNode n12 = new TreeNode(17);
        TreeNode n13 = new TreeNode(19);

        root.setLeft(n1);
        root.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n3.setLeft(n6);
        n4.setLeft(n7);

        n2.setLeft(n8);
        n2.setRight(n9);

        n8.setLeft(n10);
        n8.setRight(n11);

        n9.setLeft(n12);
        n9.setRight(n13);

        BinaryTree t = new BinaryTree(root);
        List<Integer> elementsInOrder = t.getInOrder();
        Assert.assertEquals(Arrays.asList(1, 3, 5, 6, 8, 10, 11, 13, 14, 15, 17, 18, 19), elementsInOrder);

    }

    @Test
    public void shouldInsertNewElement() {
        BinaryTree tree = new BinaryTree();

        tree.insert(1);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);

        Assert.assertEquals(1, tree.findByKey(1).key());
        Assert.assertEquals(8, tree.findByKey(8).key());
        Assert.assertEquals(4, tree.findByKey(4).key());
        Assert.assertEquals(2, tree.findByKey(2).key());
        Assert.assertEquals(13, tree.findByKey(13).key());
        Assert.assertEquals(18, tree.findByKey(18).key());
        Assert.assertEquals(9, tree.findByKey(9).key());
        Assert.assertEquals(7, tree.findByKey(7).key());
        Assert.assertEquals(12, tree.findByKey(12).key());
    }

    @Test
    public void shouldFindMin() {
        BinaryTree tree = new BinaryTree();

        tree.insert(1);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);

        Assert.assertEquals(1, tree.min().key());

        Assert.assertNull(new BinaryTree().min());

        tree = new BinaryTree();
        tree.insert(1);
        Assert.assertEquals(1, tree.min().key());

    }

    @Test
    public void shouldFindMax() {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);

        Assert.assertEquals(18, tree.max().key());

        Assert.assertNull(new BinaryTree().max());

        tree = new BinaryTree();
        tree.insert(1);
        Assert.assertEquals(1, tree.max().key());

    }

    @Test
    public void shouldFindSucessor() {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);

        Assert.assertEquals(7, tree.sucessor(tree.findByKey(4)).key());
        Assert.assertEquals(12, tree.sucessor(tree.findByKey(10)).key());
        Assert.assertEquals(8, tree.sucessor(tree.findByKey(7)).key());
        Assert.assertEquals(10, tree.sucessor(tree.findByKey(9)).key());
        Assert.assertNull(tree.sucessor(tree.findByKey(18)));

    }

    @Test
    public void shouldFindPredecessor() {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);

        Assert.assertEquals(9, tree.predecessor(tree.findByKey(10)).key());
        Assert.assertEquals(10, tree.predecessor(tree.findByKey(12)).key());
        Assert.assertEquals(2, tree.predecessor(tree.findByKey(4)).key());
        Assert.assertEquals(13, tree.predecessor(tree.findByKey(18)).key());
        Assert.assertNull(tree.predecessor(tree.findByKey(2)));

    }

    @Test
    public void testHugeTree() {
        ArrayTestHelper arrayTestHelper = new ArrayTestHelper();
        int[] sample = arrayTestHelper.randomArrayWithMaxValue(10000000, new Random());
        BinaryTree tree = new BinaryTree();
        for(int i = 0; i < sample.length; i++) {
            tree.insert(sample[i]);
        }


        int[] copyOfSample = Arrays.copyOf(sample, sample.length);
        Arrays.sort(sample);
        List<Integer> inOrder = tree.getInOrder();

        for(int i = 0; i < inOrder.size(); i++) {
            Assert.assertEquals(sample[i], inOrder.get(i).intValue());
        }

        for(int i = 0; i < inOrder.size(); i++) {
            Assert.assertEquals(sample[i], tree.findByKey(sample[i]).key());
        }

        for(int i = 0; i < copyOfSample.length; i++) {
            tree.delete(tree.findByKey(copyOfSample[i]));
        }

        Assert.assertTrue(tree.getInOrder().isEmpty());

    }

    @Test
    public void shouldDeleteByKey() {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(2);
        tree.insert(13);
        tree.insert(18);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);

        tree.delete(tree.findByKey(7));
        tree.delete(tree.findByKey(15));
        tree.delete(tree.findByKey(8));
        tree.delete(tree.findByKey(10));


        List<Integer> elementsInOrder = tree.getInOrder();
        Assert.assertEquals(Arrays.asList(2, 4, 9, 12, 13, 18), elementsInOrder);
    }

    //FIXME implement
    // min/max Tree Height

}
