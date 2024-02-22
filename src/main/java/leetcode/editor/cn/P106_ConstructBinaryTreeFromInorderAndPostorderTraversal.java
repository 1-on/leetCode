//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1186 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author DY
 * @date 2024-02-21 16:02:09
 */
public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            TreeNode node = buildT(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
            return node;
        }

        public TreeNode buildT(int[] inorder, int[] postorder, int in1, int in2, int pos1, int pos2) {
            if (in1 > in2) return null;
            if (pos1 > pos2) return null;
            TreeNode root = new TreeNode();
            root.val = postorder[pos2];
            int index = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    index = i;
                }
            }
            root.left = buildT(inorder, postorder, in1, index, pos1, pos1 + (index - in1) - 1);
            root.right = buildT(inorder, postorder, index + 1, in2, pos1 + (index - in1), pos2 - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}