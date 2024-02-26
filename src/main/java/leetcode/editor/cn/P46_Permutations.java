//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2819 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @author DY
 * @date 2024-02-26 21:35:45
 */
public class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int[] flag;

        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            flag = new int[n];
            if (nums == null) {
                return res;
            }
            dfs(n, new ArrayList<>(), nums);
            return res;

        }

        public void dfs(int n, List<Integer> cur, int[] nums) {
            if (cur.size() == n) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (flag[i] == 0) {
                    cur.add(nums[i]);
                    flag[i] = 1;
                    dfs(n, cur, nums);
                    flag[i] = 0;
                    cur.remove(cur.size() - 1);
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}