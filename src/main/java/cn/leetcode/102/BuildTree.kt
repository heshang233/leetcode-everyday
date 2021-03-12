package cn.leetcode.`102`

import cn.huangsy.BuildTree

/**
 * @author huangsy
 * @date 2020/5/22 8:33
 */
class BuildTree {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return node(inorder, preorder, Int.MAX_VALUE)
    }

    var `in` = 0
    var pre = 0

    private fun node(inorder: IntArray, preorder: IntArray, stop: Int): TreeNode? {
        if (pre == preorder.size) {
            return null
        }
        if (inorder[`in`] == stop) {
            `in`++
            return null
        }
        val x = preorder[pre++]
        val treeNode = TreeNode(x)
        treeNode.left = node(inorder, preorder, x)
        treeNode.right = node(inorder, preorder, stop)
        return treeNode
    }

    class TreeNode internal constructor(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val preorder = intArrayOf(3, 9, 20, 15, 7)
            val inorder = intArrayOf(9, 3, 15, 20, 7)
            val buildTree = BuildTree()
            val treeNode = buildTree.buildTree(preorder, inorder)
        }
    }
}
