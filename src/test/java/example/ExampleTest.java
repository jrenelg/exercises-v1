package example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ExampleTest {
    Example example = new Example();

    @Test
    public void LadderLengthTest() {
        Assert.assertEquals(5, example.ladderLength("hit", "cog",
                new java.util.LinkedList<>(Arrays.asList("hot", "dot", "kot", "xot", "zot", "dog", "lot", "log", "cog"))));
    }

    @Test
    public void candyDistributionTest() {
        Assert.assertEquals(3, example.treatsDistribution(new int[]{2, 2, 3, 3, 4, 4}));
        Assert.assertEquals(4, example.treatsDistribution(new int[]{2, 2, 3, 3, 4, 4, 5, 6}));
        Assert.assertEquals(4, example.treatsDistribution(new int[]{2, 2, 3, 3, 4, 4, 5, 6, 7}));
    }

    @Test
    public void kSmallestNumberTest() {
        Assert.assertEquals(5, example.kSmallestNumber(new int[]{10, 7, 11, 5, 27, 3, 4}, 3));
        Assert.assertEquals(5, example.kSmallestNumber(new int[]{7,4,8,0,2,1,5}, 5));
    }

    @Test
    public void coinChangeTest() {
        Assert.assertEquals(3, example.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    public void ReverseString() {
        Assert.assertEquals("olleH", example.reverseString("Hello"));
        Assert.assertEquals("maS", example.reverseString("Sam"));

    }

    @Test
    public void ReverseInt() {
        Assert.assertEquals(321, example.reverseInteger(123));
        Assert.assertEquals(-321, example.reverseInteger(-123));
    }

    @Test
    public void findBottomLeftValueTest() {
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(9);

        Assert.assertEquals(5, example.findBottomLeftValue(tree));
    }

    @Test
    public void zigzagTraversalTest() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.right = new TreeNode(6);

        Assert.assertEquals("13246", example.zigzagTraversal(tree));
    }

    @Test
    public void sortedTwoSumTest() {
        Assert.assertEquals(new int[] {1, 2}, example.sortedTwoSum(new int[] {1, 3, 7, 9, 11}, 10));
    }


    @Test
    public void Naive() {
        Assert.assertEquals(0, example.fibonacciNative(0));
        Assert.assertEquals(1, example.fibonacciNative(1));
        Assert.assertEquals(1, example.fibonacciNative(2));
        Assert.assertEquals(2, example.fibonacciNative(3));
        Assert.assertEquals(3, example.fibonacciNative(4));
        Assert.assertEquals(5, example.fibonacciNative(5));
        Assert.assertEquals(8, example.fibonacciNative(6));
        Assert.assertEquals(13, example.fibonacciNative(7));
        Assert.assertEquals(21, example.fibonacciNative(8));
    }

    @Test
    public void Memoized() {
        Assert.assertEquals(0, example.fibonacciMemoized(0));
        Assert.assertEquals(1, example.fibonacciMemoized(1));
        Assert.assertEquals(1, example.fibonacciMemoized(2));
        Assert.assertEquals(2, example.fibonacciMemoized(3));
        Assert.assertEquals(3, example.fibonacciMemoized(4));
        Assert.assertEquals(5, example.fibonacciMemoized(5));
        Assert.assertEquals(8, example.fibonacciMemoized(6));
        Assert.assertEquals(13, example.fibonacciMemoized(7));
        Assert.assertEquals(21, example.fibonacciMemoized(8));
    }
}
