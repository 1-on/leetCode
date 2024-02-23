//给你一棵二叉树的根节点 root 和一个正整数 k 。 
//
// 树中的 层和 是指 同一层 上节点值的总和。 
//
// 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。 
//
// 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,8,9,2,1,3,7,4,6], k = 2
//输出：13
//解释：树中每一层的层和分别是：
//- Level 1: 5
//- Level 2: 8 + 9 = 17
//- Level 3: 2 + 1 + 3 + 7 = 13
//- Level 4: 4 + 6 = 10
//第 2 大的层和等于 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,null,3], k = 1
//输出：3
//解释：最大的层和是 3 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= 10⁶ 
// 1 <= k <= n 
// 
//
// Related Topics 树 广度优先搜索 二叉树 排序 👍 25 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

import java.util.*;

/**
 * 二叉树中的第 K 大层和
 *
 * @author DY
 * @date 2024-02-23 15:27:37
 */
public class P2583_KthLargestSumInABinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2583_KthLargestSumInABinaryTree().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            List<Long> list = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int n = 1;
            int temp = 1;
            int val = 0;
            while (!queue.isEmpty()) {
                long sum = 0;
                n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                list.add(sum);

            }

            Collections.sort(list);
            System.out.println(list);
            if (list.size() < k) {
                return -1;
            }
            return list.get(list.size() - k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}