//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1221 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author DY
 * @date 2024-02-25 23:20:16
 */
public class P235_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P235_LowestCommonAncestorOfABinarySearchTree().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Integer> visit = new HashMap<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, null);
            dfs2(p);
            TreeNode res = dfs3(q);

            System.out.println(res.val);
            return res;
        }

        public void dfs(TreeNode root, TreeNode parent) {
            parentMap.put(root, parent);
            if (root.left != null) {
                dfs(root.left, root);
            }
            if (root.right != null) {
                dfs(root.right, root);
            }
        }

        public void dfs2(TreeNode root) {
            visit.put(root, 1);
            if (parentMap.get(root) != null) {
                dfs2(parentMap.get(root));
            }
        }

        public TreeNode dfs3(TreeNode root) {
            if (visit.get(root) != null) {
                return root;
            }
            if (parentMap.get(root) != null) {
                return dfs3(parentMap.get(root));
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}