package cn.leetcode.`101`

class IsSymmetric {

    fun isSymmetric(root: TreeNode?): Boolean {
        return if (root == null) {
            true
        } else isSymmetric(root.left, root.right)
    }

    fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        return if (left != null && right != null && left.`val` == right.`val`) {
            isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
        } else false
    }

    class TreeNode internal constructor(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }
}