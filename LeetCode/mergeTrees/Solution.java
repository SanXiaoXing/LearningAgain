package mergeTrees;

import javax.swing.tree.TreeNode;

/**
 * @Author: SanXiaoXing
 * @Date: 2024/06/24/22:11
 * @Description:
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 代表两棵树合并的解决方案的类。
 * 该类的主要作用是通过递归方式合并两棵二叉树。
 */
public class Solution {
    /**
     * 合并两棵二叉树的函数。
     *
     * @param root1 第一棵二叉树的根节点。
     * @param root2 第二棵二叉树的根节点。
     * @return 返回合并后的二叉树的根节点。
     *
     * 合并的规则是将两棵树的对应节点的值相加，并递归地合并子树。
     * 如果某棵树的根节点为空，则直接返回另一棵树的根节点。
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果root1为空，则直接返回root2，表示第一棵树已经被完全合并到第二棵树中
        if (root1 == null) {
            return root2;
        }
        // 如果root2为空，则直接返回root1，表示第二棵树已经被完全合并到第一棵树中
        if (root2 == null) {
            return root1;
        }
        // 创建一个新的节点，其值为root1和root2的值之和，然后递归合并左右子树
        return new TreeNode( root1.val + root2.val ,
                mergeTrees(root1.left,root2.left),
                mergeTrees(root1.right,root2.right));
    }
}

