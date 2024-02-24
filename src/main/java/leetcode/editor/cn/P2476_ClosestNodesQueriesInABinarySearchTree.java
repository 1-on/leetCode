//给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。 
//
// 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ： 
//
// 
// mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。 
// maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。 
// 
//
// 返回数组 answer 。 
//
// 
//
// 示例 1 ： 
//
// 
//
// 
//输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,1
//6]
//输出：[[2,2],[4,6],[15,-1]]
//解释：按下面的描述找出并返回查询的答案：
//- 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
//- 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
//- 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
// 
//
// 示例 2 ： 
//
// 
//
// 
//输入：root = [4,null,9], queries = [3]
//输出：[[-1,4]]
//解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [2, 10⁵] 内 
// 1 <= Node.val <= 10⁶ 
// n == queries.length 
// 1 <= n <= 10⁵ 
// 1 <= queries[i] <= 10⁶ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 数组 二分查找 二叉树 👍 64 👎 0


package leetcode.editor.cn;

import com.yixian.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树最近节点查询
 *
 * @author DY
 * @date 2024-02-24 22:18:21
 */
public class P2476_ClosestNodesQueriesInABinarySearchTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2476_ClosestNodesQueriesInABinarySearchTree().new Solution();
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
        List<Integer> arr = new ArrayList<>();

        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root);
            System.out.println(arr);
            for (Integer query : queries) {
                List<Integer> list = new ArrayList<>();
                int x1 = search1(query);
                int x2 = search2(query);
                int ans1 = arr.get(x1) > query ? -1 : arr.get(x1);
                int ans2 = arr.get(x2) < query ? -1 : arr.get(x2);
//                System.out.println(x1 + " " + x2);
                list.add(ans1);
                list.add(ans2);
                res.add(list);
            }
            return res;
        }

        public void dfs(TreeNode root) {
            if (root.left != null) {
                dfs(root.left);
            }
            arr.add(root.val);
            if (root.right != null) {
                dfs(root.right);
            }
        }

        public int search1(int n) {
            int left = 0;
            int right = arr.size() - 1;
            int ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
//                System.out.println("mid1 " + mid);
                if (arr.get(mid) == n) return mid;
                if (arr.get(mid) > n) {
                    right = mid - 1;
                }
                if (arr.get(mid) < n) {
                    ans = mid;
                    left = mid + 1;
                }
            }
            return ans;
        }

        public int search2(int n) {
            int left = 0;
            int right = arr.size() - 1;
            int ans = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
//                System.out.println("mid2 " + mid);
                if (arr.get(mid) == n) return mid;
                if (arr.get(mid) > n) {
                    ans = mid;
                    right = mid - 1;
                }
                if (arr.get(mid) < n) {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}