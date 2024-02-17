//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6694 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 三数之和
 *
 * @author DY
 * @date 2024-02-17 14:53:28
 */
public class P15_ThreeSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P15_ThreeSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Map<List<Integer>, Integer> map = new HashMap<>();
            Map<Integer, Integer> has = new HashMap<>();

            int n = nums.length;

            for (int i = 0; i < n; i++) {
                has.putIfAbsent(nums[i], i);
            }

            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int target = -nums[i] - nums[j];
                    if (has.get(target) != null) {
                        int k = has.get(target);
                        if (i != j && i != k && j != k) {
                            if (nums[i] + nums[j] + nums[k] == 0) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                Collections.sort(list);
                                if (map.get(list) == null) {
                                    res.add(list);
                                    map.put(list, 1);
                                }

                            }
                        }
                    }


                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}