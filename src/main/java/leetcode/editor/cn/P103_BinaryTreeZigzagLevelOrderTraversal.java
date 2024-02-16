//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 849 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author DY
 * @date 2024-02-16 01:54:20
 */
public class P103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            boolean flag = true;
            Queue<TreeNode> queue = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (!flag) {
                    Collections.reverse(list);
                }
                flag = !flag;
                res.add(list);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}