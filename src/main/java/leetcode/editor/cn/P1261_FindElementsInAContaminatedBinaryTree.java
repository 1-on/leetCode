//给出一个满足下述规则的二叉树： 
//
// 
// root.val == 0 
// 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 
//1 
// 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x 
//+ 2 
// 
//
// 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。 
//
// 请你先还原二叉树，然后实现 FindElements 类： 
//
// 
// FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。 
// bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
//输出：
//[null,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1]); 
//findElements.find(1); // return False 
//findElements.find(2); // return True 
//
// 示例 2： 
//
// 
//
// 输入：
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
//输出：
//[null,true,true,false]
//解释：
//FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
//findElements.find(1); // return True
//findElements.find(3); // return True
//findElements.find(5); // return False 
//
// 示例 3： 
//
// 
//
// 输入：
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
//输出：
//[null,true,false,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
//findElements.find(2); // return True
//findElements.find(3); // return False
//findElements.find(4); // return False
//findElements.find(5); // return True
// 
//
// 
//
// 提示： 
//
// 
// TreeNode.val == -1 
// 二叉树的高度不超过 20 
// 节点的总数在 [1, 10^4] 之间 
// 调用 find() 的总次数在 [1, 10^4] 之间 
// 0 <= target <= 10^6 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 哈希表 二叉树 👍 70 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

/**
 * 在受污染的二叉树中查找元素
 *
 * @author DY
 * @date 2024-03-12 18:53:21
 */
public class P1261_FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P1261_FindElementsInAContaminatedBinaryTree().new Solution();
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
    class FindElements {

        private TreeNode root1;

        public FindElements(TreeNode root) {
            root1 = dfs(root, 0);
//            dfs3(root1);
        }

        public boolean find(int target) {
            return dfs2(root1, target);
        }

        public TreeNode dfs(TreeNode root, int val) {
            root.val = val;
//            System.out.println(root.val);
            if (root.left != null) {
                dfs(root.left, 2 * root.val + 1);
            }
            if (root.right != null) {
                dfs(root.right, 2 * root.val + 2);
            }
            return root;
        }

        public boolean dfs2(TreeNode root, int target) {
//            System.out.println(root.val + ".." + target);
            if (root.val == target) return true;
            if (root.left != null) {
                boolean b = dfs2(root.left, target);
                if (b) return true;
            }
            if (root.right != null) {
                boolean b = dfs2(root.right, target);
                if (b) return true;
            }
            return false;
        }

        public void dfs3(TreeNode root) {
            System.out.println(root.val);
            if (root.left != null) {
                dfs3(root.left);
            }
            if (root.right != null) {
                dfs3(root.right);
            }
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}