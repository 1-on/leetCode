//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 365 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

import java.util.Arrays;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * @author DY
 * @date 2024-02-22 17:15:12
 */
public class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
        int[] nums1 = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] nums2 = new int[]{4, 5, 2, 6, 7, 3, 1};
        solution.constructFromPrePost(nums1, nums2);
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            TreeNode treeNode = buildT(preorder, postorder, 0, postorder.length - 1, 0, postorder.length - 1);
            return treeNode;
        }

        public TreeNode buildT(int[] preorder, int[] postorder, int pre1, int pre2, int pos1, int pos2) {
            if (pre1 > pre2) return null;
            if (pos1 > pos2) return null;
            if (pre1 == pre2 && pos1 == pos2) {
                TreeNode treeNode = new TreeNode();
                treeNode.val = preorder[pre1];
                return treeNode;
            }
            TreeNode root = new TreeNode();
            root.val = preorder[pre1];
            int leftIndex = pre1 + 1;
            int rightVal = postorder[pos2 - 1];
            int rightIndex = 0;
            for (int i = 0; i < preorder.length; i++) {
                if (preorder[i] == rightVal) {
                    rightIndex = i;
                    break;
                }
            }

            root.left = buildT(preorder, postorder, pre1 + 1, rightIndex - 1, pos1, pos1 + (rightIndex - leftIndex - 1));
            root.right = buildT(preorder, postorder, rightIndex, pre2, pos1 + (rightIndex - leftIndex - 1) + 1, pos2 - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}