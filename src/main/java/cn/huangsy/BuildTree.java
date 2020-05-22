package cn.huangsy;

/**
 * @author huangsy
 * @date 2020/5/22 8:33
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return node(inorder, preorder, Integer.MAX_VALUE);
    }

    int in = 0, pre = 0;

    private TreeNode node(int[] inorder, int[] preorder, int stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in ++;
            return null;
        }

        int x = preorder[pre++];
        TreeNode treeNode = new TreeNode(x);
        treeNode.left = node(inorder, preorder, x);
        treeNode.right = node(inorder, preorder, stop);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
    }
}


